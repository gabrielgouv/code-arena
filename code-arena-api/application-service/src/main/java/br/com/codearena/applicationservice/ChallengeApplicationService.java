package br.com.codearena.applicationservice;

import br.com.codearena.applicationservice.contract.IChallengeApplicationService;
import br.com.codearena.applicationservice.exception.NotFoundException;
import br.com.codearena.domain.entity.Challenge;
import br.com.codearena.domain.entity.User;
import br.com.codearena.domainservice.contract.IChallengeDomainService;
import br.com.codearena.domainservice.contract.IUserDomainService;
import br.com.codearena.vo.challenge.ChallengeInputVO;
import br.com.codearena.vo.challenge.ChallengeOutputVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ChallengeApplicationService implements IChallengeApplicationService {

    private IChallengeDomainService challengeDomainService;
    private IUserDomainService userDomainService;
    private ModelMapper modelMapper;

    @Autowired
    public ChallengeApplicationService(IChallengeDomainService challengeDomainService,
                                       IUserDomainService userDomainService,
                                       ModelMapper modelMapper) {
        this.challengeDomainService = challengeDomainService;
        this.userDomainService = userDomainService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChallengeOutputVO create(Long authorId, ChallengeInputVO challengeInputVO) {
        Challenge challenge = modelMapper.map(challengeInputVO, Challenge.class);
        challenge.setId(null);

        Optional<User> userOptional = userDomainService.findById(authorId);

        if (!userOptional.isPresent()) {
            throw new NotFoundException("User not found");
        }

        challenge.setAuthor(userOptional.get());

        challenge = challengeDomainService.save(challenge);

        ChallengeOutputVO challengeOutputVO = modelMapper.map(challenge, ChallengeOutputVO.class);
        challengeOutputVO.setContent(null); // Não é necessário retornar o contéudo

        return challengeOutputVO;
    }

    @Override
    public List<ChallengeOutputVO> findAll() {

        List<Challenge> challenges = challengeDomainService.findAll();
        List<ChallengeOutputVO> challengeOutputVOs = new ArrayList<>();

        for (Challenge challenge : challenges) {
            challengeOutputVOs.add(modelMapper.map(challenge, ChallengeOutputVO.class));
        }

        return challengeOutputVOs;
    }

    @Override
    public List<ChallengeOutputVO> findAllWithUser(Long userId) {
        List<Challenge> challenges = challengeDomainService.findAll();
        List<ChallengeOutputVO> challengeOutputVOs = new ArrayList<>();

        Optional<User> userOptional = userDomainService.findById(userId);

        if (!userOptional.isPresent()) {
            throw new NotFoundException("User not found");
        }

        User user = userOptional.get();

        for (Challenge challenge : challenges) {
            ChallengeOutputVO challengeOutputVO = modelMapper.map(challenge, ChallengeOutputVO.class);
            if (challenge.getUsersWhoSolved().contains(user)) {
                challengeOutputVO.setUserSolved(true);
            }
            challengeOutputVOs.add(challengeOutputVO);
        }

        return challengeOutputVOs;
    }

    @Override
    public List<ChallengeOutputVO> findAllByAuthor(Long userId) {
        Optional<User> userOptional  = userDomainService.findById(userId);

        if (!userOptional.isPresent()) {
            throw new NotFoundException("User not found");
        }

        List<Challenge> challenges = challengeDomainService.findAllByAuthor(userOptional.get());

        List<ChallengeOutputVO> challengeOutputVOs = new ArrayList<>();

        for (Challenge challenge : challenges) {
            challengeOutputVOs.add(modelMapper.map(challenge, ChallengeOutputVO.class));
        }

        return challengeOutputVOs;
    }

    @Override
    public void finishChallenge(Long challengeId, Long userId) {
        Optional<Challenge> challengeOptional = challengeDomainService.findById(challengeId);

        if (!challengeOptional.isPresent()) {
            throw new NotFoundException("Challenge not found");
        }

        Challenge challenge = challengeOptional.get();

        Optional<User> userOptional = userDomainService.findById(userId);

        if (!userOptional.isPresent()) {
            throw new NotFoundException("User not found");
        }

        User user = userOptional.get();

        user.getSolvedChallenges().add(challenge);

        userDomainService.save(user);

    }

}

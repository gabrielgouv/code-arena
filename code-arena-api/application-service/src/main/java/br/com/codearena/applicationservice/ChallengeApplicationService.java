package br.com.codearena.applicationservice;

import br.com.codearena.applicationservice.contract.IChallengeApplicationService;
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

@Service
public class ChallengeApplicationService implements IChallengeApplicationService {

    private IChallengeDomainService challengeDomainService;
    private IUserDomainService userDomainService;
    private ModelMapper modelMapper;

    @Autowired
    public ChallengeApplicationService(IChallengeDomainService challengeDomainService, IUserDomainService userDomainService, ModelMapper modelMapper) {
        this.challengeDomainService = challengeDomainService;
        this.userDomainService = userDomainService;
        this.modelMapper = modelMapper;
    }

    @Override
    public ChallengeOutputVO create(ChallengeInputVO challengeInputVO) {
        Challenge challenge = modelMapper.map(challengeInputVO, Challenge.class);
        challenge.setId(null);

        User user = userDomainService.findById(challengeInputVO.getAuthorId());
        challenge.setAuthor(user);

        challenge = challengeDomainService.save(challenge);

        return modelMapper.map(challenge, ChallengeOutputVO.class);
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
    public List<ChallengeOutputVO> findAllByAuthor(Long userId) {
        User user  = userDomainService.findById(userId);
        List<Challenge> challenges = challengeDomainService.findAllByAuthor(user);

        List<ChallengeOutputVO> challengeOutputVOs = new ArrayList<>();

        for (Challenge challenge : challenges) {
            challengeOutputVOs.add(modelMapper.map(challenge, ChallengeOutputVO.class));
        }

        return challengeOutputVOs;
    }

}

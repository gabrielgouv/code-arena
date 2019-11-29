package br.com.codearena.applicationservice;

import br.com.codearena.applicationservice.exception.IllegalOperationException;
import br.com.codearena.applicationservice.exception.NotFoundException;
import br.com.codearena.domain.entity.Challenge;
import br.com.codearena.domainservice.contract.IChallengeDomainService;
import br.com.codearena.domainservice.contract.IUserDomainService;
import br.com.codearena.domain.entity.User;
import br.com.codearena.applicationservice.contract.IUserApplicationService;
import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class UserApplicationService implements IUserApplicationService {

    private IUserDomainService userDomainService;
    private IChallengeDomainService challengeDomainService;
    private ModelMapper mapper;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserApplicationService(
            IUserDomainService userDomainService,
            IChallengeDomainService challengeDomainService,
            ModelMapper mapper,
            PasswordEncoder passwordEncoder) {
        this.userDomainService = userDomainService;
        this.challengeDomainService = challengeDomainService;
        this.mapper = mapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserOutputVO create(UserInputVO userInputVO) {
        userInputVO.setPassword(passwordEncoder.encode(userInputVO.getPassword()));
        User user = mapper.map(userInputVO, User.class);
        user = this.userDomainService.save(user);
        return mapper.map(user, UserOutputVO.class);
    }

    @Override
    public UserOutputVO searchById(Long id) {
        User user = userDomainService.findById(id);
        return mapper.map(user, UserOutputVO.class);
    }

    @Override
    public List<UserOutputVO> findByFirstName(String firstName) {
        List<User> users = userDomainService.findByFirstName(firstName);
        List<UserOutputVO> userOutputVOs = new ArrayList<>();

        for (User user : users) {
            userOutputVOs.add(mapper.map(user, UserOutputVO.class));
        }

        return userOutputVOs;
    }

    @Override
    public UserOutputVO findByEmail(String email) {
        User user = userDomainService.findByEmail(email);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        return mapper.map(user, UserOutputVO.class);
    }

    @Override
    public UserOutputVO findByEmailAndPassword(String email, String password) {
        User user = userDomainService.findByEmail(email);

        if (passwordEncoder.matches(password, user.getPassword())) {
            return mapper.map(user, UserOutputVO.class);
        }

        throw new NotFoundException("User not found");
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void addChallengeToFavorites(Long userId, Long challengeId) {
        User user = userDomainService.findById(userId);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        Challenge challenge = challengeDomainService.findById(challengeId);

        if (challenge == null) {
            throw new NotFoundException("Challenge not found");
        }

        Set<Challenge> userFavoriteChallenges = user.getFavoriteChallenges();

        if (userFavoriteChallenges.contains(challenge)) {
            throw new IllegalOperationException("Challenge is already user favorite");
        }

        userFavoriteChallenges.add(challenge);

        user.setFavoriteChallenges(userFavoriteChallenges);

        userDomainService.save(user);
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public void removeChallengeFromFavorites(Long userId, Long challengeId) {
        User user = userDomainService.findById(userId);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        Challenge challenge = challengeDomainService.findById(challengeId);

        if (challenge == null) {
            throw new NotFoundException("Challenge not found");
        }

        Set<Challenge> userFavoriteChallenges = user.getFavoriteChallenges();

        boolean removed = userFavoriteChallenges.remove(challenge);

        if (removed) {
            userDomainService.save(user);
        } else {
            throw new NotFoundException("Challenge not found in favorites");
        }
    }

    @Override
    public List<UserOutputVO> findAll() {
        List<User> users = userDomainService.findAll();
        List<UserOutputVO> userOutputVOs = new ArrayList<>();

        for (User user : users) {
            userOutputVOs.add(mapper.map(user, UserOutputVO.class));
        }

        return userOutputVOs;
    }

    @Override
    public UserOutputVO findByUsername(String username) {
        User user = userDomainService.findByUsername(username);
        return  mapper.map(user, UserOutputVO.class);
    }

    @Override
    public List<ChallengeOutputVO> findFavoritesChallengesFromUser(Long id) {
        User user = userDomainService.findById(id);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        Set<Challenge> favoriteChallenges = user.getFavoriteChallenges();
        List<ChallengeOutputVO> favoriteChallengesVO = new ArrayList<>();

        for (Challenge c : favoriteChallenges) {
            favoriteChallengesVO.add(mapper.map(c, ChallengeOutputVO.class));
        }

        return favoriteChallengesVO;
    }

}

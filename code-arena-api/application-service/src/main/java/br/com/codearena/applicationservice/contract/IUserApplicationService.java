package br.com.codearena.applicationservice.contract;

import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

import java.util.List;

public interface IUserApplicationService {

    UserOutputVO create(UserInputVO user);
    UserOutputVO searchById(Long id);
    List<UserOutputVO> findByFirstName(String firstName);
    UserOutputVO findByEmail(String email);
    UserOutputVO findByEmailAndPassword(String email, String password);
    void addChallengeToFavorites(Long userId, Long challengeId);
    void removeChallengeFromFavorites(Long userId, Long challengeId);
    List<UserOutputVO> findAll();
    UserOutputVO findByUsername(String username);
    List<ChallengeOutputVO> findFavoritesChallengesFromUser(Long id);
    void disableUser(Long removedByUserId, Long id);
    void enableUser(Long enabledByUserId, Long id);
    UserOutputVO findByUsernameAndPassword(String username, String password);
}

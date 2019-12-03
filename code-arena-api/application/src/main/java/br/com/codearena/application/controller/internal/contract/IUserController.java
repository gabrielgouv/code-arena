package br.com.codearena.application.controller.internal.contract;

import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IUserController {

    UserOutputVO create(UserInputVO user);
    UserOutputVO searchById(Long id);
    List<UserOutputVO> searchByFirstName(String firstName);
    UserOutputVO findByEmail(String email);
    UserOutputVO findByEmailAndPassword(String email, String password);
    void addChallengeToFavorites(HttpServletRequest httpServletRequest, Long challengeId);
    void removeChallengeFromFavorites(Long userId, Long challengeId);
    List<UserOutputVO> findAll();
    UserOutputVO findByUsername(String username);
    List<ChallengeOutputVO> findFavoritesChallengesFromUser(Long id);
    List<ChallengeOutputVO> findCreatedChallengesFromUser(Long userId);

}

package br.com.codearena.application.controller.contract;

import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

import java.util.List;

public interface IUserController {

    UserOutputVO create(UserInputVO user);
    UserOutputVO searchById(Long id);
    List<UserOutputVO> searchByFirstName(String firstName);
    UserOutputVO findByEmail(String email);
    UserOutputVO findByEmailAndPassword(String email, String password);
    void addChallengeToFavorites(Long userId, Long challengeId);
    void removeChallengeFromFavorites(Long userId, Long challengeId);
    List<UserOutputVO> findAll();

}

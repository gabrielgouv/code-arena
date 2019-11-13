package br.com.codearena.controller.contract;

import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IUserController {

    UserOutputVO create(UserInputVO user);
    UserOutputVO searchById(Long id);
    List<UserOutputVO> searchByFirstName(String firstName);
    UserOutputVO findByEmail(String email);
    UserOutputVO findByEmailAndPassword(String email, String password);
    void addChallengeToFavorites(Long userId, Long challengeId);
    List<UserOutputVO> findAll();

}

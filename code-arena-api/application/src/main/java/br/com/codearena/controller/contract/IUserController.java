package br.com.codearena.controller.contract;

import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

import java.util.List;

public interface IUserController {

    UserOutputVO create(UserInputVO user);
    UserOutputVO searchById(Long id);
    List<UserOutputVO> searchByFirstName(String firstName);
    UserOutputVO findByEmailAndPassword(String email, String password);

}

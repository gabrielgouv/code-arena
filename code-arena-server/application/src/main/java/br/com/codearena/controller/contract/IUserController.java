package br.com.codearena.controller.contract;

import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

public interface IUserController {

    UserOutputVO create(UserInputVO user);

}
package br.com.codearena.application.controller.external.contract;

import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

public interface IExternalUserController {

    UserOutputVO create(UserInputVO user);

}

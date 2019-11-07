package br.com.codearena.service.contract;

import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

public interface IUserService {

    UserOutputVO create(UserInputVO user);

}

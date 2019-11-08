package br.com.codearena.applicationservice.contract;

import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;

public interface IUserApplicationService {

    UserOutputVO create(UserInputVO user);

}

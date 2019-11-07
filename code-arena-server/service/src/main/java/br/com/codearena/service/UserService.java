package br.com.codearena.service;

import br.com.codearena.service.contract.IUserService;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Override
    public UserOutputVO create(UserInputVO user) {
        UserOutputVO userOutputVO = new UserOutputVO();
        userOutputVO.setId(1L);
        userOutputVO.setEmail("joao.gabriel@gmail.com");
        userOutputVO.setFirstName("João");
        userOutputVO.setLastName("Gabriel");
        return userOutputVO;
    }

}

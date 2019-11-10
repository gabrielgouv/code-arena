package br.com.codearena.applicationservice;

import br.com.codearena.domainservice.contract.IUserDomainService;
import br.com.codearena.domain.entity.User;
import br.com.codearena.applicationservice.contract.IUserApplicationService;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService implements IUserApplicationService {

    private IUserDomainService userDomainService;
    private ModelMapper mapper;

    @Autowired
    public UserApplicationService(IUserDomainService userDomainService, ModelMapper mapper) {
        this.userDomainService = userDomainService;
        this.mapper = mapper;
    }

    @Override
    public UserOutputVO create(UserInputVO userInputVO) {
        User user = mapper.map(userInputVO, User.class);
        user = this.userDomainService.save(user);
        return mapper.map(user, UserOutputVO.class);
    }

}

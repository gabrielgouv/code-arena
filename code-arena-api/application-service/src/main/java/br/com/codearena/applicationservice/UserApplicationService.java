package br.com.codearena.applicationservice;

import br.com.codearena.applicationservice.exception.NotFoundException;
import br.com.codearena.core.security.util.PasswordSecurityUtil;
import br.com.codearena.domainservice.contract.IUserDomainService;
import br.com.codearena.domain.entity.User;
import br.com.codearena.applicationservice.contract.IUserApplicationService;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        userInputVO.setPassword(PasswordSecurityUtil.hashPassword(userInputVO.getPassword()));
        User user = mapper.map(userInputVO, User.class);
        user = this.userDomainService.save(user);
        return mapper.map(user, UserOutputVO.class);
    }

    @Override
    public UserOutputVO searchById(Long id) {
        User user = userDomainService.findById(id);
        return mapper.map(user, UserOutputVO.class);
    }

    @Override
    public List<UserOutputVO> findByFirstName(String firstName) {
        List<User> users = userDomainService.findByFirstName(firstName);
        List<UserOutputVO> userOutputVOs = new ArrayList<>();

        for (User user : users) {
            userOutputVOs.add(mapper.map(user, UserOutputVO.class));
        }

        return userOutputVOs;
    }

    @Override
    public UserOutputVO findByEmail(String email) {
        User user = userDomainService.findByEmail(email);

        if (user == null) {
            throw new NotFoundException("User not found");
        }

        return mapper.map(user, UserOutputVO.class);
    }

    @Override
    public UserOutputVO findByEmailAndPassword(String email, String password) {
        User user = userDomainService.findByEmail(email);

        if (PasswordSecurityUtil.verifyHash(password, user.getPassword())) {
            return mapper.map(user, UserOutputVO.class);
        }

        throw new NotFoundException("User not found");

    }

}

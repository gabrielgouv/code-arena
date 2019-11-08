package br.com.codearena.service;

import br.com.codearena.entity.User;
import br.com.codearena.repository.IUserRepository;
import br.com.codearena.service.contract.IUserService;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private IUserRepository userRepository;
    private ModelMapper mapper;

    @Autowired
    public UserService(IUserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserOutputVO create(UserInputVO userInputVO) {
        User user = mapper.map(userInputVO, User.class);
        user = this.userRepository.save(user);
        return mapper.map(user, UserOutputVO.class);
    }

}

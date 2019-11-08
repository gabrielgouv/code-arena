package br.com.codearena.service;

import br.com.codearena.entity.User;
import br.com.codearena.repository.UserRepository;
import br.com.codearena.service.contract.IUserService;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private ModelMapper mapper;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    @Override
    public UserOutputVO create(UserInputVO userInputVO) {

//        String dateOfBirthString = userVO.getDateOfBirth();
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//        LocalDate dateTime = LocalDate.parse(dateOfBirthString, formatter);

        User user = mapper.map(userInputVO, User.class);
//        user.setDateOfBirth(dateTime);
        user = this.userRepository.save(user);
        return mapper.map(user, UserOutputVO.class);
    }

}

package br.com.codearena.domainservice;

import br.com.codearena.domainservice.contract.IUserDomainService;
import br.com.codearena.entity.User;
import br.com.codearena.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDomainService implements IUserDomainService {

    private IUserRepository userRepository;

    @Autowired
    public UserDomainService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

}
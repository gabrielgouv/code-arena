package br.com.codearena.domainservice;

import br.com.codearena.domainservice.contract.IUserDomainService;
import br.com.codearena.domain.entity.User;
import br.com.codearena.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstNameContaining(firstName);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}

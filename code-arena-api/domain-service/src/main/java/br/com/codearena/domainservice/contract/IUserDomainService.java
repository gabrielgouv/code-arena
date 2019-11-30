package br.com.codearena.domainservice.contract;

import br.com.codearena.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserDomainService {

    User save(User user);
    Optional<User> findById(Long id);
    List<User> findByFirstName(String firstName);
    User findByEmail(String email);
    List<User> findAll();
    User findByUsername(String username);

}

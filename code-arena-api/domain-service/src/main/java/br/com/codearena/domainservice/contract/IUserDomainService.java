package br.com.codearena.domainservice.contract;

import br.com.codearena.domain.entity.User;

import java.util.List;

public interface IUserDomainService {

    User save(User user);
    User findById(Long id);
    List<User> findByFirstName(String firstName);
    User findByEmail(String email);

}

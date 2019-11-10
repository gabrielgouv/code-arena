package br.com.codearena.domainservice.contract;

import br.com.codearena.domain.entity.User;

public interface IUserDomainService {

    User save(User user);
    User findById(Long id);

}

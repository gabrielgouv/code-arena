package br.com.codearena.repository;

import br.com.codearena.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRepository extends JpaRepository<User, Long> {

    List<User> findByFirstNameContaining(String firstName);
    User findByEmail(String email);
    User findByUsername(String username);

}

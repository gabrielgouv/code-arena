package br.com.codearena.repository;

import br.com.codearena.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {

}

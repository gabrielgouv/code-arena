package br.com.codearena.repository;

import br.com.codearena.domain.entity.Challenge;
import br.com.codearena.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IChallengeRepository extends JpaRepository<Challenge, Long> {

    List<Challenge> findAllByAuthor(User author);

}

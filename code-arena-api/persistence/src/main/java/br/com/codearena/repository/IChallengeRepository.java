package br.com.codearena.repository;

import br.com.codearena.domain.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IChallengeRepository extends JpaRepository<Challenge, Long> {

}

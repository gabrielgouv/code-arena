package br.com.codearena.domainservice.contract;

import br.com.codearena.domain.entity.Challenge;
import br.com.codearena.domain.entity.User;

import java.util.List;

public interface IChallengeDomainService {

    Challenge save(Challenge challenge);
    Challenge findById(Long id);
    List<Challenge> findAll();
    List<Challenge> findAllByAuthor(User user);

}

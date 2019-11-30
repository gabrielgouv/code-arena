package br.com.codearena.domainservice;

import br.com.codearena.domain.entity.Challenge;
import br.com.codearena.domain.entity.User;
import br.com.codearena.domainservice.contract.IChallengeDomainService;
import br.com.codearena.repository.IChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeDomainService implements IChallengeDomainService {

    private IChallengeRepository challengeRepository;

    @Autowired
    public ChallengeDomainService(IChallengeRepository challengeRepository) {
        this.challengeRepository = challengeRepository;
    }

    @Override
    public Challenge save(Challenge challenge) {
        return challengeRepository.save(challenge);
    }

    @Override
    public Optional<Challenge> findById(Long id) {
        return challengeRepository.findById(id);
    }

    @Override
    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }

    @Override
    public List<Challenge> findAllByAuthor(User user) {
        return challengeRepository.findAllByAuthor(user);
    }

}

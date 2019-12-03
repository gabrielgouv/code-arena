package br.com.codearena.applicationservice.contract;

import br.com.codearena.vo.challenge.ChallengeInputVO;
import br.com.codearena.vo.challenge.ChallengeOutputVO;

import java.util.List;


public interface IChallengeApplicationService {

    ChallengeOutputVO create(Long authorId, ChallengeInputVO challengeInputVO);
    List<ChallengeOutputVO> findAll();
    List<ChallengeOutputVO> findAllWithUser(Long userId);
    List<ChallengeOutputVO> findAllByAuthor(Long userId);
    void finishChallenge(Long challengeId, Long userId);
    ChallengeOutputVO searchById(Long id);

}

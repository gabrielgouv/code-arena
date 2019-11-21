package br.com.codearena.applicationservice.contract;

import br.com.codearena.vo.challenge.ChallengeInputVO;
import br.com.codearena.vo.challenge.ChallengeOutputVO;

import java.util.List;


public interface IChallengeApplicationService {

    ChallengeOutputVO create(ChallengeInputVO challengeInputVO);
    List<ChallengeOutputVO> findAll();
    List<ChallengeOutputVO> findAllByAuthor(Long userId);

}

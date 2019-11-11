package br.com.codearena.applicationservice.contract;

import br.com.codearena.vo.challenge.ChallengeInputVO;
import br.com.codearena.vo.challenge.ChallengeOutputVO;


public interface IChallengeApplicationService {

    ChallengeOutputVO create(ChallengeInputVO challengeInputVO);

}

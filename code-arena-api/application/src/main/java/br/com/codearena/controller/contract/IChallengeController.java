package br.com.codearena.controller.contract;

import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.challenge.ChallengeInputVO;

import java.util.List;

public interface IChallengeController {

    ChallengeOutputVO create(ChallengeInputVO challengeInputVO);
    List<ChallengeOutputVO> findAll();

}

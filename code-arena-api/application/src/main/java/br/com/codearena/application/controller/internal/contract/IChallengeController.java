package br.com.codearena.application.controller.internal.contract;

import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.challenge.ChallengeInputVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IChallengeController {

    ChallengeOutputVO create(ChallengeInputVO challengeInputVO);
    List<ChallengeOutputVO> findAll();
    List<ChallengeOutputVO> findAllWithUser(HttpServletRequest httpServletRequest);
    void finishChallenge(HttpServletRequest httpServletRequest, Long id);
}

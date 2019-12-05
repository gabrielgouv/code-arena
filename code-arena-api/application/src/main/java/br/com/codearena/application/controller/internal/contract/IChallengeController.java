package br.com.codearena.application.controller.internal.contract;

import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.challenge.ChallengeInputVO;
import br.com.codearena.vo.challenge.ChallengeSolutionVO;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface IChallengeController {

    ChallengeOutputVO create(HttpServletRequest httpServletRequest, ChallengeInputVO challengeInputVO);
    List<ChallengeOutputVO> findAll();
    List<ChallengeOutputVO> findAllWithUser(HttpServletRequest httpServletRequest);
    void finishChallenge(HttpServletRequest httpServletRequest, Long id);
    ChallengeOutputVO searchById( Long id);
    void sendChallenge(HttpServletRequest httpServletRequest, ChallengeSolutionVO challengeSolutionVO);

}

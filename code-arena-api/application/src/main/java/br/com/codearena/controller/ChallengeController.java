package br.com.codearena.controller;

import br.com.codearena.applicationservice.contract.IChallengeApplicationService;
import br.com.codearena.controller.contract.IChallengeController;
import br.com.codearena.vo.challenge.ChallengeInputVO;
import br.com.codearena.vo.challenge.ChallengeOutputVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Challenge")
@RestController
public class ChallengeController implements IChallengeController {

    private IChallengeApplicationService challengeApplicationService;

    @Autowired
    public ChallengeController(IChallengeApplicationService challengeApplicationService) {
        this.challengeApplicationService = challengeApplicationService;
    }

    @Override
    @PostMapping(value = "/challenge/create")
    public ChallengeOutputVO create(ChallengeInputVO challengeInputVO) {
        return challengeApplicationService.create(challengeInputVO);
    }

    @Override
    @GetMapping(value = "/challenge/findAll")
    public List<ChallengeOutputVO> findAll() {
        return challengeApplicationService.findAll();
    }

}

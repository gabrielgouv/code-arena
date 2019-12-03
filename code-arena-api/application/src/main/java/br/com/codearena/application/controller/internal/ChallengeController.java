package br.com.codearena.application.controller.internal;

import br.com.codearena.application.helper.AuthenticatedUserHelper;
import br.com.codearena.applicationservice.ChallengeApplicationService;
import br.com.codearena.applicationservice.contract.IChallengeApplicationService;
import br.com.codearena.application.controller.internal.contract.IChallengeController;
import br.com.codearena.vo.challenge.ChallengeInputVO;
import br.com.codearena.vo.challenge.ChallengeOutputVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(tags = "Challenge")
@RequestMapping(value = "/challenge")
@RestController
public class ChallengeController implements IChallengeController {

    private IChallengeApplicationService challengeApplicationService;
    private AuthenticatedUserHelper authenticatedUserHelper;

    @Autowired
    public ChallengeController(IChallengeApplicationService challengeApplicationService,
                               AuthenticatedUserHelper authenticatedUserHelper) {
        this.challengeApplicationService = challengeApplicationService;
        this.authenticatedUserHelper = authenticatedUserHelper;
    }

    @Override
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ChallengeOutputVO create(HttpServletRequest httpServletRequest, @RequestBody ChallengeInputVO challengeInputVO) {
        Long userId = authenticatedUserHelper.getAuthenticatedUser(httpServletRequest).getId();
        return challengeApplicationService.create(userId, challengeInputVO);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<ChallengeOutputVO> findAll() {
        return challengeApplicationService.findAll();
    }

    @Override
    @GetMapping(value = "/findAllWithUser")
    public List<ChallengeOutputVO> findAllWithUser(HttpServletRequest httpServletRequest) {
        Long userId = authenticatedUserHelper.getAuthenticatedUser(httpServletRequest).getId();
        return challengeApplicationService.findAllWithUser(userId);
    }

    @Override
    @PutMapping(value = "/finishChallenge/{id}")
    public void finishChallenge(HttpServletRequest httpServletRequest, @PathVariable Long id) {
        Long userId = authenticatedUserHelper.getAuthenticatedUser(httpServletRequest).getId();
        challengeApplicationService.finishChallenge(id, userId);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ChallengeOutputVO searchById(@PathVariable Long id) {
        return challengeApplicationService.searchById(id);
    }


}

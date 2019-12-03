package br.com.codearena.application.controller.internal;

import br.com.codearena.application.controller.internal.contract.BaseController;
import br.com.codearena.application.controller.internal.contract.IUserController;
import br.com.codearena.application.helper.AuthenticatedUserHelper;
import br.com.codearena.applicationservice.contract.IChallengeApplicationService;
import br.com.codearena.applicationservice.contract.IUserApplicationService;
import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Api(tags = "User")
@RequestMapping(value = "/user")
@RestController
public class UserController extends BaseController implements IUserController {

    private IUserApplicationService userService;
    private IChallengeApplicationService challengeApplicationService;
    private AuthenticatedUserHelper authenticatedUserHelper;

    @Autowired
    public UserController(IUserApplicationService userService,
                          IChallengeApplicationService challengeApplicationService,
                          AuthenticatedUserHelper authenticatedUserHelper) {
        this.userService = userService;
        this.challengeApplicationService = challengeApplicationService;
        this.authenticatedUserHelper = authenticatedUserHelper;
    }

    @Override
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserOutputVO create(@RequestBody UserInputVO user) {
        return userService.create(user);
    }

    @Override
    @GetMapping(value = "/{id}")
    public UserOutputVO searchById(@PathVariable Long id) {
        return userService.searchById(id);
    }

    @Override
    @GetMapping(value = "/searchByFirstName")
    public List<UserOutputVO> searchByFirstName(@RequestParam String firstName) {
        return userService.findByFirstName(firstName);
    }

    @Override
    @GetMapping(value = "/findByEmail")
    public UserOutputVO findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @Override
    @ResponseBody
    @PostMapping(value = "/findByEmailAndPassword")
    public UserOutputVO findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return userService.findByEmailAndPassword(email, password);
    }

    @Override
    @PutMapping(value = "/addChallengeToFavorites")
    public void addChallengeToFavorites(HttpServletRequest httpServletRequest, @RequestParam Long challengeId) {
        Long userId = authenticatedUserHelper.getAuthenticatedUser(httpServletRequest).getId();
        userService.addChallengeToFavorites(userId, challengeId);
    }

    @Override
    @PutMapping(value = "/removeChallengeFromFavorites")
    public void removeChallengeFromFavorites(Long userId, Long challengeId) {
        userService.removeChallengeFromFavorites(userId, challengeId);
    }

    @Override
    @GetMapping(value = "/findAll")
    public List<UserOutputVO> findAll() {
        return userService.findAll();
    }

    @Override
    @GetMapping(value = "/username/{username}")
    public UserOutputVO findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @Override
    @GetMapping(value = "/{id}/challenges/favorites")
    public List<ChallengeOutputVO> findFavoritesChallengesFromUser(@PathVariable Long id) {
        return userService.findFavoritesChallengesFromUser(id);
    }

    @Override
    @GetMapping(value = "/{id}/challenges")
    public List<ChallengeOutputVO> findCreatedChallengesFromUser(@PathVariable Long id) {
        return challengeApplicationService.findAllByAuthor(id);
    }

}

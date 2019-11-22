package br.com.codearena.application.controller;

import br.com.codearena.application.controller.contract.BaseController;
import br.com.codearena.application.controller.contract.IUserController;
import br.com.codearena.applicationservice.contract.IChallengeApplicationService;
import br.com.codearena.applicationservice.contract.IUserApplicationService;
import br.com.codearena.vo.challenge.ChallengeOutputVO;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Api(tags = "User")
@RestController
public class UserController extends BaseController implements IUserController {

    private IUserApplicationService userService;
    private IChallengeApplicationService challengeApplicationService;

    @Autowired
    public UserController(IUserApplicationService userService, IChallengeApplicationService challengeApplicationService) {
        this.userService = userService;
        this.challengeApplicationService = challengeApplicationService;
    }

    @Override
    @PostMapping(value = "/user/create")
    public UserOutputVO create(@ModelAttribute UserInputVO user) {
        return userService.create(user);
    }

    @Override
    @GetMapping(value = "/user/{id}")
    public UserOutputVO searchById(@PathVariable Long id) {
        return userService.searchById(id);
    }

    @Override
    @GetMapping(value = "/user/searchByFirstName")
    public List<UserOutputVO> searchByFirstName(@RequestParam String firstName) {
        return userService.findByFirstName(firstName);
    }

    @Override
    @GetMapping(value = "/user/findByEmail")
    public UserOutputVO findByEmail(@RequestParam String email) {
        return userService.findByEmail(email);
    }

    @Override
    @ResponseBody
    @PostMapping(value = "/user/findByEmailAndPassword")
    public UserOutputVO findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return userService.findByEmailAndPassword(email, password);
    }

    @Override
    @PutMapping(value = "/user/addChallengeToFavorites")
    public void addChallengeToFavorites(HttpServletRequest httpServletRequest, @RequestParam Long challengeId) {
        Long userId = getAuthenticatedUserId(httpServletRequest);
        userService.addChallengeToFavorites(userId, challengeId);
    }

    @Override
    @PutMapping(value = "/user/removeChallengeFromFavorites")
    public void removeChallengeFromFavorites(Long userId, Long challengeId) {
        userService.removeChallengeFromFavorites(userId, challengeId);
    }

    @Override
    @GetMapping(value = "/user/findAll")
    public List<UserOutputVO> findAll() {
        return userService.findAll();
    }

    @Override
    @GetMapping(value = "/user/username/{username}")
    public UserOutputVO findByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @Override
    @GetMapping(value = "/user/{id}/challenges/favorites")
    public List<ChallengeOutputVO> findFavoritesChallengesFromUser(@PathVariable Long id) {
        return userService.findFavoritesChallengesFromUser(id);
    }

    @Override
    @GetMapping(value = "/user/{id}/challenges")
    public List<ChallengeOutputVO> findCreatedChallengesFromUser(@PathVariable Long id) {
        return challengeApplicationService.findAllByAuthor(id);
    }

}

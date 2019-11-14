package br.com.codearena.application.controller;

import br.com.codearena.application.controller.contract.IUserController;
import br.com.codearena.applicationservice.contract.IUserApplicationService;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "User")
@RestController
public class UserController implements IUserController {

    private IUserApplicationService userService;

    @Autowired
    public UserController(IUserApplicationService userService) {
        this.userService = userService;
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
    @GetMapping(value = "/user")
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
    public void addChallengeToFavorites(@RequestParam Long userId, @RequestParam Long challengeId) {
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

}

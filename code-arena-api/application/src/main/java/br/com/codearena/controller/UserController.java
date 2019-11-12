package br.com.codearena.controller;

import br.com.codearena.controller.contract.IUserController;
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
    @PostMapping(value = "/user")
    public UserOutputVO findByEmailAndPassword(@RequestParam String email, @RequestParam String password) {
        return userService.findByEmailAndPassword(email, password);
    }

}

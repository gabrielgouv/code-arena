package br.com.codearena.controller;

import br.com.codearena.controller.contract.IUserController;
import br.com.codearena.service.contract.IUserService;
import br.com.codearena.vo.user.UserInputVO;
import br.com.codearena.vo.user.UserOutputVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController implements IUserController {

    private IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping(value = "/user/create")
    public UserOutputVO create(@ModelAttribute UserInputVO user) {
        return userService.create(user);
    }

}

package br.com.codearena.controller;

import br.com.codearena.controller.contract.IUserController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class UserController implements IUserController {

    @Override
    @GetMapping(value = "/users")
    public List<String> getUsers() {
        return Arrays.asList("João", "Maria", "Marcos");
    }

}

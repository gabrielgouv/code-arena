package br.com.codearena.application.controller.external;

import br.com.codearena.application.controller.external.contract.IExternalUserController;
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


@Api(tags = "User (external)")
@RequestMapping(value = "/external/user")
@RestController
public class ExternalUserController implements IExternalUserController {

    private IUserApplicationService userService;

    @Autowired
    public ExternalUserController(IUserApplicationService userService) {
        this.userService = userService;
    }

    @Override
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserOutputVO create(@RequestBody UserInputVO user) {
        return userService.create(user);
    }

}

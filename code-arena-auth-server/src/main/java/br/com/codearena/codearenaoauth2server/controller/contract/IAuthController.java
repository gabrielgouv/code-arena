package br.com.codearena.codearenaoauth2server.controller.contract;

import br.com.codearena.codearenaoauth2server.model.TokenValidation;
import br.com.codearena.codearenaoauth2server.model.vo.TokenAuthoritiesVO;
import org.springframework.http.ResponseEntity;

public interface IAuthController {

    ResponseEntity validateToken(String token);
    ResponseEntity<TokenValidation> validateAuthorities(TokenAuthoritiesVO tokenAuthoritiesVO);

}

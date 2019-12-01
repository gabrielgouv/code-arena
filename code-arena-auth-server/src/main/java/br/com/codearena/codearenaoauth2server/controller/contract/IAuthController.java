package br.com.codearena.codearenaoauth2server.controller.contract;

import org.springframework.http.ResponseEntity;

public interface IAuthController {

    ResponseEntity validateToken(String token);

}

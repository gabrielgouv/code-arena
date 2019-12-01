package br.com.codearena.codearenaoauth2server.controller;

import br.com.codearena.codearenaoauth2server.controller.contract.IAuthController;
import br.com.codearena.codearenaoauth2server.model.JwtConfiguration;
import br.com.codearena.codearenaoauth2server.model.TokenValidation;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthController implements IAuthController {

    private JwtConfiguration config;

    @Autowired
    public AuthController(JwtConfiguration config) {
        this.config = config;
    }

    @Override
    @PostMapping(value = "/validateToken")
    public ResponseEntity<TokenValidation> validateToken(String token) {

        if (token != null && token.startsWith(config.getPrefix() + " ")) {

            token = token.replace(config.getPrefix() + " ", "");

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(config.getSecret().getBytes())
                        .parseClaimsJws(token)
                        .getBody();
                String username = claims.getSubject();

                if (username != null) {
                   return ResponseEntity.ok(TokenValidation.validToken());
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(TokenValidation.invalidToken());
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(TokenValidation.invalidToken());

    }

}

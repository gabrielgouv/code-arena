package br.com.codearena.codearenaoauth2server.controller;

import br.com.codearena.codearenaoauth2server.controller.contract.IAuthController;
import br.com.codearena.codearenaoauth2server.model.JwtConfiguration;
import br.com.codearena.codearenaoauth2server.model.TokenValidation;
import br.com.codearena.codearenaoauth2server.model.vo.TokenAuthoritiesVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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

        // TODO: Refatorar. Codigo duplicado
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

    @Override
    @PostMapping(value = "/validateAuthorities", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TokenValidation> validateAuthorities(@RequestBody TokenAuthoritiesVO tokenAuthoritiesVO) {

        String token = tokenAuthoritiesVO.getToken();

        // TODO: Refatorar. Codigo duplicado
        if (token != null && token.startsWith(config.getPrefix() + " ")) {

            token = token.replace(config.getPrefix() + " ", "");

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(config.getSecret().getBytes())
                        .parseClaimsJws(token)
                        .getBody();
                String username = claims.getSubject();

                @SuppressWarnings("unchecked")
                List<String> authorities = claims.get("authorities", List.class);

                // TODO: Avaliar o uso do containsAll em outros casos, para o caso atual é funcional
                if (username != null
                        && authorities.containsAll(tokenAuthoritiesVO.getAuthorities())) {
                    return ResponseEntity.ok(TokenValidation.validToken());
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(TokenValidation.invalidToken());
            }
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(TokenValidation.invalidToken());
    }

}

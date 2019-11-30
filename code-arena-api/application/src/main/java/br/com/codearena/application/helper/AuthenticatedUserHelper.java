package br.com.codearena.application.helper;

import br.com.codearena.applicationservice.contract.IUserApplicationService;
import br.com.codearena.vo.user.UserOutputVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public final class AuthenticatedUserHelper {

    @Value("${code-arena.security.jwt.url:/getToken}")
    private String url;

    @Value("${code-arena.security.jwt.header:Authorization}")
    private String header;

    @Value("${code-arena.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${code-arena.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${code-arena.security.jwt.secret}")
    private String secret;

    private IUserApplicationService userApplicationService;

    @Autowired
    public AuthenticatedUserHelper(IUserApplicationService userApplicationService) {
        this.userApplicationService = userApplicationService;
    }

    public UserOutputVO getAuthenticatedUser(HttpServletRequest httpServletRequest) {
        String username = getUsernameFromJwtToken(httpServletRequest);
        return userApplicationService.findByUsername(username);
    }

    private String getUsernameFromJwtToken(HttpServletRequest httpServletRequest) {

        String token = httpServletRequest.getHeader(header);

        if (token != null && token.startsWith(prefix + " ")) {

            token = token.replace(prefix + " ", "");

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(secret.getBytes())
                        .parseClaimsJws(token)
                        .getBody();

                String username = claims.getSubject();

                if (username != null) {
                   return username;
                }

            } catch (Exception ex) {
                return null;
            }
        }
        return null;
    }
}

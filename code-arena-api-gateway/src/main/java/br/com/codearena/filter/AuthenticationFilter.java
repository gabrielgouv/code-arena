package br.com.codearena.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        String uri = currentContext.getRequest().getRequestURI();

        // Filtra tudo exceto a API de autenticação
        return !uri.startsWith("/auth");
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();

        // TODO: Fazer a requisição para o servidor de autorização:
        boolean autenticado = true;

        // Impede da requisição continuar caso não esteja autorizado
        if (!autenticado) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        } else {
            // TODO: Mudar para passar o objeto usuário inteiro
            // Adiciona o código do usuário autenticado no header, para ser pego no backstream (code-arena-api)
            currentContext.addZuulRequestHeader("logged-user-id", "1");
        }

        return null;
    }

}

package br.com.codearena.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
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
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        // Adiciona o código do usuário autenticado no header, para ser pego no backstream (code-arena-api)
        currentContext.addZuulRequestHeader("logged-user-id", "1");
        return null;
    }

}

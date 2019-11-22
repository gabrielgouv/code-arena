package br.com.codearena.application.controller.contract;

import javax.servlet.http.HttpServletRequest;

public abstract class BaseController {

    protected Long getAuthenticatedUserId(HttpServletRequest httpServletRequest) {
        return Long.parseLong(httpServletRequest.getHeader("logged-user-id"));
    }

}

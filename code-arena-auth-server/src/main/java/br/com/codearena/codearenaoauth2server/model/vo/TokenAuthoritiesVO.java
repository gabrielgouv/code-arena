package br.com.codearena.codearenaoauth2server.model.vo;

import java.io.Serializable;

public class TokenAuthoritiesVO implements Serializable {

    private String token;
    private String[] authorities;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String[] getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String[] authorities) {
        this.authorities = authorities;
    }

}

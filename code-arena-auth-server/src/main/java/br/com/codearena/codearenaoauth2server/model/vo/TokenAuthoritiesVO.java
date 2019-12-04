package br.com.codearena.codearenaoauth2server.model.vo;

import java.io.Serializable;
import java.util.List;

public class TokenAuthoritiesVO implements Serializable {

    private String token;
    private List<String> authorities;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

}

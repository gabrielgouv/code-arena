package br.com.codearena.codearenaoauth2server.model;

public class TokenValidation {

    private Boolean isValid;

    public TokenValidation(Boolean isValid) {
        this.isValid = isValid;
    }

    public static TokenValidation invalidToken() {
        return new TokenValidation(false);
    }

    public static TokenValidation validToken() {
        return new TokenValidation(true);
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

}

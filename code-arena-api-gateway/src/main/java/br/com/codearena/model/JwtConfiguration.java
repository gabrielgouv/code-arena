package br.com.codearena.model;

import org.springframework.beans.factory.annotation.Value;

public class JwtConfiguration {

    @Value("${code-arena.security.jwt.url:/login}")
    private String url;

    @Value("${code-arena.security.jwt.header:Authorization}")
    private String header;

    @Value("${code-arena.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${code-arena.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${code-arena.security.jwt.secret}")
    private String secret;

    public String getUrl() {
        return url;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationConfig [url=" + url + ", header=" + header + ", prefix=" + prefix + ", expiration="
                + expiration + ", secret=" + secret + "]";
    }

}

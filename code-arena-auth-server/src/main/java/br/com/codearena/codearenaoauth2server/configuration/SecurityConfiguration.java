package br.com.codearena.codearenaoauth2server.configuration;

import br.com.codearena.codearenaoauth2server.filter.JwtUsernamePasswordAuthenticationFilter;
import br.com.codearena.codearenaoauth2server.model.JwtConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@Component
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    JwtConfiguration jwtConfiguration;

    @Autowired
    DataSource dataSource;

    @Bean
    public JwtConfiguration jwtConfiguration() {
        return new JwtConfiguration();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username, password, true"
                        + " from users where username=?")
                .authoritiesByUsernameQuery("select username, user_role"
                        + " from users where username=?").getUserDetailsService();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf().disable()
                .logout().disable()
                .formLogin().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .anonymous()
                .and()
                .exceptionHandling().authenticationEntryPoint(
                (req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .addFilterAfter(new JwtUsernamePasswordAuthenticationFilter(jwtConfiguration, authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                .antMatchers(jwtConfiguration.getUrl()).permitAll()
                .anyRequest().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}

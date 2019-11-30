package br.com.codearena.codearenaoauth2server.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource defaultDataSource() {
        return DataSourceBuilder.create().build();
    }

}

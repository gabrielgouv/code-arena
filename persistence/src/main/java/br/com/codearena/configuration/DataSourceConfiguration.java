package br.com.codearena.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    private String driver;
    private String url;
    private String username;
    private String password;

    @Bean
    public DataSource getDataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName(driver);
        dataSourceBuilder.url(url);
        dataSourceBuilder.username(username);
        dataSourceBuilder.password(password);
        return dataSourceBuilder.build();
    }

    @Value("${database.driver}")
    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Value("${database.url}")
    public void setUrl(String url) {
        this.url = url;
    }

    @Value("${database.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    @Value("${database.password}")
    public void setPassword(String password) {
        this.password = password;
    }

}

package br.com.codearena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {JpaRepositoriesAutoConfiguration.class, DataSourceAutoConfiguration.class})
public class CodeArenaApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.location", "../config/application.properties");
        SpringApplication.run(CodeArenaApplication.class, args);
    }

}

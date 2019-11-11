package br.com.codearena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CodeArenaApplication {

    private static final String CODE_ARENA_PROPERTIES_HOME = "CODE_ARENA_PROPERTIES_HOME";

    public static void main(String[] args) {
        checkForExternalProperties();
        SpringApplication.run(CodeArenaApplication.class, args);
    }

    private static void checkForExternalProperties() {
        String springConfigLocationHome = System.getenv(CODE_ARENA_PROPERTIES_HOME);

        if (springConfigLocationHome != null && !"".equals(springConfigLocationHome.trim())) {
            System.setProperty("spring.config.location", CODE_ARENA_PROPERTIES_HOME);
        }
    }

}

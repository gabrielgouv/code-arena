package br.com.codearena;

import br.com.codearena.core.configuration.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class CodeArenaApplication {

    public static void main(String[] args) {
        System.setProperty("spring.config.location", Constants.DEFAULT_PROPERTIES_FILE_PATH);
        SpringApplication.run(CodeArenaApplication.class, args);
    }

}

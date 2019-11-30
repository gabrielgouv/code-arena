package br.com.codearena.codearenaoauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CodeArenaAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeArenaAuthServerApplication.class, args);
	}

}

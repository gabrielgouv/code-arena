package br.com.codearena.codearenaoauth2server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class CodeArenaOauth2ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CodeArenaOauth2ServerApplication.class, args);
	}

}

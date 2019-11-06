package br.com.suriacaprichos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.suriacaprichos" })
public class SuriaCaprichosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuriaCaprichosApplication.class, args);
	}

}

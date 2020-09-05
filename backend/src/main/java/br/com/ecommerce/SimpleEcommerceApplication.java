package br.com.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.ecommerce" })
public class SimpleEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleEcommerceApplication.class, args);
	}

}

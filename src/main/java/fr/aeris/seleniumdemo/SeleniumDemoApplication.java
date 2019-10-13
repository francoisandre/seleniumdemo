package fr.aeris.seleniumdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan(basePackages = "fr.aeris.seleniumdemo")
@Configuration
public class SeleniumDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeleniumDemoApplication.class, args);
	}

}

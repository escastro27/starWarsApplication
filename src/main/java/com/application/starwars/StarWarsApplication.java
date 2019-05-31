package com.application.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class StarWarsApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(StarWarsApplication.class, args);
		
	}
}
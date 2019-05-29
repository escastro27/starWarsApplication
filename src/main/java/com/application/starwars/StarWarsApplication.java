package com.application.starwars;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.application.starwars.dto.PlanetaDto;
import com.application.starwars.services.PlanetaServices;

@SpringBootApplication
@Configuration
public class StarWarsApplication {

	public static void main(String[] args) {
		init();
		SpringApplication.run(StarWarsApplication.class, args);
	}
	
	public static void init() {
		
		PlanetaServices service = new PlanetaServices();
		PlanetaDto novoPlaneta = new PlanetaDto();
		
		

		
	}
}
package com.application.starwars.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.application.starwars.dto.PlanetaDto;
import com.application.starwars.entities.Planeta;
import com.application.starwars.response.Response;
import com.application.starwars.services.PlanetaServices;
import com.application.starwars.services.exception.PlanetaServiceException;



@RestController
@RequestMapping("/api/planetas")
public class PlanetaController {

	@Autowired
	private PlanetaServices planetaService;

	@PostMapping(path = "/new")
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody PlanetaDto planetaDto, BindingResult result) {
		Response<Planeta> response = new Response<Planeta>();

		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}

		Planeta planetaSalvo = this.planetaService.salvar(planetaDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planetaDto.getId())
				.toUri();
		response.setData(planetaSalvo);
		return ResponseEntity.created(location).body(response);
	}
	
	@PostMapping(path = "/init")
	public ResponseEntity<Response<Planeta>> iniciarCadastro(@Valid @RequestBody PlanetaDto planetaDto, BindingResult result) {
		Response<Planeta> response = new Response<Planeta>();

		

		Planeta planetaSalvo = this.planetaService.salvar(planetaDto);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planetaDto.getId())
				.toUri();
		response.setData(planetaSalvo);
		return ResponseEntity.created(location).body(response);
	}

	@GetMapping(path = "/listar")
	public ResponseEntity<List<Planeta>> listar() {
		List<Planeta> planetas = planetaService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(planetas);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Planeta>> buscar(@PathVariable("id") Long id) throws PlanetaServiceException {
  
		Planeta planeta = planetaService.buscar(id);
		Response<Planeta> response = new Response<Planeta>();
		response.setData(planeta);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping(path = "/excluir/{id}")
	public ResponseEntity<Response<Planeta>> excluir(@PathVariable("id") Long id) {
  
		planetaService.excluir(id);
		Response<Planeta> response = new Response<Planeta>();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
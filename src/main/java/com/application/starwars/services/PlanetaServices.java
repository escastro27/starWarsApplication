package com.application.starwars.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.starwars.dto.PlanetaDto;
import com.application.starwars.entities.Planeta;
import com.application.starwars.repository.PlanetaRepository;
import com.application.starwars.services.exception.PlanetaServiceException;


@Service
public class PlanetaServices {

	@Autowired
	private PlanetaRepository planetaRepository;

	public List<Planeta> listar() {
		return planetaRepository.findAll();
	}

	public Planeta salvar(PlanetaDto planetaDto) {

		Planeta planeta = new Planeta();

		planeta.setNome(planetaDto.getNome());
		planeta.setClima(planetaDto.getClima());
		planeta.setTerreno(planetaDto.getTerreno());
		
		return planetaRepository.save(planeta);
	}

	public Planeta buscar(Long id) throws PlanetaServiceException {
		Planeta planeta = planetaRepository.findOne(id);

		if (planeta == null) {
			throw new PlanetaServiceException("Não existe este planeta cadastrado");
		}
		return planeta;
	}
	
	public void excluir(Long id) {
		planetaRepository.delete(id);

	}
}

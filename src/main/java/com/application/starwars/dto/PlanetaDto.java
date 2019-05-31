package com.application.starwars.dto;

import java.io.Serializable;

public class PlanetaDto implements Serializable {

	private static final long serialVersionUID = -8105241933692707649L;

	private Long id;

	private String nome;

	private String clima;
	
	private String terreno;

	public PlanetaDto() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}
	
	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	@Override
	public String toString() {
		return "PlanetaDto [id=" + id + ", nome=" + nome + ", clima=" + clima
				+ ", terreno=" + terreno + "]";
	}
}

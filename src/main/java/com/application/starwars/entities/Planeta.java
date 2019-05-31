package com.application.starwars.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name = "planeta")
public class Planeta implements Serializable {

	private static final long serialVersionUID = -6888542263201514002L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;

	
	@Column(name = "clima", nullable = false)
	private String clima;

	
	@Column(name = "terreno", nullable = true)
	private String terreno;

	

	public Planeta() {

	}

	public Planeta(Long id, String nome, String clima, String terreno) {
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		
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
		return "Planeta [id=" + id + ", nome=" + nome + ", clima=" + clima
				+ ", terreno=" + terreno + "]";
	}

}

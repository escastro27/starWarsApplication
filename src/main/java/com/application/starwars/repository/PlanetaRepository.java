package com.application.starwars.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.application.starwars.entities.Planeta;


@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

	Planeta findBy(Long id);

}
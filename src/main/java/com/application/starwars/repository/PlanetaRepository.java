package com.application.starwars.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.application.starwars.entities.Planeta;


@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

	Planeta findBy(Long id);
	
    @Query(value="SELECT * FROM planeta p WHERE p.nome like %?1% ", nativeQuery=true)
    List<Planeta> findByNome(String nome);
    


}
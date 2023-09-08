package com.example.sicilia.security.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sicilia.security.entity.Ristorante;


public interface RistoranteRepository extends JpaRepository<Ristorante,Long>{
	
	public List<Ristorante> findByPrenotaRist(LocalDate data);

}

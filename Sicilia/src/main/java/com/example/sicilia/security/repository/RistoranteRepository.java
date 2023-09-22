package com.example.sicilia.security.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Ristorante;


public interface RistoranteRepository extends JpaRepository<Ristorante,Long>{
	
	@Query("SELECT r FROM Ristorante r WHERE r.nome ILIKE :nome")
	public List<Ristorante> getByName(String nome);
	
	public List<Ristorante> findByPrenotaRist(LocalDate data);

}

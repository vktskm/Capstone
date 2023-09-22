package com.example.sicilia.security.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Spiaggia;

public interface SpiaggiaRepository extends JpaRepository<Spiaggia,Long> {
	
	@Query("SELECT s FROM Spiaggia s WHERE s.nome ILIKE :nome")
	public List<Spiaggia> getByName(String nome);
	
	public List<Spiaggia> findByPrenotaSp(LocalDate data);

}

package com.example.sicilia.security.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Ristorante;

public interface CityRepository extends JpaRepository<City,Long>{
	
	@Query("SELECT c FROM City c WHERE c.nome LIKE :nome")
	public List<City> getByName(String nome);
	
	
	public List<City> findByPrenotaAlb(LocalDate data);

}

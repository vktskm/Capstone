package com.example.sicilia.security.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.sicilia.security.entity.Spiaggia;

public interface SpiaggiaRepository extends JpaRepository<Spiaggia,Long> {
	
	public List<Spiaggia> findByPrenotaSp(LocalDate data);

}

package com.example.sicilia.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sicilia.security.entity.City;

public interface CityRepository extends JpaRepository<City,Long>{
	
	public List<City> findByCity(String city);

}

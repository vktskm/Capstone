package com.example.sicilia.security.service;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.repository.CityRepository;

import ch.qos.logback.classic.Logger;

@Service
public class CityService {
     
	
	private Logger log  = (Logger) LoggerFactory.getLogger(CityService.class);
	
	@Autowired CityRepository repo;
	
	
	@Autowired @Qualifier("beanCity") private ObjectProvider<City> provider;
	
	
}

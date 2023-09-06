package com.example.sicilia.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.sicilia.security.entity.City;

@Configuration
public class CityConfig {
	
	@Bean("cityBean")
	@Scope("prototype")
	public City city() {
       return new City();
    }
	
}

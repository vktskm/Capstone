package com.example.sicilia.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


import com.example.sicilia.security.entity.Spiaggia;



@Configuration
public class SpiaggiaConfig {

	@Bean("spiaggieBean")
	@Scope("prototype")
	public Spiaggia spiaggia() {
       return new Spiaggia();
    }	
}

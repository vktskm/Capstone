package com.example.sicilia.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.sicilia.security.entity.Ristorante;

@Configuration
public class RistoranteConfig {
   
	@Bean("ristoranteBean")
	@Scope("prototype")
	public Ristorante ristorante() {
       return new Ristorante();
    }
}

package com.example.sicilia.security.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.example.sicilia.security.entity.Prenotazione;

@Configuration
public class PrenotazioneConfig {
    
	@Bean("prenotazioneBean")
	@Scope("prototype")
	public Prenotazione prenotazione() {
       return new Prenotazione();
    }
}

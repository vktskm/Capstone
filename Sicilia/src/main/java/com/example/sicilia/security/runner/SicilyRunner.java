package com.example.sicilia.security.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sicilia.security.service.SpiaggiaService;

@Component
public class SicilyRunner implements CommandLineRunner {
    
	
	
	@Autowired SpiaggiaService spiaggiaSvc;
	
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
		
	
	//Test Spiaggia
	
	
	spiaggiaSvc.loadSpiaggia();
	spiaggiaSvc.findById(2l);
	spiaggiaSvc.findAll();
	spiaggiaSvc.updateSpiaggia(2l, "Isola Bella", 900.55, 60.99);
	
	
		
	}

}

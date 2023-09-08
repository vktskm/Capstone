package com.example.sicilia.security.runner;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.sicilia.security.entity.Prenotazione;
import com.example.sicilia.security.service.CityService;
import com.example.sicilia.security.service.PrenotazioneService;
import com.example.sicilia.security.service.RistoranteService;
import com.example.sicilia.security.service.SpiaggiaService;

@Component
public class SicilyRunner implements CommandLineRunner {
    
	
	
	@Autowired SpiaggiaService spiaggiaSvc;
	@Autowired RistoranteService ristoranteSvc;
	@Autowired CityService citySvc;
	@Autowired PrenotazioneService prtSvc;
	
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	
	//Test Spiaggia
	spiaggiaSvc.loadSpiaggia();
	spiaggiaSvc.findById(2l);
	spiaggiaSvc.findAll();
	spiaggiaSvc.findByPrenotaSp(LocalDate.of(2024, 5, 18));
	spiaggiaSvc.updateSpiaggia(2l, "Isola Bella", 900.55, 60.99);
	
	//Test Ristorante
	ristoranteSvc.loadRistorante();
	ristoranteSvc.findById(3l);
	ristoranteSvc.findAll();
	ristoranteSvc.findByPrenotaRist(LocalDate.of(2024, 8, 18));
	ristoranteSvc.updateRistorante(2l, "Calipso", "Via Milano ", LocalDate.of(2023, 12, 23) , 69.99);
	
	//Test City
	citySvc.loadCity();
	
	System.out.println("---------------- Licata TRovata --------------");
	citySvc.findByName("Licata");
	
	
//	prtSvc.loadPrenotazione();
	
     prtSvc.addPrenota(1l);
     prtSvc.prenotaComune(1l,1l);
     prtSvc.prenotaRistorante(1l, 2l);
	 prtSvc.prenotaSpiaggia(1l, 1l);
	
	}

}

package com.example.sicilia.security.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.service.SpiaggiaService;

@RestController
@RequestMapping("/api/spiaggia")
@CrossOrigin(origins = "*" , maxAge=3600)
public class SpiaggiaController {
	
	@Autowired SpiaggiaService svc;
	
	@GetMapping("/set")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Spiaggia>> findAll(){
		System.out.println("ciao");
		List<Spiaggia> l = svc.findAll();
		ResponseEntity<List<Spiaggia>> resp = new ResponseEntity<List<Spiaggia>>(l , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable Long id){
		System.out.println("id funziona");
		Spiaggia l = svc.findById(id);
		ResponseEntity<Spiaggia> resp = new ResponseEntity<Spiaggia>(l , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/findbydata")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Spiaggia>> findByPrenotaSp(@RequestBody LocalDate data){
		System.out.println("data funziona");
		List<Spiaggia> l = svc.findByPrenotaSp(data);
		ResponseEntity<List<Spiaggia>> resp = new ResponseEntity<List<Spiaggia>>(l , HttpStatus.OK);
		return resp;
	}
	
	
	@PostMapping("/post")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> addSpiaggia(@RequestBody Spiaggia sp){
		
		Spiaggia s = svc.addSpiaggia(  //nome ,Double lunghezzaMetri, LocalDate data ,Double prezzoOmbrellne
				                       sp.getNome(),
				                       sp.getLunghezzaMetri(),
				                       sp.getUrlFotoSpiaggia(),
				                       sp.getPrenotaSp(),
				                       sp.getPrezzoOmbrellne()
				                       );
		
		return new ResponseEntity<Spiaggia>(s, HttpStatus.CREATED);
				
	}
	
	/*
	{
        "nome": "Isola Bella",
        "lunghezzaMetri": 2707.35,
        "prenotaSp": "2028-07-16",
        "urlFotoSpiaggia": "vvgggg",
        "prezzoOmbrellne": 51.99
    }
	*/
	
	
	
	

}

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

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Ristorante;
import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.service.RistoranteService;


@RestController
@RequestMapping("/api/ristorante")
@CrossOrigin(origins = "*")
public class RistoranteController {
	
@Autowired RistoranteService svc;
	
	@GetMapping("/set")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Ristorante>> findAll(){
		
		List<Ristorante> l = svc.findAll();
		ResponseEntity<List<Ristorante>> resp = new ResponseEntity<List<Ristorante>>(l , HttpStatus.OK);
		return resp;
	}

	
	
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable Long id){
		System.out.println("id funziona");
		Ristorante r = svc.findById(id);
		ResponseEntity<Ristorante> resp = new ResponseEntity<Ristorante>(r , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/findbydata")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Ristorante>> findByPrenotaRist(@RequestBody LocalDate data){
		System.out.println("data funziona");
		List<Ristorante> r = svc.findByPrenotaRist(data);
		ResponseEntity<List<Ristorante>> resp = new ResponseEntity<List<Ristorante>>(r , HttpStatus.OK);
		return resp;
	}
	
	@PostMapping("/post")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> addRistorante(@RequestBody Ristorante rs){
		
		Ristorante r = svc.addRistorante(  
				                      
				                        rs.getNome(),
				                        rs.getIndirizzo(),
				                        rs.getTipoCucina(),
				                        rs.getUrlFotoCucina(),
				                        rs.getPrenotaRist(),
				                        rs.getPrezzoPersona()				
				                       );
		
		return new ResponseEntity<Ristorante>(r, HttpStatus.CREATED);			
	}
	
	@GetMapping("/findbyrist/{nome}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Ristorante>> findByCity(@PathVariable String nome){
		
		List<Ristorante> r = svc.findByName(nome);
		ResponseEntity<List<Ristorante>> resp = new ResponseEntity<List<Ristorante>>(r , HttpStatus.OK);
		return resp;
	}
	
	/*
	 
	  {
   
    "nome": "Sferaccavallo",
    "indirizzo": "Cofddso Roma",
    "tipoCucina": "Stellata",
    "urlFotoCucina": "C:\\U-Agrigeddnto.jpg",
    "prenotaRist": "2024-08-18",
    "prezzoPersona": 230.49
}
	 
	 */

}

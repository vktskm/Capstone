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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.service.CityService;

@RestController
@RequestMapping("/api/city")
@CrossOrigin(origins = "*" , maxAge=3600)
public class CityController {
	
    @Autowired CityService svc;
	
	@GetMapping("/set")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<City>> findAll(){
		System.out.println("ciao");
		List<City> c = svc.findAll();
		ResponseEntity<List<City>> resp = new ResponseEntity<List<City>>(c , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable Long id){
		System.out.println("id funziona");
		City c = svc.findById(id);
		ResponseEntity<City> resp = new ResponseEntity<City>(c , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/findbycity/{city}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<City>> findByCity(@PathVariable String city){
		System.out.println("nome funziona");
		List<City> c = svc.findByName(city);
		ResponseEntity<List<City>> resp = new ResponseEntity<List<City>>(c , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/findbydata")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<City>> findByPrenotaSp(@RequestBody LocalDate data){
		System.out.println("data funziona");
		List<City> l = svc.findByPrenotaRist(data);
		ResponseEntity<List<City>> resp = new ResponseEntity<List<City>>(l , HttpStatus.OK);
		return resp;
	}
    
	
	
	/*
	 
	   {
        "idCity": 1,
        "city": "Licata",
        "provincia": "Agrigento",
        "linguaPrincipale": "licatese",
        "urlFotoCity": "URLFOTO",
        "prenotaAlb": "2024-07-18",
        "monumentoFamoso": "Chiesa Sant'Angelo",
        "prezzoHotel": 123.99,
        "spiaggia": {
            "idSpiaggia": 2,
            "nome": "Mollarella",
            "lunghezzaMetri": 2251.35,
            "urlFotoSpiaggia": "C:\\U-Agrigento.jpg",
            "prenotaSp": "2024-07-18",
            "prezzoOmbrellne": 35.99
        },
        "ristorante": {
            "idRistorante": 1,
            "nome": "Madia",
            "indirizzo": "Corso Roma",
            "tipoCucina": "Stellata",
            "urlFotoCucina": "C:\\U-Agrigento.jpg",
            "prenotaRist": "2024-08-18",
            "prezzoPersona": 230.49
        }
    }
	 
	 
	 * */
	 
}

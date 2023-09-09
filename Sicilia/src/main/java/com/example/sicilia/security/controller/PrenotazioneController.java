package com.example.sicilia.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Prenotazione;
import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.entity.User;
import com.example.sicilia.security.service.PrenotazioneService;

import jakarta.transaction.Transactional;


@RestController
@RequestMapping("/api/prenotazione")
@CrossOrigin(origins = "*" , maxAge=3600)
public class PrenotazioneController {
	
	@Autowired PrenotazioneService svc;
	
	@GetMapping("/set")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<List<Prenotazione>> findAll(){
		System.out.println("ciao");
		List<Prenotazione> p = svc.findAll();
		ResponseEntity<List<Prenotazione>> resp = new ResponseEntity<List<Prenotazione>>(p , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findById(@PathVariable Long id){
		System.out.println("id funziona");
		Prenotazione p = svc.findById(id);
		ResponseEntity<Prenotazione> resp = new ResponseEntity<Prenotazione>(p , HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/user/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByIdUser(@PathVariable Long id){
		System.out.println("id funziona");
		User u =  (User) svc.findByIdUser(id);
		ResponseEntity<User> resp = new ResponseEntity<User>(u , HttpStatus.OK);
		return resp;
	}
	
	@PostMapping("/post/{id}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> addPrenotazione(@PathVariable Long id){
		
		Prenotazione p = svc.addPrenota( id  );
		
		return new ResponseEntity<Prenotazione>(p, HttpStatus.CREATED);
				
	}
	
	@PutMapping("/comune/{idPrenota}/{idCity}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> prenotaComune(@PathVariable Long idPrenota , @PathVariable Long idCity){
		
		
		Prenotazione p = svc.prenotaComune(idPrenota, idCity);
		
		return new ResponseEntity<Prenotazione>(p, HttpStatus.CREATED);
				
	}
	
	@PutMapping("/spiaggia/{idPrenota}/{idSp}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> prenotaSpiaggia(@PathVariable Long idPrenota , @PathVariable Long idSp){
		
		
		Prenotazione p = svc.prenotaSpiaggia(idPrenota, idSp);
		
		return new ResponseEntity<Prenotazione>(p, HttpStatus.CREATED);
				
	}
	
	@PutMapping("/ristorante/{idPrenota}/{idRist}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> prenotaRistorante(@PathVariable Long idPrenota , @PathVariable Long idRist){
		
		
		Prenotazione p = svc.prenotaRistorante(idPrenota, idRist);
		
		return new ResponseEntity<Prenotazione>(p, HttpStatus.CREATED);
				
	}
	
	
}

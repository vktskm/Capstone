package com.example.sicilia.security.controller;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sicilia.security.entity.Prenotazione;
import com.example.sicilia.security.service.PrenotazioneService;


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

}

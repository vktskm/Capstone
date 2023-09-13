package com.example.sicilia.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sicilia.security.entity.User;
import com.example.sicilia.security.service.UserService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired UserService svc;

	//GET METHODS
	@GetMapping("/{idUser}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByIdUser(@PathVariable Long idUser) {
		User u = svc.findByIdUser(idUser);
		ResponseEntity<User> resp = new ResponseEntity<User>(u, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/email/{email}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByEmail(@PathVariable String email) {
		User u = svc.findByEmail(email);
		ResponseEntity<User> resp = new ResponseEntity<User>(u, HttpStatus.OK);
		return resp;
	}
	
	@GetMapping("/username/{username}")
	@PreAuthorize("isAuthenticated()")
	public ResponseEntity<?> findByUsername(@PathVariable String username) {
		User u = svc.findByUsername(username);
		ResponseEntity<User> resp = new ResponseEntity<User>(u, HttpStatus.OK);
		return resp;
	}
}
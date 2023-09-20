package com.example.sicilia.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sicilia.security.entity.User;
import com.example.sicilia.security.payload.JWTAuthResponse;
import com.example.sicilia.security.payload.LoginDto;
import com.example.sicilia.security.payload.RegisterDto;
import com.example.sicilia.security.service.AuthService;
import com.example.sicilia.security.service.UserService;


@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*" , maxAge=3600)
public class AuthController {
    
	@Autowired UserService userSvc;
	
    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // Build Login REST API
    @PostMapping(value = {"/login", "/signin"})
    public ResponseEntity<JWTAuthResponse> login(@RequestBody LoginDto loginDto){
           	
    	String token = authService.login(loginDto);

    	User u = userSvc.findByUsername(loginDto.getUsername());

    	JWTAuthResponse jwtAuthResponse = new JWTAuthResponse();
        jwtAuthResponse.setUserId(u.getId());
        jwtAuthResponse.setUsername(loginDto.getUsername());
        jwtAuthResponse.setAccessToken(token);

        return ResponseEntity.ok(jwtAuthResponse);
    }

    // Build Register REST API
    @PostMapping(value = {"/register", "/signup"})
    public ResponseEntity<?> register(@RequestBody RegisterDto registerDto){
        String response = authService.register(registerDto);
        return new ResponseEntity<>(registerDto, HttpStatus.CREATED);
    }
    
    // JSON inviato dal Client
    /*
    {
        "name": "Giuseppe",
        "username": "giuse",
        "email": "g.verdi@example.com",
        "password": "qwerty"
    }
    
    */
}

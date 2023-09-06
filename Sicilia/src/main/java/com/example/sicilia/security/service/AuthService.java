package com.example.sicilia.security.service;

import com.example.sicilia.security.payload.LoginDto;
import com.example.sicilia.security.payload.RegisterDto;

public interface AuthService {
    
	String login(LoginDto loginDto);
    String register(RegisterDto registerDto);
	
    
}

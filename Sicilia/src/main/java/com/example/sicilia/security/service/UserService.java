package com.example.sicilia.security.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.sicilia.security.entity.User;
import com.example.sicilia.security.repository.UserRepository;



@Service
public class UserService {
	
    private Logger log = (Logger) LoggerFactory.getLogger(UserService.class);
	
	@Autowired UserRepository repo;
	
	
    public User findByIdUser(long id) {
        
		User u = repo.findById(id).get();
		System.out.println();
		log.info(u.toString());
		
		return u;
	}

  	public User findByEmail(String email) {
  		User u = repo.findByEmail(email).get();
  		log.info(u.toString());
  		return u;
  	}
  	
  	public User findByUsername(String username) {
  		User u = repo.findByUsername(username).get();
  		log.info(u.toString());
  		return u;
  	}

  	//DELETE METHOD
  	public void deleteUser(Long id) {
  		repo.deleteById(id);
  		log.info("Utente" + id + "eliminato con successo");
  	}
}

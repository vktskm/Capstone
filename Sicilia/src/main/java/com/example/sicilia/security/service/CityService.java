package com.example.sicilia.security.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.repository.CityRepository;

import ch.qos.logback.classic.Logger;

@Service
public class CityService {
     
	
	private Logger log  = (Logger) LoggerFactory.getLogger(CityService.class);
	
	@Autowired CityRepository repo;
	@Autowired SpiaggiaService spiaggiaSvc;
	@Autowired RistoranteService ristoranteSvc;	
	
	@Autowired @Qualifier("cityBean") private ObjectProvider<City> provider;
	
	public City addCity( String nome, String provincia , String linguaPrincipale ,
	                     String urlFotoCity , LocalDate prenotaAlb , String monumentoFamoso ,
 	                     Double prezzoHotel)//Long idSpiaggia , Long idRistorante 
	{
		City c = provider.getObject().builder()
				                          .nome(nome)
				                          .provincia(provincia)
				                          .linguaPrincipale(linguaPrincipale)
				                          .urlFotoCity(urlFotoCity)
				                          .prenotaAlb(prenotaAlb)
				                          .monumentoFamoso(monumentoFamoso)
				                          .prezzoHotel(prezzoHotel)
//				                          .spiaggia(spiaggiaSvc.findById(idSpiaggia))
//				                          .ristorante(ristoranteSvc.findById(idRistorante))
				                          .build();
		
		          repo.save(c);
		          System.out.println();
		          log.info("Comune aggiunto al DataBase");
		      
		return c;
	}
	
    public City findById(long id) {
        
		City c = repo.findById(id).get();
		System.out.println();
		log.info(c.toString());
		
		return c;
	}
    
    public List<City> findAll(){
        
		List<City> c  = (List<City>)repo.findAll();
		System.out.println();
		c.forEach( s -> log.info(s.toString()));
		return c;
	}
    
    public City updateRistorante( long idCity , LocalDate prenotaAlb ,Double prezzoHotel) {
        City c = repo.findById(idCity).get();
        
        c.setPrenotaAlb(prenotaAlb);
        c.setPrezzoHotel(prezzoHotel);
      
        System.out.println();
        log.info(c.toString());    
        return c;
	}
    
    public List<City> findByPrenotaRist(LocalDate data){
		List<City> c = repo.findByPrenotaAlb(data);
		System.out.println();
		log.info("Albergo nella data" + data + " : ");
		c.forEach(l-> log.info(l.toString()));
		return c;	
	}
    
    public List<City> findByName(String nome) {
    	List<City> c = repo.getByName(nome);
    	log.info("City" + nome + " : ");
		c.forEach(l-> log.info(l.toString()));
    	return c;
    }
    
    
	
	public void loadCity() {
		 
		addCity("Licata", "Agrigento" , "licatese", 
				"https://images.unsplash.com/photo-1598436745057-65e3750c3e87?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=1974&q=80", 
				LocalDate.of(2024, 7, 18), 
				"Chiesa Sant'Angelo",123.99);
		
		addCity("Paleero", "Palermo" , "lica", 
				"https://cdn.pixabay.com/photo/2015/03/23/15/39/palermo-686207_1280.jpg ",
				LocalDate.of(2025, 7, 18), 
				"Duomo",123.99 );
		
		addCity("Lice", "Agrigento" , "licatese", 
				"https://cdn.pixabay.com/photo/2015/03/23/15/39/palermo-686207_1280.jpg", 
				LocalDate.of(2024, 7, 18), 
				"Chiesa Sant'Angelo",123.99);
		
		addCity("Palfgo" ,"Palermo","lica", 
				"https://cdn.pixabay.com/photo/2015/03/23/15/39/palermo-686207_1280.jpg ",
				LocalDate.of(2025, 7, 18), 
				"Duomo",123.99 );
		
		addCity("Lisjjsjgrigento" ,"Palermo","licatese", 
				"https://cdn.pixabay.com/photo/2015/03/23/15/39/palermo-686207_1280.jpg", 
				LocalDate.of(2024, 7, 18), 
				"Chiesa Sant'Angelo",123.99);
		
		
		
	}
	
} 

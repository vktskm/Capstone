package com.example.sicilia.security.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.repository.SpiaggiaRepository;


@Service
public class SpiaggiaService {
    
    private Logger log  = (Logger) LoggerFactory.getLogger(SpiaggiaService.class);
	
    @Autowired SpiaggiaRepository repo;
	@Autowired @Qualifier("spiaggieBean") private ObjectProvider<Spiaggia> provider;
	
	
	public Spiaggia addSpiaggia( String nome ,Double lunghezzaMetri, Double prezzoOmbrellne)
	{
		Spiaggia  s = provider.getObject().builder()
				                          .nome(nome)
				                          .lunghezzaMetri(lunghezzaMetri)
				                          .prezzoOmbrellne(prezzoOmbrellne)
				                          //.urlFotoSpiaggia()
				                          .build();
		          repo.save(s);
		          System.out.println();
		          log.info("Spiaggia aggiunto al DataBase");
		      
		return s;
	}
	
	public Spiaggia findById(long id) {
        
		Spiaggia s = repo.findById(id).get();
		System.out.println();
		log.info(s.toString());
		
		return s;
	}
	
	public List<Spiaggia> findAll(){
       
		List<Spiaggia> l  = (List<Spiaggia>)repo.findAll();
		System.out.println();
		l.forEach( s -> log.info(s.toString()));
		return l;
	}
	
	public Spiaggia updateSpiaggia( long idSpiaggia ,String nome,Double lunghezzaMetri,Double prezzoOmbrellne) {
         Spiaggia s = repo.findById(idSpiaggia).get();
         s.setNome(nome);
         s.setLunghezzaMetri(lunghezzaMetri);
         s.setPrezzoOmbrellne(prezzoOmbrellne);
        
         System.out.println();
         log.info(s.toString());    
         return s;
	}
	
	public void loadSpiaggia() {
		 
		addSpiaggia("Rocca", 1251.35, 23.99);
		addSpiaggia("Mollarella", 2251.35, 35.99);
		addSpiaggia("Mondello", 4251.35, 45.99);
		addSpiaggia("Isola delle Femmine", 2867.35, 31.99);
		addSpiaggia("Capaci", 3251.35, 20.49);
		addSpiaggia("Macari", 2050.35, 32.49);
		addSpiaggia("Tonnarella", 2231.35, 25.99);
		addSpiaggia("Scala dei Turchi", 851.35, 59.99);
		addSpiaggia("San Leone", 6251.35, 38.49);
		addSpiaggia("Play", 4251.35, 28.49);
	}
	
}
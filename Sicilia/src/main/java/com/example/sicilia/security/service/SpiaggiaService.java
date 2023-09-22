package com.example.sicilia.security.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.repository.SpiaggiaRepository;


@Service
public class SpiaggiaService {
    
    private Logger log  = (Logger) LoggerFactory.getLogger(SpiaggiaService.class);
	
    @Autowired SpiaggiaRepository repo;
	@Autowired @Qualifier("spiaggieBean") private ObjectProvider<Spiaggia> provider;
	
	
	public Spiaggia addSpiaggia( String nome ,Double lunghezzaMetri, String urlFoto , LocalDate data ,Double prezzoOmbrellne)
	{
		Spiaggia  s = provider.getObject().builder()
				                          .nome(nome)
				                          .lunghezzaMetri(lunghezzaMetri)
				                          .prezzoOmbrellne(prezzoOmbrellne)
				                          .urlFotoSpiaggia(urlFoto)
				                          .prenotaSp(data)
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
	
	
	public List<Spiaggia> findByPrenotaSp(LocalDate data){
		List<Spiaggia> s = repo.findByPrenotaSp(data);
		System.out.println();
		log.info("Spiaggie nella data" + data + " : ");
		s.forEach(c-> log.info(c.toString()));
		return s;
		
	}
	
	 public List<Spiaggia> findByName(String nome) {
	    	List<Spiaggia> s = repo.getByName(nome);
	    	log.info("City" + nome + " : ");
			s.forEach(l-> log.info(l.toString()));
	    	return s;
	    }
	
	public void loadSpiaggia() {
		 
		addSpiaggia("Rocca", 1251.35,
				"https://cdn.pixabay.com/photo/2022/09/27/06/08/sea-7482169_1280.jpg", 
				LocalDate.of(2024, 8, 18),23.99);
		addSpiaggia("Mollarella", 2251.35,
				"https://cdn.pixabay.com/photo/2022/09/27/06/08/sea-7482169_1280.jpg",
				LocalDate.of(2024, 7, 18), 35.99);
		addSpiaggia("Mondello", 4251.35,
				"https://cdn.pixabay.com/photo/2022/09/27/06/08/sea-7482169_1280.jpg",
				LocalDate.of(2024, 5, 18), 45.99);
		addSpiaggia("Isola delle Femmine", 2867.35, 
				"https://cdn.pixabay.com/photo/2022/09/27/06/08/sea-7482169_1280.jpg" ,
				LocalDate.of(2024, 7, 16),31.99);
		addSpiaggia("Capaci", 3251.35, 
				"https://cdn.pixabay.com/photo/2022/09/27/06/08/sea-7482169_1280.jpg" ,
				LocalDate.of(2024, 6, 18), 20.49);
		addSpiaggia("Macari", 2050.35, 
				"https://cdn.pixabay.com/photo/2022/09/27/06/08/sea-7482169_1280.jpg" ,
				LocalDate.of(2024, 7, 18), 32.49);
	}
	
}
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
				"https://www.siciliafan.it/wp-content/uploads/sites/3/2021/05/Rocca-San-Nicola-Licata-per-FB-Foto-di-Umberto-Pagnotta.jpg", 
				LocalDate.of(2024, 8, 18),23.99);
		addSpiaggia("Mollarella", 2251.35,
				"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/0c/85/07/45/dsc-0119-largejpg.jpg?w=1200&h=1200&s=1",
				LocalDate.of(2024, 7, 18), 35.99);
		addSpiaggia("Mondello", 4251.35,
				"https://www.balarm.it/cache/b/2/2/2/5/b222501990f15b06554384e3d9bbe58917908efd-mondello-jpg-17969-1561372139.jpeg",
				LocalDate.of(2024, 5, 18), 45.99);
		addSpiaggia("Isola delle Femmine", 2867.35, 
				"https://media-cdn.tripadvisor.com/media/photo-s/06/16/dc/91/palermo-easy-tour-day.jpg" ,
				LocalDate.of(2024, 7, 16),31.99);
		addSpiaggia("Scala dei Turchi", 2251.35, 
				"https://images.placesonline.com/photos/424011708171212_Realmonte_268282553.jpg?quality=80&w=700" ,
				LocalDate.of(2024, 6, 18), 60.49);
		addSpiaggia("Macari", 2050.35, 
				"https://www.sanvitoweb.com/images/castelluzzo/castelluzzo-macari%20(3).jpg" ,
				LocalDate.of(2024, 7, 18), 32.49);
	}
	
}
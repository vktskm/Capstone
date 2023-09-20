package com.example.sicilia.security.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.sicilia.security.entity.Ristorante;
import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.repository.RistoranteRepository;

@Service
public class RistoranteService {
   
    private Logger log  = (Logger) LoggerFactory.getLogger(RistoranteService.class);
	
    @Autowired RistoranteRepository repo;
	@Autowired @Qualifier("ristoranteBean") private ObjectProvider<Ristorante> provider;
	
	
	public Ristorante addRistorante( String nome , String indirizzo, 
			                       String tipoCucina , String urlFotoCucina, 
			                       LocalDate prenotaRist ,Double prezzoPersona)
	{
		Ristorante r = provider.getObject().builder()
				                          .nome(nome)
				                          .indirizzo(indirizzo)
				                          .tipoCucina(tipoCucina)
				                          .urlFotoCucina(urlFotoCucina)
				                          .prenotaRist(prenotaRist)
				                          .prezzoPersona(prezzoPersona)
				                          .build();
		          repo.save(r);
		          System.out.println();
		          log.info("Ristorante aggiunto al DataBase");
		      
		return r;
	}
	
    public Ristorante findById(long id) {
        
		Ristorante r = repo.findById(id).get();
		System.out.println();
		log.info(r.toString());
		
		return r;
	}
	
    public List<Ristorante> findAll(){
        
		List<Ristorante> l  = (List<Ristorante>)repo.findAll();
		System.out.println();
		l.forEach( s -> log.info(s.toString()));
		return l;
	}
    
    
    public List<Ristorante> findByPrenotaRist(LocalDate data){
		List<Ristorante> r = repo.findByPrenotaRist(data);
		System.out.println();
		log.info("Ristorante nella data" + data + " : ");
		r.forEach(c-> log.info(c.toString()));
		return r;
		
	}
    
   
    
    public Ristorante updateRistorante( long idRist , String nome, String indirizzo, LocalDate prenotaRist ,Double prezzoPersona) {
        Ristorante r = repo.findById(idRist).get();
        r.setNome(nome);
        r.setIndirizzo(indirizzo);
        r.setPrenotaRist(prenotaRist);
        r.setPrezzoPersona(prezzoPersona);
      
        System.out.println();
        log.info(r.toString());    
        return r;
	}
    
    
    
    
    
	public void loadRistorante() {
		 
		addRistorante("Madia","Corso Roma","Stellata" ,
				"https://cdn.pixabay.com/photo/2014/09/17/20/26/restaurant-449952_1280.jpg", 
				LocalDate.of(2024, 8, 18),230.49);
		
		addRistorante("Logico","Cofddso Roma","Stellata" ,
				"https://cdn.pixabay.com/photo/2014/09/17/20/26/restaurant-449952_1280.jpg", 
				LocalDate.of(2024, 8, 18),230.49);
		addRistorante("Sferaccavallo","Cofddso Roma","Stellata" ,
				"https://cdn.pixabay.com/photo/2014/09/17/20/26/restaurant-449952_1280.jpg", 
				LocalDate.of(2024, 8, 18),230.49);
		addRistorante("ffttyt","Cofddso Roma","Stellata" ,
				"https://cdn.pixabay.com/photo/2014/09/17/20/26/restaurant-449952_1280.jpg", 
				LocalDate.of(2024, 8, 18),230.49);	
				
	}
	
	
	
}

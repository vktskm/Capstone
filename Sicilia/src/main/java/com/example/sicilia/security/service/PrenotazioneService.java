package com.example.sicilia.security.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.sicilia.security.entity.City;
import com.example.sicilia.security.entity.Prenotazione;
import com.example.sicilia.security.entity.Ristorante;
import com.example.sicilia.security.entity.Spiaggia;
import com.example.sicilia.security.entity.User;
import com.example.sicilia.security.repository.PrenotazioneRepository;

import ch.qos.logback.classic.Logger;
import jakarta.transaction.Transactional;

@Service
public class PrenotazioneService {

    private Logger log  = (Logger) LoggerFactory.getLogger(PrenotazioneService.class);
	
	@Autowired PrenotazioneRepository repo;
	@Autowired CityService citSvc;
	@Autowired SpiaggiaService spSvc;
	@Autowired RistoranteService rsSvc;
	@Autowired UserService usSvc;
	
	@Autowired @Qualifier("prenotazioneBean") private ObjectProvider<Prenotazione> provider;
	
	
	public Prenotazione addPrenota( Long idUser){
		
		Prenotazione p = provider.getObject().builder()
                .utente(idUser)
                .pagata(false)
				.build();
         
		repo.save(p);
        System.out.println(p);
        log.info("---------Aggiunto al DataBase");
		return p;
	}
	
	@Transactional
	public Prenotazione prenotaComune(Long idPrenotazione , Long idCity) {
		
		Prenotazione p = repo.findById( idPrenotazione).get();
		List<City> c = ( p.getViaggi());
		c.add(citSvc.findById(idCity));
		p.setViaggi(c);
		repo.save(p);
		System.out.println(p);
		return p;
	};
	
	@Transactional
	public Prenotazione prenotaRistorante(Long idPrenotazione , Long idRist) {
		
		Prenotazione p = repo.findById( idPrenotazione).get();
		List<Ristorante> c = ( p.getRistorante());
		c.add(rsSvc.findById(idRist));
		p.setRistorante(c);
		repo.save(p);
		System.out.println(p);
		return p;
	};
	
	
	/*
	 * @Transactional
    public Prenotazione prenotaRistorante(Long idPrenotazione, Long idRist) {
    // Paso 1: Carica un'istanza di Prenotazione dal repository usando l'ID fornito
    Prenotazione p = repo.findById(idPrenotazione).get();

    // Paso 2: Ottieni la lista dei ristoranti associati all'istanza di Prenotazione
    List<Ristorante> c = p.getRistorante();

    // Paso 3: Carica un'istanza di Ristorante dal repository usando l'ID fornito
    Ristorante ristorante = rsSvc.findById(idRist);

    // Paso 4: Aggiungi il ristorante alla lista dei ristoranti
    c.add(ristorante);

    // Paso 5: Imposta la lista aggiornata dei ristoranti nell'istanza di Prenotazione
    p.setRistorante(c);

    // Paso 6: Salva l'istanza di Prenotazione aggiornata nel repository
    repo.save(p);

    // Paso 7: Stampa l'istanza di Prenotazione per scopi di debug
    System.out.println(p);

    // Paso 8: Restituisce l'istanza di Prenotazione aggiornata
    return p;
}
* */
	
	@Transactional
	public Prenotazione prenotaSpiaggia(Long idPrenotazione , Long idSp) {
		
		Prenotazione p = repo.findById( idPrenotazione).get();
		List<Spiaggia> s = ( p.getSpiaggia());
		s.add(spSvc.findById(idSp));
		p.setSpiaggia(s);
		repo.save(p);
		System.out.println(p);
		return p;
	};
	
    public Prenotazione findById(long id) {
        
		Prenotazione p = repo.findById(id).get();
		System.out.println();
		log.info(p.toString());
		
		return p;
	}
	
    public List<Prenotazione> findAll(){
        
		List<Prenotazione> l  = (List<Prenotazione>)repo.findAll();
		System.out.println();
		l.forEach( s -> log.info(s.toString()));
		return l;
	} 	
	
    public User findByIdUser(Long id){
    	
    	User u = usSvc.findByIdUser(id);
    	System.out.println();
		log.info(u.toString());
        return u;
    	
    }
    
    


	  
}

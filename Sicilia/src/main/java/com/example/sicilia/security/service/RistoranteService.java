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
    
    public List<Ristorante> findByName(String nome) {
    	List<Ristorante> r = repo.getByName(nome);
    	log.info("City" + nome + " : ");
		r.forEach(l-> log.info(l.toString()));
    	return r;
    }
    
    
    
    
	public void loadRistorante() {
		 
		addRistorante("Madia","Corso Filippo Re Capriata, 22,Licata","Ristorante stellato" ,
				"https://images.dissapore.com/wp-content/uploads/2016/07/La-Madia-Pino-Cuttaia.jpg", 
				LocalDate.of(2023, 11, 18),230.49);
		addRistorante("Corallo" , "Arenile, 97015 Marina di Modica","Ristorante di pesce" ,
				"https://media-cdn.tripadvisor.com/media/photo-s/1b/06/02/21/corallo-food-beach.jpg", 
				LocalDate.of(2024, 1, 18),80.49);
		addRistorante("Duomo","Via Capitano Bocchieri, 31, 97100 Ragusa","Ristorante Stellato" ,
				"https://images.dissapore.com/wp-content/uploads/2018/03/SULTANO-3270617-800x600.jpg", 
				LocalDate.of(2024, 3, 18),280.49);
		
		addRistorante("Otto Geleng","Via Teatro Greco, 59, 98039 Taormina ME","Ristorante stellato" ,
				"https://media-cdn.tripadvisor.com/media/photo-s/19/84/c8/25/the-ambience.jpg", 
				LocalDate.of(2024, 4, 12),130.49);
		addRistorante("Brigantino","Via Torretta, 104, 90147 Palermo ","Ristorante pesce" ,
				"https://dynamic-media-cdn.tripadvisor.com/media/photo-o/28/e9/08/83/la-terrazza.jpg?w=800&h=600&s=1", 
				LocalDate.of(2024, 5, 1),60.49);
		addRistorante("I pupi","Via del Cavaliere, 59, 90011 Bagheria","Ristorante stellato" ,
				"https://siciliadagustare.com/wp-content/uploads/2021/05/Ristorante-i-Pupi-di-Bagheria-interno-esterno-2.png", 
				LocalDate.of(2023, 12, 31),130.49);	
				
	}
	
	
	
}

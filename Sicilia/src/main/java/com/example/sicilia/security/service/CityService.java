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
		 
		addCity("Palermo", "Pa" , "Italiano", 
				"https://cdn.pixabay.com/photo/2015/03/23/15/39/palermo-686207_1280.jpg", 
				LocalDate.of(2024, 7, 18), 
				"Cattedrale di Palermo",144.99);
		
		addCity("Agrigento", "AG" , "Italiano", 
				"https://cdn.pixabay.com/photo/2018/10/15/17/30/sicily-3749518_1280.jpg",
				LocalDate.of(2025, 7, 18), 
				"Valle dei Templi",124.99 );
		
		addCity("Trapani", "Tr" , "italiano", 
				"https://cdn.pixabay.com/photo/2014/10/28/15/54/sicily-506644_1280.jpg", 
				LocalDate.of(2024, 7, 18), 
				"Porto di trapani",119.99);
		
		addCity("Licata" ,"Ag","Italiano", 
				"https://d1dn9atxuly58a.cloudfront.net/ragusaonline/foto/383/383-11-51-10-3967.jpg",
				LocalDate.of(2024, 7, 18), 
				"Chiesa Sant'Angelo",134.99 );
		
		addCity("Ragusa" ,"Rg","Italiano", 
				"https://cdn.pixabay.com/photo/2020/03/22/11/36/dubrovnik-4956823_1280.jpg", 
				LocalDate.of(2024, 8, 18), 
				"Duomo di San Giorgio",109.99);
		
		addCity("Modica" ,"Rg","Italiano", 
				"https://cdn.pixabay.com/photo/2017/01/03/23/22/modica-1950969_1280.jpg", 
				LocalDate.of(2023, 12, 18), 
				"Chiesa Madre",89.99);
		
		addCity("Noto" ,"Sr","Italiano", 
				"https://www.sikelia.net/wp-content/uploads/2020/12/cattedrale-noto.jpg", 
				LocalDate.of(2023, 11, 13), 
				"Cattedrale di San Nicolò",129.99);
		
		addCity("Siracusa" ,"Sr","Italiano", 
				"https://www.siciland.com/it/wp-content/uploads/2016/10/ortigia-siracusa.jpg", 
				LocalDate.of(2024, 7, 9), 
				"Ortigia",159.99);
		
		addCity("Catania" ,"Ct","Italiano", 
				"https://cdn.pixabay.com/photo/2014/09/21/10/01/santa-agata-454834_1280.jpg", 
				LocalDate.of(2023, 11, 9), 
				"Duomo Sant'Agata",113.49);
		
		addCity("Toarmina" ,"Me","Italiano", 
				"https://www.sicilia.info/wp-content/uploads/sites/91/taormina-teatro.jpg", 
				LocalDate.of(2023, 12, 30), 
				"Giardini Naxos",199.49);
		
		addCity("Messina" ,"Me","Italiano", 
				"https://cdn.pixabay.com/photo/2016/12/21/19/10/sicily-1923672_1280.jpg", 
				LocalDate.of(2024, 6, 21), 
				"Cattedrale di Santa Maria Assunta",113.49);
		
		addCity("Cefalu" ,"Pa","Italiano", 
				"https://duomocefalu.it/wp-content/uploads/2020/04/Duomo_risoluzione7-605x465.jpg", 
				LocalDate.of(2024, 7, 30), 
				"Duomo di Cefalù",109.49);
		
	}
	
} 

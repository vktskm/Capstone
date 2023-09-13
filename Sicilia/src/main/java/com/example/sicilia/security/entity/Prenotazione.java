package com.example.sicilia.security.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "prenotazione")
public class Prenotazione {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrenotazione;
	
	@ManyToMany
	private List<City> viaggi;
	@ManyToMany
	private List<Spiaggia> spiaggia;
	@ManyToMany
	private List<Ristorante> ristorante;
	
	private boolean pagata ;
    
	private Long utente;
	
}

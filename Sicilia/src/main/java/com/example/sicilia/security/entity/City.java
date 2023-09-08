package com.example.sicilia.security.entity;



import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
@Table(name = "cities")
public class City {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idCity;
	
	@Column(nullable=false , unique=true)
	private String nome;
	private String provincia;
	private String linguaPrincipale;
	private String urlFotoCity;
	private LocalDate prenotaAlb;
	private String monumentoFamoso;
	private Double prezzoHotel;
	
//	@ManyToOne
//	private Spiaggia spiaggia;
//	
//	@ManyToOne
//	private Ristorante ristorante;
	

}

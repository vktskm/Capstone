package com.example.sicilia.security.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "spiaggie")
public class Spiaggia {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSpiaggia;
    
	private String nome;
    private Double lunghezzaMetri;
    private String urlFotoSpiaggia;
    private LocalDate prenotaSp;
    private Double prezzoOmbrellne;
}

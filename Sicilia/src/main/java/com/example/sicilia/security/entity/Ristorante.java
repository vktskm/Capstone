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
@Table(name = "ristoranti")
public class Ristorante {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRistorante;

    private String nome;
    private String indirizzo;
    private String tipoCucina;
    private String urlFotoCucina;
    private LocalDate prenotaRist;
    private Double prezzoPersona;

}

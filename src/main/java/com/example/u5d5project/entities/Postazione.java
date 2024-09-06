package com.example.u5d5project.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String codice;
    private String descrizione;
    private String tipo;
    private int numeroMassimoOccupanti;

    @ManyToOne
    @JoinColumn(name = "edificio_id")
    private Edificio edificio;


}

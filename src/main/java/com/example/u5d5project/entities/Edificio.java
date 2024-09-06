package com.example.u5d5project.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String citta;
    @OneToMany(mappedBy = "edificio", cascade = CascadeType.ALL)
    private List<Postazione> postazioni;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public List<Postazione> getPostazioni() {
        return postazioni;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setPostazioni(List<Postazione> postazioni) {
        this.postazioni = postazioni;
    }

    public Edificio(Long id, String nome, String citta, List<Postazione> postazioni) {
        this.id = id;
        this.nome = nome;
        this.citta = citta;
        this.postazioni = postazioni;
    }
}

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
    @OneToMany(mappedBy = "postazione",cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public Long getId() {
        return id;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNumeroMassimoOccupanti() {
        return numeroMassimoOccupanti;
    }

    public Edificio getEdificio() {
        return edificio;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setNumeroMassimoOccupanti(int numeroMassimoOccupanti) {
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
    }

    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }

    public Postazione(Long id, String codice, String descrizione, String tipo, int numeroMassimoOccupanti, Edificio edificio, List<Prenotazione> prenotazioni) {
        this.id = id;
        this.codice = codice;
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroMassimoOccupanti = numeroMassimoOccupanti;
        this.edificio = edificio;
        this.prenotazioni = prenotazioni;
    }
}

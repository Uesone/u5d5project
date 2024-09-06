package com.example.u5d5project.entities;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity

public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPrenotazione;

    @ManyToOne
    @JoinColumn(name = "utente_username")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "postazione_id")
    private Postazione postazione;

    public Long getId() {
        return id;
    }

    public LocalDate getDataPrenotazione() {
        return dataPrenotazione;
    }

    public Utente getUtente() {
        return utente;
    }

    public Postazione getPostazione() {
        return postazione;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDataPrenotazione(LocalDate dataPrenotazione) {
        this.dataPrenotazione = dataPrenotazione;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public void setPostazione(Postazione postazione) {
        this.postazione = postazione;
    }
    public Prenotazione() {
    }

    public Prenotazione(Long id, LocalDate dataPrenotazione, Utente utente, Postazione postazione) {
        this.id = id;
        this.dataPrenotazione = dataPrenotazione;
        this.utente = utente;
        this.postazione = postazione;
    }

}

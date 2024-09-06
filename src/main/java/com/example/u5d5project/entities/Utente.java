package com.example.u5d5project.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Utente {
    @Id
    private String username;
    private String nomeCompleto;
    private String email;
    @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL)
    private List<Prenotazione> prenotazioni;

    public String getUsername() {
        return username;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getEmail() {
        return email;
    }

    public List<Prenotazione> getPrenotazioni() {
        return prenotazioni;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPrenotazioni(List<Prenotazione> prenotazioni) {
        this.prenotazioni = prenotazioni;
    }
    public Utente() {
    }
    public Utente(String username, String nomeCompleto, String email, List<Prenotazione> prenotazioni) {
        this.username = username;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.prenotazioni = prenotazioni;
    }
}

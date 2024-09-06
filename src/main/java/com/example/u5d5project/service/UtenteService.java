package com.example.u5d5project.service;

import com.example.u5d5project.entities.Utente;
import com.example.u5d5project.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    @Autowired
    private UtenteRepository utenteRepository;

    public Utente
    salvaUtente(Utente utente) {
        return utenteRepository.save(utente);
    }

    public List
            <Utente> trovaTutti() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> trovaPerUsername(String username) {
        return utenteRepository.findById(username);
    }

    public void cancellaUtente(String username) {
        utenteRepository.deleteById(username);
    }
}

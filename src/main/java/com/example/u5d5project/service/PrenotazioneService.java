package com.example.u5d5project.service;

import com.example.u5d5project.entities.Postazione;
import com.example.u5d5project.entities.Prenotazione;
import com.example.u5d5project.entities.Utente;
import com.example.u5d5project.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    public Prenotazione prenotaPostazione(String username, Long postazioneId, LocalDate dataPrenotazione) {

        Utente utente = utenteService.trovaPerUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("Utente non trovato: " + username));


        Postazione postazione = postazioneService.trovaPerId(postazioneId)
                .orElseThrow(() -> new IllegalArgumentException("Postazione non trovata: " + postazioneId));


        List<Prenotazione> prenotazioniEsistenti = prenotazioneRepository.findByPostazioneAndDataPrenotazione(postazione, dataPrenotazione);
        if (!prenotazioniEsistenti.isEmpty()) {
            throw new IllegalStateException("Postazione già prenotata per questa data");
        }


        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setUtente(utente);
        prenotazione.setPostazione(postazione);
        prenotazione.setDataPrenotazione(dataPrenotazione);

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> trovaTutte() {
        return prenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> trovaPerId(Long id) {
        return prenotazioneRepository.findById(id);
    }

    public void cancellaPrenotazione(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}

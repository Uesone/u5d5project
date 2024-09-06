package com.example.u5d5project.service;

import com.example.u5d5project.entities.Postazione;
import com.example.u5d5project.repositories.PostazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostazioneService {

    @Autowired
    private PostazioneRepository postazioneRepository;

    public Postazione salvaPostazione(Postazione postazione) {
        return postazioneRepository.save(postazione);
    }

    public List<Postazione> trovaTutte() {
        return postazioneRepository.findAll();
    }

    public Optional<Postazione> trovaPerId(Long id) {
        return postazioneRepository.findById(id);
    }

    public List<Postazione> ricercaPerTipoECitta(String tipo, String citta) {
        return postazioneRepository.findByTipoAndEdificio_Citta(tipo, citta);
    }

    public void cancellaPostazione(Long id) {
        postazioneRepository.deleteById(id);
    }
}

package com.example.u5d5project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.u5d5project.repositories.EdificioRepository;
import com.example.u5d5project.entities.Edificio;

import java.util.List;
import java.util.Optional;

@Service
public class EdificioService {

    @Autowired
    private EdificioRepository edificioRepository;

    public Edificio salvaEdificio(Edificio edificio) {
        return edificioRepository.save(edificio);
    }

    public List<Edificio> trovaTutti() {
        return edificioRepository.findAll();
    }

    public Optional<Edificio> trovaPerId(Long id) {
        return edificioRepository.findById(id);
    }

    public void cancellaEdificio(Long id) {
        edificioRepository.deleteById(id);
    }
}

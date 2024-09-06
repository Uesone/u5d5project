package com.example.u5d5project;

import com.example.u5d5project.entities.Edificio;
import com.example.u5d5project.entities.Postazione;
import com.example.u5d5project.entities.Prenotazione;
import com.example.u5d5project.entities.Utente;
import com.example.u5d5project.service.EdificioService;
import com.example.u5d5project.service.PostazioneService;
import com.example.u5d5project.service.PrenotazioneService;
import com.example.u5d5project.service.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class GestionePrenotazioniApplication implements CommandLineRunner {

    @Autowired
    private EdificioService edificioService;

    @Autowired
    private PostazioneService postazioneService;

    @Autowired
    private UtenteService utenteService;

    @Autowired
    private PrenotazioneService prenotazioneService;

    public static void main(String[] args) {
        SpringApplication.run(GestionePrenotazioniApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // inserisci un edificio
        Edificio edificio1 = new Edificio();
        edificio1.setNome("Edificio A");
        edificio1.setIndirizzo("Via Roma 1");
        edificio1.setCitta("Milano");
        edificio1 = edificioService.salvaEdificio(edificio1);

        Edificio edificio2 = new Edificio();
        edificio2.setNome("Edificio B");
        edificio2.setIndirizzo("Corso Italia 20");
        edificio2.setCitta("Roma");
        edificio2 = edificioService.salvaEdificio(edificio2);

        // visualizzare gli edifici
        List<Edificio> edifici = edificioService.trovaTutti();
        System.out.println("Tutti gli edifici: " + edifici);

        // cerca un edificio tramite ID
        Edificio trovatoEdificio = edificioService.trovaPerId(edificio1.getId()).orElse(null);
        System.out.println("Edificio trovato per ID: " + trovatoEdificio);

        // cancella un edificio
        edificioService.cancellaEdificio(edificio2.getId());
        System.out.println("Edificio con ID " + edificio2.getId() + " cancellato.");

        // inserisci postazioni
        Postazione postazione1 = new Postazione();
        postazione1.setCodice("P1");
        postazione1.setDescrizione("Postazione Privata");
        postazione1.setTipo("PRIVATO");
        postazione1.setNumeroMassimoOccupanti(1);
        postazione1.setEdificio(edificio1);
        postazione1 = postazioneService.salvaPostazione(postazione1);

        Postazione postazione2 = new Postazione();
        postazione2.setCodice("P2");
        postazione2.setDescrizione("Open Space");
        postazione2.setTipo("OPENSPACE");
        postazione2.setNumeroMassimoOccupanti(4);
        postazione2.setEdificio(edificio1); // Usa edificio1 per coerenza
        postazione2 = postazioneService.salvaPostazione(postazione2);

        // visualizza tutte le postazioni
        List<Postazione> postazioni = postazioneService.trovaTutte();
        System.out.println("Tutte le postazioni: " + postazioni);

        // trova una postazione tramite ID
        Postazione trovataPostazione = postazioneService.trovaPerId(postazione1.getId()).orElse(null);
        System.out.println("Postazione trovata per ID: " + trovataPostazione);

        // cerca postazioni per tipo e città
        List<Postazione> postazioniOpenSpaceMilano = postazioneService.ricercaPerTipoECitta("OPENSPACE", "Milano");
        System.out.println("Postazioni Open Space a Milano: " + postazioniOpenSpaceMilano);

        // cancella una postazione
        postazioneService.cancellaPostazione(postazione2.getId());
        System.out.println("Postazione con ID " + postazione2.getId() + " cancellata.");

        //inserisci utenti
        Utente utente1 = new Utente();
        utente1.setUsername("mrossi");
        utente1.setNomeCompleto("Mario Rossi");
        utente1.setEmail("mario.rossi@example.com");
        utente1 = utenteService.salvaUtente(utente1);

        Utente utente2 = new Utente();
        utente2.setUsername("lbianchi");
        utente2.setNomeCompleto("Laura Bianchi");
        utente2.setEmail("laura.bianchi@example.com");
        utente2 = utenteService.salvaUtente(utente2);

        // visualizza tutti gli utenti
        List<Utente> utenti = utenteService.trovaTutti();
        System.out.println("Tutti gli utenti: " + utenti);

        // trova un utente per username
        Utente trovatoUtente = utenteService.trovaPerUsername(utente1.getUsername()).orElse(null);
        System.out.println("Utente trovato per username: " + trovatoUtente);

        // cancella un utente
        utenteService.cancellaUtente(utente2.getUsername());
        System.out.println("Utente con username " + utente2.getUsername() + " cancellato.");

        // fai una prenotazione
        try {
            Prenotazione prenotazione1 = prenotazioneService.prenotaPostazione(utente1.getUsername(), postazione1.getId(), LocalDate.now().plusDays(1));
            System.out.println("Prenotazione effettuata: " + prenotazione1);
        } catch (Exception e) {
            System.out.println("Errore nella prenotazione: " + e.getMessage());
        }

        // visualizza  le prenotazioni
        List<Prenotazione> prenotazioni = prenotazioneService.trovaTutte();
        System.out.println("Tutte le prenotazioni: " + prenotazioni);

        // trova una prenotazione tramite ID
        Prenotazione prenotazione = prenotazioneService.trovaPerId(1L).orElse(null);
        System.out.println("Prenotazione trovata per ID 1: " + prenotazione);

        // cancella una prenotazione
        try {
            prenotazioneService.cancellaPrenotazione(1L);
            System.out.println("Prenotazione con ID 1 cancellata.");
        } catch (Exception e) {
            System.out.println("Errore nella cancellazione della prenotazione: " + e.getMessage());
        }
    }
}

package com.academy.progetto_giorno_13.service;

import com.academy.progetto_giorno_13.Jparepository.StudenteRepository;
import com.academy.progetto_giorno_13.entity.Esame;
import com.academy.progetto_giorno_13.entity.Studente;
import com.academy.progetto_giorno_13.exception.StudentNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class StudenteServiceImp implements StudenteService
{
    StudenteRepository studenteRepository;

    @Autowired
    public StudenteServiceImp (StudenteRepository studenteRepository)
    {
        this.studenteRepository = studenteRepository;
    }

    @Override
    public Studente findById(int id)
    {
        Optional<Studente> risultato = studenteRepository.findById(id);
        Studente studenteTrovato = null;
        if (risultato.isPresent())
        {
            studenteTrovato = risultato.get();
        }
        else
        {

            throw new StudentNotFoundException(id);
        }
        return studenteTrovato;
    }

    @Override
    public List<Studente> findAll()
    {
        List<Studente> elencoStudenti = studenteRepository.findAll();
        return elencoStudenti;
    }

    @Override
    public Studente save(Studente studente)
    {
        studenteRepository.save(studente);
        return studente;
    }

    @Override
    public void deleteById(int id)
    {
        studenteRepository.deleteById(id);
    }

    @Override
    public List<Studente> findByCognome(String cognome)
    {
        return studenteRepository.findByCognome(cognome);
    }


    @Override
    public List<Studente> findByNomeContaining(String parte)
    {
        return studenteRepository.findByNomeContaining(parte);
    }


    @Override
    public Page<Studente> findAll(Pageable pageable)
    {
        return studenteRepository.findAll(pageable);
    }

    @Override
    public List<Esame> findEsamiByStudenteIdInOrdine(Integer studenteId) {
        return studenteRepository.findEsamiByStudenteIdInOrdine(studenteId);
    }

    @Override
    @Transactional
    public Esame aggiungiEsameAStudente(Integer studenteId, Esame nuovoEsame)
    {
        // 1. Cerca lo studente nel DB o lancia un'eccezione se non esiste
        Studente studente = studenteRepository.findById(studenteId)
                .orElseThrow(() -> new RuntimeException("Studente non trovato con ID: " + studenteId));

        // 2. Controllo logico della traccia: Se lode è true, forza il voto a 30
        if (nuovoEsame.isLode() && nuovoEsame.getVoto() != 30) {
            throw new IllegalArgumentException("Un esame con lode deve avere il voto uguale a 30.");
        }

        // 3. Aggiungi il nuovo esame alla lista dello studente
        studente.getEsami().add(nuovoEsame);

        // 4. Salva lo studente. Grazie al cascade=CascadeType.ALL, salverà anche l'esame nel DB
        studenteRepository.save(studente);

        return nuovoEsame;
    }

    @Transactional
    @Override
    public Map<String, Object> calcolaMediaVotiStudente(Integer studenteId) {
        //  Recupera lo studente o lancia un'eccezione
        Studente studente = studenteRepository.findById(studenteId)
                .orElseThrow(() -> new RuntimeException("Studente non trovato con ID: " + studenteId));

        List<Esame> listaEsami = studente.getEsami();

        // Prepara la mappa per la risposta JSON
        Map<String, Object> risposta = new HashMap<>();
        risposta.put("studente", studente.getNome() + " " + studente.getCognome());
        risposta.put("totaleEsami", listaEsami.size());

        // Gestisci il caso in cui lo studente non abbia ancora sostenuto esami
        if (listaEsami.isEmpty()) {
            risposta.put("media", 0.0);
            return risposta;
        }

        // Calcola la media aritmetica dei voti
        double somma = 0;
        for (Esame esame : listaEsami) {
            somma += esame.getVoto();
        }
        double media = somma / listaEsami.size();

        // Inserisce la media calcolata nella risposta
        risposta.put("media", media);

        return risposta;
    }


}

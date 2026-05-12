package com.academy.progetto_giorno_13.service;

import com.academy.progetto_giorno_13.entity.Esame;
import com.academy.progetto_giorno_13.entity.Studente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

public interface StudenteService
{
    public List<Studente> findAll();

    public Studente findById(int id);

    public Studente save(Studente studente);

    public void deleteById(int id);

    public List<Studente> findByCognome(String cognome);

    public List<Studente> findByNomeContaining(String parte);

    public Page<Studente> findAll(Pageable pageable);

    List<Esame> findEsamiByStudenteIdInOrdine(@Param("studenteId") Integer studenteId);

    Esame aggiungiEsameAStudente(Integer studenteId, Esame nuovoEsame);

    public Map<String, Object> calcolaMediaVotiStudente(Integer studenteId);

}

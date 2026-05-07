package com.academy.progetto_giorno_13.service;

import com.academy.progetto_giorno_13.entity.Studente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudenteService
{
    public List<Studente> findAll();

    public Studente findById(int id);

    public Studente save(Studente studente);

    public void deleteById(int id);

    public List<Studente> findByCognome(String cognome);

    public List<Studente> findBycorsolaurea(String corsolaurea);

    public List<Studente> findByNomeContaining(String parte);

    public Page<Studente> findAll(Pageable pageable);
}

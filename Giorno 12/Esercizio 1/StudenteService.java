package com.academt.progetto_giorno_12;

import java.util.List;

public interface StudenteService
{
    List<Studente> findAll();

    Studente findById(int id);

    List<Studente> findByCognome(String cognome);

    Studente save(Studente studente);

    Studente update(int id, Studente studente);

    void deleteById(int id);

}

package com.academy.progetto_giorno_13.service;

import com.academy.progetto_giorno_13.entity.CorsoLaurea;
import com.academy.progetto_giorno_13.entity.Studente;

import java.util.List;

public interface CorsoLaureaService
{
    public CorsoLaurea save(CorsoLaurea corsoLaurea);

    List<CorsoLaurea> findAll();

    List<Studente> getStudentiPerCorso(Integer idCorso);

    List<Object[]> getStatisticheIscritti();
}

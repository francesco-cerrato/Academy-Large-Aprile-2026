package com.academy.progetto_giorno_13.service;

import com.academy.progetto_giorno_13.Jparepository.CorsoLaureaRepository;
import com.academy.progetto_giorno_13.entity.CorsoLaurea;
import com.academy.progetto_giorno_13.entity.Studente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CorsoLaureaServiceImpl implements CorsoLaureaService
{

    CorsoLaureaRepository corsoLaureaRepository;

    @Autowired
    public CorsoLaureaServiceImpl(CorsoLaureaRepository corsoLaureaRepository)
    {
        this.corsoLaureaRepository = corsoLaureaRepository;
    }

    @Override
    public CorsoLaurea save(CorsoLaurea corsoLaurea)
    {
        corsoLaureaRepository.save(corsoLaurea);
        return corsoLaurea;
    }

    @Override
    public List<CorsoLaurea> findAll()
    {
        List<CorsoLaurea> elencoCorsiLaurea = corsoLaureaRepository.findAll();
        return elencoCorsiLaurea;
    }

    @Override
    public List<Studente> getStudentiPerCorso(Integer idCorso)
    {
        Optional<CorsoLaurea> corsoTrovato = corsoLaureaRepository.findByIdWithStudenti(idCorso);

        return corsoTrovato.get().getStudenti();
    }

    @Override
    public List<Object[]> getStatisticheIscritti() {
        return corsoLaureaRepository.getStatisticheIscritti();
    }


}

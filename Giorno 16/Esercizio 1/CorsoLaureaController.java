package com.academy.progetto_giorno_13.rest;

import com.academy.progetto_giorno_13.entity.CorsoLaurea;
import com.academy.progetto_giorno_13.entity.Studente;
import com.academy.progetto_giorno_13.service.CorsoLaureaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/corsi")
public class CorsoLaureaController
{
    private CorsoLaureaService corsoLaureaService;

    @Autowired
    public CorsoLaureaController(CorsoLaureaService corsoLaureaService)
    {
        this.corsoLaureaService = corsoLaureaService;
    }

    @GetMapping
    public List<CorsoLaurea> getCorsi()
    {
        return corsoLaureaService.findAll();
    }

    @GetMapping("{id}/studenti")
    public List<Studente> getStudentiByCorso(@PathVariable("id") int id)
    {
        return corsoLaureaService.getStudentiPerCorso(id);
    }

    @GetMapping("/studenti")
    public List<Object[]> getNumeroStudentiperCorso()
    {
        return corsoLaureaService.getStatisticheIscritti();
    }
}

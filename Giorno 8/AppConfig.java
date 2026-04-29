package com.academy.controller;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;


//@Component serve per indicare a Spring Boot di gestire questa classe, istanziarla e renderla sempre disponibile
@Component
public class AppConfig
{


    @Value("${app.nome}")
    private String appNome;

    @Value("${app.versione}")
    private String appVersione;

    @Value("${app.messaggio}")
    private String appMessaggio;


    /*
        l'annotazione @PostConstruct viene utilizzata su un metodo per indicare
        che deve essere eseguito automaticamente una sola volta,
        immediatamente dopo che il bean è stato inizializzato
        e tutte le dipendenze sono state iniettate.
     */
    @PostConstruct
    public void inizializzazione()
    {
        String elencoProprietàPersonalizzate = appNome + " " + appVersione + " " + appMessaggio;
        System.out.println("Messaggio da PostConstruct: " + elencoProprietàPersonalizzate);
    }
}

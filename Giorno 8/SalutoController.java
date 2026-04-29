package com.academy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutoController
{
    @GetMapping("/saluto")
    public String saluta()
    {
        return "Ciao dal mio primo Spring Boot!!!";
    }
    @GetMapping(value="/info", produces = MediaType.APPLICATION_JSON_VALUE)
    public String info()
    {
        String nomeAutore = "Francesco Cerrato";
        return "{\"Autore\": \"" + nomeAutore + "\"}";
    }

    /*Questo codice legge il valore associato alla proprietà personalizzata nel file application.properties.
    In seguito assegna quel valore alla variabile privata appNome all'avvio dell'applicazione*/
    @Value("${app.nome}")
    private String appNome;

    @Value("${app.versione}")
    private String appVersione;

    @Value("${app.messaggio}")
    private String appMessaggio;

    @GetMapping("/app-info")
    public String app_info()
    {
        String informazioniApp;
        informazioniApp = "App: " + appNome + ", Versione: " + appVersione + ", Messaggio: " + appMessaggio;
        return informazioniApp;
    }

    @Value("${server.port}")
    private String portaServer;

    @GetMapping("/configurazione-server")
    public String port_info()
    {
        String informazioniPorta = "Porta in ascolto: " + portaServer;
        return informazioniPorta;
    }
}

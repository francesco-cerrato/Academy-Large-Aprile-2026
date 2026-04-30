package com.academy.secondo_progetto;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class SalutoComplesso
{

    public SalutoComplesso()
    {
        //Questa stampa, inserita nel costruttore, avviene quando la classe è istanziata
        System.out.println("Costruttore");
    }

    /*
    Questa annotazione serve per indicare che il metodo deve essere eseguito una sola volta
    subito dopo che il bean è stato inizializzato.
     */
    @PostConstruct
    public void init()
    {
        System.out.println("'Bean inizializzato!");
    }

    /*
    Questa annotazione serve per indicare che il metodo verrà eseguito
    automaticamente prima che il Bean venga distrutto (quando l'applicazione termina)
     */
    @PreDestroy
    public void cleanup()
    {
        System.out.println("Bean distrutto!");
    }

}

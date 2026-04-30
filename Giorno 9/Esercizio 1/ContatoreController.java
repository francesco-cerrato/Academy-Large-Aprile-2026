package com.academy.secondo_progetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContatoreController
{
    //In questo caso l'annotazione @Autowired inietta l'istanza del bean qui
    @Autowired
    private ContatoreBeanSingleton contatoreBeanSingleton;

    @Autowired
    private ContatoreBeanPrototype contatoreBeanPrototype;

    @GetMapping("/incrementaSingleton")
    public String incrementa_stampa_contatore_singleton()
    {
        contatoreBeanSingleton.incrementa();
        return "Contatore Singleton attuale: " + contatoreBeanSingleton.getContatore();
    }


    /*
    Questa porzione di codice l'ho lasciata intatta nonostante sia sbagliata.
    Ho spiegato il perché di questo errore nei commenti nella classe
    ContatoreBeanPrototype. Per codificare i giusti metodi affinché
    il contatore prototype funzioni come richiesto, ho creato
    un altro controller chiamato "ContatoreControllerPrototype"
    per distinguere bene il codice errato dal codice giusto.
    Di conseguenza la pagina web mappata a "/incrementaProtoype" restituisce
    un contatore errato in quanto si comporta come se fosse un singleton...
     */
    @GetMapping("/incrementaPrototype")
    public String incremena_stampa_contatore_prototype()
    {
        contatoreBeanPrototype.incrementa();
        return "Contatore Prototype attuale: " + contatoreBeanPrototype.getContatore();
    }

}

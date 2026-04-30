package com.academy.secondo_progetto;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Il comportamento osservato dimostra che lo scope "prototype" in Spring
non garantisce automaticamente una nuova istanza per ogni richiesta HTTP.

Infatti, se un bean prototype viene iniettato in un bean singleton,
l'iniezione avviene una sola volta e quindi viene utilizzata sempre la stessa istanza.

Per ottenere una nuova istanza ad ogni utilizzo,
è necessario richiederla esplicitamente al container (es. ObjectProvider).
 */


@RestController
public class ContatoreControllerPrototype
{
    @Autowired
    private ObjectProvider<ContatoreBeanPrototype> provider;

    @GetMapping("/prototype-corretto")
    public String usaPrototypeCorretto() {

        /*
         * Ogni chiamata a getObject() chiede al container Spring
         * una NUOVA ISTANZA del bean prototype.
         */
        ContatoreBeanPrototype prototype = provider.getObject();

        prototype.incrementa();

        /*
         * RISULTATO:
         * Il contatore riparte da 0 ogni volta
         */
        return "Contatore Prototype (corretto): " + prototype.getContatore();
    }
}

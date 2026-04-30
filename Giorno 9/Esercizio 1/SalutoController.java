package com.academy.secondo_progetto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SalutoController
{
    private SalutoService salutoService;

    /*L'annotazione @Autowired permette a Spring di cercare un "Bean" e di assegnarlo
      automaticamente alla variabile. Non c'è bisogno di crearlo con "new".

      L'annotazione @Qualifier risolve il problema di
       dover scegliere due o più bean dello stesso tipo...
       Prevede che il parametro passato sia il nome del bean
      specifico con la prima lettera minuscola.

       L'annotazione @Primary  in Spring Boot serve a indicare quale bean
        deve essere iniettato di default quando esistono
        più implementazioni (bean) dello stesso tipo nel contesto di Spring.

        La spiegazioni di Singleton e Prototype, 
        per comodità e maggiore velocità, le ho inserite come commento
        rispettivamente nelle classi "ContatoreBeanSingleton" e "ContatoreBeabPrototype"
     */
    @Autowired
    public SalutoController(@Qualifier("salutoIngleseService") SalutoService salutoService)
    {
        this.salutoService = salutoService;
    }

    @GetMapping("/saluto")
    public String saluto()
    {
        String stringaDiRitorno = salutoService.getSaluto();
        return stringaDiRitorno;
    }
}

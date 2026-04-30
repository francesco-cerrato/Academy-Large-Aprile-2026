package com.academy.secondo_progetto;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/* Ogni classe annotata con @Service è registrata automaticamente nel contesto
    nel contesto di Spring come Bean. In questo modo è disponibile per
    l'iniezione delle dipendenze in altre classi, come ad esempio nei Controller
 */
@Service
//@Primary
/*
    Questa annotazione @Primary  in Spring Boot serve a indicare quale bean
    deve essere iniettato di default quando esistono
    più implementazioni (bean) dello stesso tipo nel contesto di Spring.
    In questo caso è inserita in un commento dunque il bean iniettato sarà quello
    indicato nell'annotazione @Qualifier nel costruttore di SalutoController
 */
public class SalutoItalianoService implements SalutoService
{
    @Override
    public String getSaluto() {
        return "Buongiorno!";
    }
}

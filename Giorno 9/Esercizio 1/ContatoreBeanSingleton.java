package com.academy.secondo_progetto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
    L'annotazione @Component semplicemete indica
    che una determinata classe sia un "bean" gestito da Spring
 */
@Component
//@Scope("singleton") // È il default, non serve specificarlo
/*
    Questa annotazione garantisce che esista solo un'istanza oggetto (bean)
    in tutta l'applicazione. Tutte le classi che richiedono (iniettano tramite @Autowired)
    questo bean riceveranno la stessa istanza.
    Aprendo due o più browser e ricaricando lo stesso URL
    il contatore verrà aumentato di uno e sarà lo stesso.
 */
public class ContatoreBeanSingleton
{
    private int contatore = 0;
    public void incrementa()
    {
        this.contatore++;
    }

    public int getContatore()
    {
        return this.contatore;
    }
}

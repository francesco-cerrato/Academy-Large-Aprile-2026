package com.academy.secondo_progetto;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
/*Questa annotazione, inversa di "singleton, serve a indicare al framework Spring Boot
   di creare una nuova istanza (un nuovo oggetto bean) ogni volta che viene richiesto.
   Anche se questo bean è Prototype viene iniettato UNA SOLA VOLTA quando il controller
   viene creato.
   Di conseguenza non viene chimata una nuova istanza ad ogni chiamata HTTP.
   Si comporta di fatto come un singleton
 */
public class ContatoreBeanPrototype
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

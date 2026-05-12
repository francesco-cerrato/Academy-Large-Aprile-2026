package com.academy.progetto_giorno_13.dataloader;

import com.academy.progetto_giorno_13.entity.CorsoLaurea;
import com.academy.progetto_giorno_13.entity.Esame;
import com.academy.progetto_giorno_13.entity.ProfiloStudente;
import com.academy.progetto_giorno_13.entity.Studente;
import com.academy.progetto_giorno_13.service.CorsoLaureaService;
import com.academy.progetto_giorno_13.service.StudenteService;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    private StudenteService studenteService;
    private CorsoLaureaService corsoLaureaService;

    public DataLoader(StudenteService studenteService, CorsoLaureaService corsoLaureaService)
    {
        this.studenteService = studenteService;
        this.corsoLaureaService = corsoLaureaService;
    }


    /*
        L'annotazione @Transactional mantiene aperta la sessione con il database per tutta la durata del metodo,
        permettendo a Hibernate di caricare i dati Lazy (gli studenti) anche dopo aver recuperato il corso.
     */
    @Transactional
    @Override
    public void run(String... args) throws Exception
    {
        /*
            Creazione e salvataggio delle entità CorsoLaurea
            nel database per generare i relativi ID,
            seguita dall'associazione e salvataggio degli studenti
            con i rispettivi riferimenti nelle tabelle relazionali.
         */

        CorsoLaurea corsoLaurea1 = new CorsoLaurea("Informatifca","Dip. Informatica",3);
        corsoLaureaService.save(corsoLaurea1);

        LocalDateTime dataSpecifica = LocalDateTime.of(2026, 5, 8, 14, 30);
        ProfiloStudente profilo1 = new ProfiloStudente("bioEsempio",
                "linkedinEsempio", "fotoEsempio", dataSpecifica);
        String dateString = "2026-05-08";
        LocalDate dataLocale = LocalDate.parse(dateString);
        Studente studente1 = new Studente("Marcello", "Frasci", "Marcello@prova.it", dataLocale, profilo1);

        studente1.setCorsoLaurea(corsoLaurea1);
        studenteService.save(studente1);


        CorsoLaurea corsoLaurea2 = new CorsoLaurea("Architettura","Dip. Architettura",5);
        corsoLaureaService.save(corsoLaurea2);

        dataSpecifica = LocalDateTime.of(2020, 2, 2, 14, 30);
        ProfiloStudente profilo2 = new ProfiloStudente("bioEsempio",
                "linkedinEsempio", "fotoEsempio", dataSpecifica);
        dateString = "1999-02-10";
        dataLocale = LocalDate.parse(dateString);
        Studente studente2 = new Studente("Antonio", "Aliberti", "Antonio@prova.it", dataLocale, profilo2);

        studente2.setCorsoLaurea(corsoLaurea2);
        studenteService.save(studente2);

        CorsoLaurea corsoLaurea3 = new CorsoLaurea("Economia","Dip. Economia",3);
        corsoLaureaService.save(corsoLaurea3);

        dataSpecifica = LocalDateTime.of(2019, 7, 9, 12, 20);
        ProfiloStudente profilo3 = new ProfiloStudente("bioEsempio",
                "linkedinEsempio", "fotoEsempio", dataSpecifica);
        dateString = "2028-07-04";
        dataLocale = LocalDate.parse(dateString);
        Studente studente3 = new Studente("Giuseppe", "Leo", "Giuseppe@prova.it", dataLocale, profilo3);

        studente3.setCorsoLaurea(corsoLaurea1);
        studenteService.save(studente3);


        // Creazione esami per studente1
        Esame esame1 = new Esame("Programmazione I", 30, LocalDate.now(), true);
        Esame esame2 = new Esame("Analisi I", 24, LocalDate.now().minusMonths(2), false);
        Esame esame3 = new Esame("Basi di Dati", 28, LocalDate.now().minusMonths(1), false);

        // Aggiungi alla lista (inizializzala nel costruttore di Studente o qui)
        studente1.setEsami(new ArrayList<>(Arrays.asList(esame1,esame2,esame3)));
        studenteService.save(studente1); // Salva studente e i 3 esami

        // Creazione esami per studente2 (Antonio)
        Esame esame4 = new Esame("Storia dell'Architettura", 30, LocalDate.now(), false);
        Esame esame5 = new Esame("Disegno Tecnico", 22, LocalDate.now().minusMonths(5), false);

        studente2.setEsami(new ArrayList<>(Arrays.asList(esame4,esame5)));
        studenteService.save(studente2); // Salva studente e i 2 esami

    }




}



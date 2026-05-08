package com.academy.progetto_giorno_13.dataloader;

import com.academy.progetto_giorno_13.entity.ProfiloStudente;
import com.academy.progetto_giorno_13.entity.Studente;
import com.academy.progetto_giorno_13.service.StudenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DataLoader implements CommandLineRunner {

    private StudenteService studenteService;

    public DataLoader(StudenteService studenteService)
    {
        this.studenteService = studenteService;
    }
    @Override
    public void run(String... args) throws Exception
    {

        LocalDateTime dataSpecifica = LocalDateTime.of(2026, 5, 8, 14, 30);

        ProfiloStudente profilo1 = new ProfiloStudente("bioEsempio",
                "linkedinEsempio", "fotoEsempio", dataSpecifica);

        String dateString = "2026-05-08";
        LocalDate dataLocale = LocalDate.parse(dateString);
        Studente studente1 = new Studente("Antonio", "Leo", "email@prova.it", dataLocale,
                "Informatica", profilo1);

        studenteService.save(studente1);

        LocalDateTime dataSpecifica2 = LocalDateTime.of(2020, 7, 8, 12, 20);

        ProfiloStudente profilo2 = new ProfiloStudente("bioEsempio",
                "linkedinEsempio", "fotoEsempio", dataSpecifica2);

        String dateString2 = "2020-10-08";
        LocalDate dataLocale2 = LocalDate.parse(dateString2);
        Studente studente2 = new Studente("Giuseppe", "Aliberti", "email@prova.it", dataLocale2,
                "Ingegneria", profilo2);

        studenteService.save(studente2);

        String dateString3 = "2020-10-08";
        LocalDate dataLocale3 = LocalDate.parse(dateString3);
        Studente studente3 = new Studente("Marcello", "Frasci", "email@prova.it", dataLocale3,
                "Italiano", null);

        studenteService.save(studente3);

    }
}

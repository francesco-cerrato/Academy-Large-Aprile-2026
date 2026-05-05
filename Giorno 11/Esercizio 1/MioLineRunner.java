package com.academy.entity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class MioLineRunner implements CommandLineRunner
{

    private final StudenteDAO studenteDAO;

    public MioLineRunner(StudenteDAO studenteDAO)
    {
        this.studenteDAO = studenteDAO;
    }


    @Override
    public void run(String... args)
    {
        System.out.println("App avviata!");

        save(studenteDAO);


        //findById(studenteDAO);

        findAll(studenteDAO);

        update(studenteDAO);

        deleteById(studenteDAO);

        findByCorsoLaurea(studenteDAO);


    }


    private void save(StudenteDAO s)
    {
        LocalDate data = LocalDate.parse("2002-10-20");

        System.out.println("Creazione nuovo studente");
        Studente tempStudente = new Studente("Marcello", "Frasci","prova.email" , data,"Informatica" );

        System.out.println("Salvataggio nuovo studente");
        s.save(tempStudente);


        data = LocalDate.parse("1999-12-12");
        //Creazione secondo studente usando la stessa variabile
        tempStudente = new Studente("Antonio", "Aliberti","prova2.email" , data,"Matematica" );
        s.save(tempStudente);

        data = LocalDate.parse("2020-11-05");
        //Creazione terzo studente usando la stessa variabile
        tempStudente = new Studente("Giuseppe", "Leo","prova3.email" , data,"Matematica" );
        s.save(tempStudente);
    }

    private void update(StudenteDAO s)
    {

        int idStudente = 1;
        System.out.println("Seleziona studente in base all'id");
        Studente studenteRisultato = s.findById(idStudente);
        System.out.println("Studente trovato: " + studenteRisultato.toString());

        studenteRisultato.setCorso_laurea("Ingegneria");
        //Eventualmente qui si potrebbero andare a settare tutti gli attributi dello studente
        System.out.println("Modifica corso di laurea dello studente");
        s.update(studenteRisultato);

    }

    private void findById(StudenteDAO s)
    {
        //Questo codice funziona esclusivamente nel caso in cui studenteRisultato non sia null
        Studente studenteRisultato = s.findById(1);
        System.out.println("Studente trovato: " + studenteRisultato.toString());
    }

    private void findAll(StudenteDAO s)
    {
        System.out.println(s.findAll());
    }

    private void deleteById(StudenteDAO s)
    {
        int idStudente = 3;
        System.out.println("Eliminazione studente id: " + idStudente);
        s.deleteById(idStudente);
    }

    private void findByCorsoLaurea(StudenteDAO s)
    {
        System.out.println( "Studenti iscritti al corso: " + s.findByCorsoLaurea("Matematica"));
    }
}

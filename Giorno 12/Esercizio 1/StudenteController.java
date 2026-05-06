package com.academt.progetto_giorno_12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/studenti") //Mapping base per tutti i metodi del controller
public class StudenteController
{

    private StudenteService studenteService;

    @Autowired
    public StudenteController(StudenteService studenteService)
    {
        this.studenteService = studenteService;
    }

    @GetMapping //Il mapping sarà "/api/studenti"
    public List<Studente> ElencoStudenti()
    {
        return studenteService.findAll();
    }

    @GetMapping("/cerca")
    public List<Studente>CercaStudente(@RequestParam String cognome)
    {
        List<Studente> studentiTrovati = new ArrayList<>();
        studentiTrovati = studenteService.findByCognome(cognome);
        return studentiTrovati;
    }

    @GetMapping("/{id}/corso")
    public String CercaCorsoLaureaById(@PathVariable("id") int id)
    {
        /*
         Come nel caso del metodo StudenteById, in questa mappatura,
         incorporata nel StudenteServiceImpl c'è l'Exception
         */
        Studente studenteTrovato = studenteService.findById(id);
        return studenteTrovato.getCorso_laurea();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studente> StudenteByID(@PathVariable("id") int id)
    {

        /*
            Questo metodo è controllato dal GlobalExceptionHandler.
            Nello StudenteServiceImpl, all'interno del metodo findById()
            viene lanciata l'Exception nel caso in cui lo studente
            con quel determinato ID non venga trovato all'interno del db
         */
        Studente studenteTrovato = studenteService.findById(id);

        // Se lo studente esiste, restituisci 200 OK con i dati
        // Se non esiste, restituisci 404 NOT FOUND

        if (studenteTrovato != null)
        {
            return ResponseEntity.ok(studenteTrovato); // 200 OK
        }
        else
        {
            return ResponseEntity.notFound().build(); // 404 NOT FOUND
        }

    }

    @PostMapping
    public ResponseEntity<Studente> creaStudente(@RequestBody Studente nuovoStudente)
    {
        // Salvataggio nel database
        studenteService.save(nuovoStudente);

        // Restituisce 201 CREATED con lo studente salvato
        return new ResponseEntity<>(nuovoStudente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studente> aggiornaStudente(@PathVariable int id,
                                                     @RequestBody Studente studenteAggiornato)
    {
        Studente studenteEsistente = studenteService.findById(id);

        if (studenteEsistente == null)
        {
            return ResponseEntity.notFound().build(); // 404
        }

        // Aggiorno i campi
        studenteEsistente.setNome(studenteAggiornato.getNome());
        studenteEsistente.setCognome(studenteAggiornato.getCognome());
        studenteEsistente.setEmail(studenteAggiornato.getEmail());
        studenteEsistente.setData_nascita(studenteAggiornato.getData_nascita());
        studenteEsistente.setCorso_laurea(studenteAggiornato.getCorso_laurea());

        studenteService.update(id, studenteEsistente);

        return ResponseEntity.ok(studenteEsistente); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaStudente(@PathVariable int id)
    {
        Studente studente = studenteService.findById(id);

        if (studente == null)
        {
            return ResponseEntity.notFound().build(); // 404
        }

        studenteService.deleteById(id);

        return ResponseEntity.noContent().build(); // 204 NO CONTENT
    }



}

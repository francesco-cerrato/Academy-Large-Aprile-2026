package com.academy.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/studenti") //Mapping base per tutti i metodi del controller
public class StudenteController
{

    private StudenteDAO studenteDAO;

    @Autowired
    public StudenteController(StudenteDAO studenteDAO)
    {
        this.studenteDAO = studenteDAO;
    }

    @GetMapping //Il mapping sarà "/api/studenti"
    public List<Studente> ElencoStudenti()
    {
        return studenteDAO.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Studente> StudenteByID(@PathVariable("id") int id)
    {
        Studente studenteTrovato = studenteDAO.findById(id);

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
        studenteDAO.save(nuovoStudente);

        // Restituisce 201 CREATED con lo studente salvato
        return new ResponseEntity<>(nuovoStudente, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Studente> aggiornaStudente(@PathVariable int id,
                                                     @RequestBody Studente studenteAggiornato)
    {
        Studente studenteEsistente = studenteDAO.findById(id);

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

        studenteDAO.update(studenteEsistente);

        return ResponseEntity.ok(studenteEsistente); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminaStudente(@PathVariable int id)
    {
        Studente studente = studenteDAO.findById(id);

        if (studente == null)
        {
            return ResponseEntity.notFound().build(); // 404
        }

        studenteDAO.deleteById(id);

        return ResponseEntity.noContent().build(); // 204 NO CONTENT
    }



}

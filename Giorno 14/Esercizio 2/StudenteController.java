package com.academy.progetto_giorno_13.rest;

import com.academy.progetto_giorno_13.entity.ProfiloStudente;
import com.academy.progetto_giorno_13.entity.Studente;
import com.academy.progetto_giorno_13.service.StudenteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tools.jackson.databind.json.JsonMapper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//L'annotazione @Tag è utile per aggiungere maggiori informazioni alla documentazione generata automaticamente
@Tag(name="Studenti", description = "Gestione studenti")
@RestController
@RequestMapping("/api/studenti") //Mapping base per tutti i metodi del controller
public class StudenteController
{

    /*
        Il JsonMapper è un oggetto utile per convertire
        automaticamente i dati tra il formato JSON e gli oggetti Java.
        In questo codice è utilizzato per il @PatchMapping
     */
    private StudenteService studenteService;
    private JsonMapper jsonMapper;

    @Autowired
    public StudenteController(StudenteService studenteService, JsonMapper jsonMapper)
    {
        this.studenteService = studenteService;
        this.jsonMapper = jsonMapper;
    }


    /*
         In questo caso non è necessario specificare i @RequestParam.
         Spring legge automaticamente. Ad esempio: ?page=0&size=5
         Il metodo restituisce, tramite file JSON, tutti gli studenti
         nel db insieme ai metadati
      */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studente trovato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    @Operation(summary="Restituisce l'elenco degli studenti e informazioni Pageable")
    @GetMapping
    public Page<Studente> getStudenti(Pageable pageable)
    {
        return studenteService.findAll(pageable);
    }

    @GetMapping("/{id}/profilo")
    public ProfiloStudente cercaProfilo(@PathVariable("id") int id) {

        Studente studenteTrovato = studenteService.findById(id);
        if (studenteTrovato.getProfilo() == null)
        {
            throw new RuntimeException("Studente " + id + " senza profilo!");
        }
        else
        {
            return studenteTrovato.getProfilo();
        }

    }


    /*
        Questa 3 mappature che seguono, grazie al metodo dichiarato in StudenteRepository,
        sono in grado automaticamente di realizzare una query cercando per il @PathVariable.
        Ad esempio, per quanto riguarda il primo metodo mappato in "/cercaxcognome",
        La query SQL, eseguita automaticamente, sarebbe questa:
        SELECT * FROM STUDENTI WHERE COGNOME = cognome
        cognome è prelevato dall'URL, dunque è un RequestParam.

     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studente trovato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    @Operation(summary="Restituisce ogni Studente con uno specifico cognome")
    @GetMapping("/cognome/{cognome}")
    public List<Studente> cercaPerCognome(@PathVariable("cognome") String cognome) {
        return studenteService.findByCognome(cognome);
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studente trovato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    @Operation(summary="Restituisce ogni Studente di uno specifico corso")
    @GetMapping("/corso/{corso}")
    public List<Studente> cercaPerCorso(@PathVariable("corso") String corsolaurea)
    {
        return studenteService.findBycorsolaurea(corsolaurea);
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studente trovato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    @Operation(summary="Restituisce ogni Studente il cui nome contiene una specifica stringa")
    @GetMapping("/cercaxnomecontaining")
    public List<Studente> cercaPerNomeContaining(@RequestParam String parte)
    {
        return studenteService.findByNomeContaining(parte);
    }

    /*
        Il patchPayload è il set di dati parziali che viene inviato al server tramite
        una richiesta HTTP PATCH per aggiornare specifici campi di una risorsa,
        senza dover inviare nuovamente l'intero oggetto.
     */
    @Operation(summary="Esegue la modifica parziale di uno Studente")
    @PatchMapping("/{id}")
    public Studente patchStudente(@PathVariable("id") int id, @RequestBody Map<String, Object> patchPayload)
    {
        Studente studenteTrovato = studenteService.findById(id);

        if (studenteTrovato == null)
        {
            throw new RuntimeException("Studente " + id + " non trovato!");
        }

        /*
            Qui potrebbe essere aggiunto un controllo sull'ID nell'eventualità in cui si volesse
            bloccare ogni tentativo di modifica della primary key
            if (patchPayload.containsKey("id")) { throw new RuntimeException("Modifica Id studente non concessa");}
         */

        Studente patchedStudente = jsonMapper.updateValue(studenteTrovato, patchPayload);

        Studente dBstudente = studenteService.save(patchedStudente);

        return dBstudente;

    }


    /*
    @GetMapping("/cerca")
    public List<Studente>CercaStudente(@RequestParam String cognome)
    {
        List<Studente> studentiTrovati = new ArrayList<>();
        studentiTrovati = studenteService.findByCognome(cognome);
        return studentiTrovati;
    }
     */



    @Operation(summary="Restituisce il corso di laurea di uno specifico studente")
    @GetMapping("/{id}/corso")
    public String CercaCorsoLaureaById(@PathVariable("id") int id)
    {
        /*
         Come nel caso del metodo StudenteById, in questa mappatura,
         incorporata nel StudenteServiceImpl c'è l'Exception
         */
        Studente studenteTrovato = studenteService.findById(id);
        return studenteTrovato.getcorsolaurea();
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Studente trovato"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    @Operation(summary="Restituisce uno studente dato il suo id")
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




    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Studente creato"),
            @ApiResponse(responseCode = "400", description = "Richiesta non valida")
    })
    @Operation(summary="metodo POST per creare/salvare nuovi studenti nel db")
    @PostMapping
    public ResponseEntity<Studente> creaStudente(@RequestBody Studente nuovoStudente)
    {

        /*
            Questa riga di codice e i commenti che seguono derivano da una videolezione Udemy
            giusto nel caso in cui passino un ID nel JSON [cioè inviino un ID esistente],
            imposta l'ID a 0. Questo serve a forzare il salvataggio come nuovo elemento...
            invece di aggiornare quello vecchio"
         */
        nuovoStudente.setId(0);

        // Salvataggio nel database
        studenteService.save(nuovoStudente);

        // Restituisce 201 CREATED con lo studente salvato
        return new ResponseEntity<>(nuovoStudente, HttpStatus.CREATED);
    }


    /*
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
     */


    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Eliminato con successo"),
            @ApiResponse(responseCode = "404", description = "Studente non trovato")
    })
    @Operation(summary="Metodo DELETE per eliminare uno studente, dato il suo id, dal DB")
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
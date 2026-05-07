package com.academy.progetto_giorno_13.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/*
    Questo @RestControllerAdvice intercetta tutte le eccezioni
    lanciate dai controller (o dai livelli sottostanti,
    come Service e Repository, se non gestite localmente)
*/
@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<Map<String, Object>> studenteNonTrovatoHandleException(StudentNotFoundException ex)
    {
        Map<String, Object> error = new HashMap<>();

        error.put("errore", "Studente non trovato");
        error.put("id", ex.getId());
        error.put("timestamp", LocalDateTime.now());

        //Ritorna un JSON con i valori di error e l'HttpStatus NOT_FOUND (404)
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}

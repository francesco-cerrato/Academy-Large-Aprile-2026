package com.academy.progetto_giorno_13.exception;

public class StudentNotFoundException extends RuntimeException
{
    private int id;

    public StudentNotFoundException(int id)
    {
        super("Studente con id " + id + " non trovato");
        this.id = id;
    }

    public int getId()
    {
        return id;
    }
}

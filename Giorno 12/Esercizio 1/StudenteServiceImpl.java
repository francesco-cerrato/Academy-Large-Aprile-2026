package com.academt.progetto_giorno_12;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudenteServiceImpl implements StudenteService
{

    private StudenteDAO studenteDAO;

    @Autowired
    public StudenteServiceImpl(StudenteDAO studenteDAO)
    {
        this.studenteDAO = studenteDAO;
    }

    @Override
    public List<Studente> findAll() {
        return studenteDAO.findAll();
    }

    @Override
    public List<Studente> findByCognome(String cognome)
    {
        List<Studente> studentiTrovati = studenteDAO.findByCognome(cognome);
        return studentiTrovati;
    }

    @Override
    public Studente findById(int id)
    {

        Studente studente = studenteDAO.findById(id);
        if (studente == null)
        {
            /*
            Quando lancio questa Exception Spring Boot automaticamente si collega alla
            classe GlobalExceptionHandler.java per gestire l'exception e rispondere
            tramite JSON sul browser
             */
            throw new StudentNotFoundException(id);
        }
        return studente;
    }

    @Override
    public Studente save(Studente studente) {
        studenteDAO.save(studente);
        return studente;
    }

    @Override
    public Studente update(int id, Studente studente) {
        Studente esistente = studenteDAO.findById(id);

        if (esistente == null) return null;

        esistente.setNome(studente.getNome());
        esistente.setCognome(studente.getCognome());
        esistente.setEmail(studente.getEmail());
        esistente.setData_nascita(studente.getData_nascita());
        esistente.setCorso_laurea(studente.getCorso_laurea());

        studenteDAO.update(esistente);

        return esistente;
    }

    @Override
    public void deleteById(int id)
    {
        studenteDAO.deleteById(id);
    }
}

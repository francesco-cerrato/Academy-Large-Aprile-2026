package com.academy.progetto_giorno_13.service;

import com.academy.progetto_giorno_13.Jparepository.StudenteRepository;
import com.academy.progetto_giorno_13.entity.Studente;
import com.academy.progetto_giorno_13.exception.StudentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudenteServiceImp implements StudenteService
{
    StudenteRepository studenteRepository;

    @Autowired
    public StudenteServiceImp (StudenteRepository studenteRepository)
    {
        this.studenteRepository = studenteRepository;
    }

    @Override
    public Studente findById(int id)
    {
        Optional<Studente> risultato = studenteRepository.findById(id);
        Studente studenteTrovato = null;
        if (risultato.isPresent())
        {
            studenteTrovato = risultato.get();
        }
        else
        {

            throw new StudentNotFoundException(id);
        }
        return studenteTrovato;
    }

    @Override
    public List<Studente> findAll()
    {
        List<Studente> elencoStudenti = studenteRepository.findAll();
        return elencoStudenti;
    }

    @Override
    public Studente save(Studente studente)
    {
        studenteRepository.save(studente);
        return studente;
    }

    @Override
    public void deleteById(int id)
    {
        studenteRepository.deleteById(id);
    }

    @Override
    public List<Studente> findByCognome(String cognome)
    {
        return studenteRepository.findByCognome(cognome);
    }


    @Override
    public List<Studente> findBycorsolaurea(String corsolaurea)
    {
        return studenteRepository.findBycorsolaurea(corsolaurea);
    }

    @Override
    public List<Studente> findByNomeContaining(String parte)
    {
        return studenteRepository.findByNomeContaining(parte);
    }


    @Override
    public Page<Studente> findAll(Pageable pageable)
    {
        return studenteRepository.findAll(pageable);
    }



}

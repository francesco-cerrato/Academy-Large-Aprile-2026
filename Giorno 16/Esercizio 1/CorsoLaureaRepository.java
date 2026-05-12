package com.academy.progetto_giorno_13.Jparepository;

import com.academy.progetto_giorno_13.entity.CorsoLaurea;
import com.academy.progetto_giorno_13.entity.Esame;
import com.academy.progetto_giorno_13.entity.Studente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CorsoLaureaRepository extends JpaRepository<CorsoLaurea, Integer>
{
    /*
        Senza FETCH JPA caricherebbe solamente i dati relativi al corso di laurea.
        Tramite FETCH indichiamo a Hibernate di prendere direttamente
        anche tutti gli studenti associati al corso di laurea con uno specifico id

        Senza questo, JPA farebbe 1 query per il Corso e
        N query per caricare ogni singolo studente (N+1).

     */
    @Query("SELECT c FROM CorsoLaurea c JOIN FETCH c.studenti WHERE c.id = :id")
    Optional<CorsoLaurea> findByIdWithStudenti(@Param("id") Integer id);


    @Query("SELECT c.nome, COUNT(s) FROM CorsoLaurea c JOIN c.studenti s GROUP BY c.nome")
    List<Object[]> getStatisticheIscritti();


}

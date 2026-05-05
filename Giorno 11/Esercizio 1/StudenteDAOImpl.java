package com.academy.entity;

import ch.qos.logback.classic.boolex.StubEventEvaluator;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
    Questa annotazione marca una classe o un'interfaccia come
    componente DAO (Data Access Object),
    destinato a interagire con il database
 */
@Repository
public class StudenteDAOImpl implements StudenteDAO
{

    /*
        Dichiarazione dell'oggetto entityManager: interfaccia principale
        di JPA Hibernate per interagire con il database (salvataggio, update, delete, query)
     */
    private EntityManager entityManager;


    /*
        All'interno del costruttore viene iniettato il bean (classe java) di tipo EntityManager
     */
    @Autowired
    public StudenteDAOImpl (EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Studente mioStudente)
    {
        entityManager.persist(mioStudente);
    }

    @Override
    @Transactional
    public void update(Studente mioStudente)
    {
        entityManager.merge(mioStudente);
    }

    @Override
    public Studente findById(int id)
    {
        Studente studenteTrovato = entityManager.find(Studente.class, id);
        return studenteTrovato;
    }


    @Override
    public List<Studente> findAll()
    {
        TypedQuery<Studente> myQuery = entityManager.createQuery("FROM Studente", Studente.class);
        return myQuery.getResultList();
    }


    /*
         L'annotazione @Query non può essere utilizzata
         dal momento che nella classe "StudenteDAOImpl" l'EntityManager è stato impostato manualmente.

         Pertanto, l'annotazione @Query l'ho evitata in quanto non è pensata per un DAO (Data Access Object)
         bensì per un JpaRepository
     */
    @Override
    public List<Studente> findByCorsoLaurea(String corso)
    {
       TypedQuery<Studente> myQuery = entityManager.createQuery("FROM Studente WHERE corso_laurea=:nomeCorso", Studente.class);
       myQuery.setParameter("nomeCorso", corso);
       return myQuery.getResultList();

    }

    @Override
    @Transactional
    public void deleteById(int id)
    {
        Studente studenteTrovato = entityManager.find(Studente.class, id);
        entityManager.remove(studenteTrovato);
    }



}

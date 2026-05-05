package com.academy.entity;

import java.util.List;


/*
 Interface StudenteDAO (Data Access Object),
 definisce tutti i metodi per gestire le operazioni sul db dell'entità 'Studente'.
 Definisce dunque i metodi CRUD (Create, Read, Update, Delete)

 Ad ogni metodo verrà fatto l'override per poter essere eseguito nella classe "StuendenteDAOImpl"
 */
public interface StudenteDAO
{

    //Metodo per salvare un nuovo studente nel db
    void save(Studente mioStudente);

    //Metodo per aggiornare i dati di uno studente esistente nel db
    void update(Studente mioStudente);

    //Metodo per recuperare tutti gli studenti presenti nel db
    List<Studente> findAll();

    //Metodo per selezionare uno studente specifico in base al suo id univoco
    Studente findById(int id);

    //Metodo  per eliminare uno studente specifico in base al suo id univoco
    void deleteById(int id);

    //Metodo per selezionare tutti gli studenti iscritti ad un determinat corso di laurea
    List<Studente> findByCorsoLaurea(String corso);

}

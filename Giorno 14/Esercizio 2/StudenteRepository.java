package com.academy.progetto_giorno_13.Jparepository;

import com.academy.progetto_giorno_13.entity.ProfiloStudente;
import com.academy.progetto_giorno_13.entity.Studente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudenteRepository extends JpaRepository<Studente, Integer>
{
    /*
        Questa interface, grazie a Spring Data JPA, eredita automaticamente
        numerosi metodi per le operazioni CRUD e di paginazione/ordinamento
     */

    /*
        Questi 3 metodi successivi aggiunti dovrebbero funzionare automaticamente.
        Non è necessaria nessuna implementazione manuale, Tali metodi sono dichiarati
        anche nella interface StudenteService.
        All'interno della classe "StudenteServiceImp" si esegue l'override
        di ogni metodo. Spring Boot dovrebbe interpretare automaticamente,
        tramite il nome del metodo, le query da realizzare.
     */
    public List<Studente> findByCognome(String cognome);

    /*
        Affinché il programmi funzioni e non resituisca errore, il parametro passaoto
        come Stringa, che sarà utilizzato per effettuare la query, deve essere lo stesso
        dichiarato nell'entity Studente.

        MMM
        In questo caso Spring boot utilizza "corsolaurea"
        dunque non sono accettae altre varianti come
        potrebbe essere "corso_laurea" o "CorsoLaurea"
     */
    public List<Studente> findBycorsolaurea(String corsolaurea);

    public List<Studente> findByNomeContaining(String parte);

    /*
        Page<Studente> restituisce i dati della pagina corrente
        e altri metadati utili come il numero di pagine totali,
        il numero totale di elementi e se esiste una pagina successiva
     */

    public Page<Studente> findAll(Pageable pageable);


}

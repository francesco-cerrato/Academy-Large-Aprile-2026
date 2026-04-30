package com.academy.entity;

import jakarta.persistence.*;

/*
Per poter effettuare l'accesso al database H2 posizionato su localhost ho dovuto
utilizzare questi parametri:
JDBC URL: jdbc:h2:mem:testdb
User: sa
Password: (vuota)
 */


/*
 @Entity definisce che questa classe deve essere gestita da JPA/Hibernate
 e mappata su una tabella DB.
  Di default, il nome della tabella corrisponde al nome della classe.
 */

/*
    @Table(name = "studenti"):
    Specifica che questa classe Java deve essere mappata alla tabella fisica
    chiamata "studenti" nel database.
 */

@Entity
@Table(name = "studenti")
public class Studente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email", unique = true)
    private String email;

    // Costruttore vuoto richiesto da JPA
    public Studente() {
    }

    // Costruttore con campi
    public Studente(String nome, String cognome, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    // Getter e Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

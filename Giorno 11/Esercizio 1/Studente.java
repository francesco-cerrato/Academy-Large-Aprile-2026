package com.academy.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

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
    private int id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "email")
    private String email;

    @Column(name = "data_nascita")
    private LocalDate data_nascita;

    @Column(name = "corso_laurea")
    private String corso_laurea;

    // Costruttore vuoto richiesto da JPA
    public Studente() {
    }

    // Costruttore con campi
    public Studente(String nome, String cognome, String email, LocalDate data_nascita, String corso_laurea) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = data_nascita;
        this.corso_laurea = corso_laurea;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + data_nascita +
                ", corso='" + corso_laurea + '\'' +
                '}';
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public LocalDate getData_nascita() {
        return data_nascita;
    }

    public void setData_nascita(LocalDate data_nascita) {
        this.data_nascita = data_nascita;
    }

    public String getCorso_laurea() {
        return corso_laurea;
    }

    public void setCorso_laurea(String corso_laurea) {
        this.corso_laurea = corso_laurea;
    }
}

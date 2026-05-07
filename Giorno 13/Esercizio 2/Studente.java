package com.academy.progetto_giorno_13.entity;

import io.swagger.v3.oas.annotations.media.Schema;
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

@Schema(description="Tabella studenti")
@Entity
@Table(name = "studenti")
public class Studente
{
    @Schema(description="Id univoco dello studente", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Schema(description="Nome dello studente", example = "Mario")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Schema(description="Cognome dello studente", example = "Aliberti")
    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Schema(description="Email dello studente", example = "Mario.Rossi@gmail.com")
    @Column(name = "email")
    private String email;

    @Schema(description="Data di nascita dello studente", example = "1998-10-10")
    @Column(name = "data_nascita")
    private LocalDate data_nascita;

    @Schema(description="Corso di laurea dello studente", example = "Architettura")
    @Column(name = "corsolaurea")
    private String corsolaurea;

    // Costruttore vuoto richiesto da JPA
    public Studente() {
    }

    // Costruttore con campi
    public Studente(String nome, String cognome, String email, LocalDate data_nascita, String corsolaurea) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_nascita = data_nascita;
        this.corsolaurea = corsolaurea;
    }

    @Override
    public String toString() {
        return "Studente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", dataNascita=" + data_nascita +
                ", corso='" + corsolaurea + '\'' +
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

    public String getcorsolaurea() {
        return corsolaurea;
    }

    public void setCorso_laurea(String corsolaurea) {
        this.corsolaurea = corsolaurea;
    }
}



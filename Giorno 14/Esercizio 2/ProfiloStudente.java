package com.academy.progetto_giorno_13.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Schema(description="Tabella profilo studenti")
@Table(name = "profilostudenti")
public class ProfiloStudente
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "bio")
    private String bio;

    @Column(name = "linkedin")
    private String linkedin;

    @Column(name = "foto_url")
    private String foto_url;

    @Column(name = "data_creazione")
    private LocalDateTime data_creazione;


    /*
        Con la relazione bidirezionale, anche l'oggetto ProfiloStudente avrà un
        riferimento allo Studente a cui appartiene. Questo è utile se,
        avendo in mano un profilo, si vuole risalire rapidamente al
        proprietario senza fare query manuali.
     */
    @OneToOne(mappedBy = "profilo") // "profilo" è il nome del campo nella classe Studente
    @JsonIgnore // <--- EVITA IL LOOP INFINITO
    private Studente studente;

    // Costruttore senza campi necessario per Hibernate JPA
    public ProfiloStudente()
    {}

    public ProfiloStudente(String bio, String linkedin, String foto_url, LocalDateTime data_creazione) {
        this.bio = bio;
        this.linkedin = linkedin;
        this.foto_url = foto_url;
        this.data_creazione = data_creazione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }

    public String getFoto_url() {
        return foto_url;
    }

    public void setFoto_url(String foto_url) {
        this.foto_url = foto_url;
    }

    public LocalDateTime getData_creazione() {
        return data_creazione;
    }

    public void setData_creazione(LocalDateTime data_creazione) {
        this.data_creazione = data_creazione;
    }

    @Override
    public String toString() {
        return "ProfiloStudente{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", foto_url='" + foto_url + '\'' +
                ", data_creazione=" + data_creazione +
                '}';
    }
}

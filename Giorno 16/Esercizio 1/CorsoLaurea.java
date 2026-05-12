package com.academy.progetto_giorno_13.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "corsi_laurea")
public class CorsoLaurea
{
    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", unique = true)
    private String nome; //Questo deve essere unico

    @Column(name = "dipartimento")
    private String dipartimento;

    @Column(name = "durata_anni")
    private int durata_anni;


    /*
        EAGER carica immediatamente i dati correlati (es. gli studenti insieme al corso),
        mentre LAZY li carica solo al momento dell'effettivo utilizzo (migliorando le prestazioni).
     */
    //@OneToMany (mappedBy = "corsoLaurea", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OneToMany (mappedBy = "corsoLaurea", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore // <--- Evita che il JSON continui a caricare i post del corso laurea
    private List<Studente> studenti;


    public CorsoLaurea()
    {}

    public CorsoLaurea(String nome, String dipartimento, int durata_anni)
    {
        this.nome = nome;
        this.dipartimento = dipartimento;
        this.durata_anni = durata_anni;
    }

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

    public String getDipartimento() {
        return dipartimento;
    }

    public void setDipartimento(String dipartimento) {
        this.dipartimento = dipartimento;
    }

    public int getDurata_anni() {
        return durata_anni;
    }

    public void setDurata_anni(int durata_anni) {
        this.durata_anni = durata_anni;
    }

    public List<Studente> getStudenti() {
        return studenti;
    }

    public void setStudenti(List<Studente> studenti) {
        this.studenti = studenti;
    }

    @Override
    public String toString() {
        return "CorsoLaurea{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dipartimento='" + dipartimento + '\'' +
                ", durata_anni=" + durata_anni +
                '}';
    }
}

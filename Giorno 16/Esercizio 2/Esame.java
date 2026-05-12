package com.academy.progetto_giorno_13.entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.LocalDate;

@Entity
@Table(name = "esami")
public class Esame {

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "materia")
    private String materia;

    @Min(value = 18, message = "L'età minima è 18")
    @Max(value = 30, message = "L'età massima è 30")
    @Column(name = "voto")
    private int voto;

    @Column(name = "data_esame")
    private LocalDate data_esame;

    @Column(name = "lode")
    private boolean lode;

    public Esame()
    {}

    public Esame(String materia, int voto, LocalDate data_esame, boolean lode) {
        this.materia = materia;
        this.voto = voto;
        this.data_esame = data_esame;
        this.lode = lode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getVoto() {
        return voto;
    }

    public void setVoto(int voto) {
        this.voto = voto;
    }

    public LocalDate getData_esame() {
        return data_esame;
    }

    public void setData_esame(LocalDate data_esame) {
        this.data_esame = data_esame;
    }

    public boolean isLode() {
        return lode;
    }

    public void setLode(boolean lode) {
        this.lode = lode;
    }

    @Override
    public String toString() {
        return "Esame{" +
                "id=" + id +
                ", materia='" + materia + '\'' +
                ", voto=" + voto +
                ", data_esame=" + data_esame +
                ", lode=" + lode +
                '}';
    }
}

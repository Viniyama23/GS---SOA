package br.com.fiap.GS.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cadastro")
public class Cadastro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cidadeNome;

    @Column(nullable = false)
    private LocalDate dataCadastro = LocalDate.now();

    @Column(nullable = false)
    private double numeroHabitantes;

    public Cadastro() {}

    public Cadastro(Long id, String cidadeNome, LocalDate dataCadastro, double numeroHabitantes) {
        this.id = id;
        this.cidadeNome = cidadeNome;
        this.dataCadastro = dataCadastro;
        this.numeroHabitantes = numeroHabitantes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public double getNumeroHabitantes() {
        return numeroHabitantes;
    }

    public void setNumeroHabitantes(double numeroHabitantes) {
        this.numeroHabitantes = numeroHabitantes;
    }
}

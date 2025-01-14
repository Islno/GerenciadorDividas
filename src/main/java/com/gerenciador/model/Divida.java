package com.gerenciador.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Divida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private BigDecimal valor;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Divida() {
        this.dataInicio = LocalDate.now(); // Set dataInicio to the current date
    }

    public Divida(String nome, BigDecimal valor, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.valor = valor;
        this.dataInicio = dataInicio != null ? dataInicio : LocalDate.now(); // Set dataInicio to the current date if not provided
        this.dataFim = dataFim;
    }

    // Getters and Setters
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

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }
}
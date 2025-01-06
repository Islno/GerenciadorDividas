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
    private int diaDaCobranca;
    private LocalDate dataInicio;
    private LocalDate dataFim;

    public Divida() {}

    public Divida(String nome, BigDecimal valor, int diaDaCobranca, LocalDate dataInicio, LocalDate dataFim) {
        this.nome = nome;
        this.valor = valor;
        this.diaDaCobranca = diaDaCobranca;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    // Getters e Setters
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

    public int getDiaDaCobranca() {
        return diaDaCobranca;
    }

    public void setDiaDaCobranca(int diaDaCobranca) {
        this.diaDaCobranca = diaDaCobranca;
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


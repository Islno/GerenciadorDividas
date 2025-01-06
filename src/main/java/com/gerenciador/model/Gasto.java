package com.gerenciador.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class Gasto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private BigDecimal valor;
    private int duracaoMeses;

    public Gasto() {}

    public Gasto(String descricao, BigDecimal valor, int duracaoMeses) {
        this.descricao = descricao;
        this.valor = valor;
        this.duracaoMeses = duracaoMeses;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getDuracaoMeses() {
        return duracaoMeses;
    }

    public void setDuracaoMeses(int duracaoMeses) {
        this.duracaoMeses = duracaoMeses;
    }
}


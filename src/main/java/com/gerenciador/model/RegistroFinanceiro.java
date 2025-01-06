package com.gerenciador.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class RegistroFinanceiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private BigDecimal salario;
    private BigDecimal economias;
    private BigDecimal entradaExtra;

    public RegistroFinanceiro() {}

    public RegistroFinanceiro(LocalDate data, BigDecimal salario, BigDecimal economias, BigDecimal entradaExtra) {
        this.data = data;
        this.salario = salario;
        this.economias = economias;
        this.entradaExtra = entradaExtra;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getEconomias() {
        return economias;
    }

    public void setEconomias(BigDecimal economias) {
        this.economias = economias;
    }

    public BigDecimal getEntradaExtra() {
        return entradaExtra;
    }

    public void setEntradaExtra(BigDecimal entradaExtra) {
        this.entradaExtra = entradaExtra;
    }
}


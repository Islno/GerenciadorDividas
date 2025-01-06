package com.gerenciador.service;

import com.gerenciador.model.Divida;
import com.gerenciador.model.RegistroFinanceiro;
import com.gerenciador.repository.DividaRepository;
import com.gerenciador.repository.RegistroFinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class GerenciadorFinanceiroService {

    @Autowired
    private DividaRepository dividaRepository;

    @Autowired
    private RegistroFinanceiroRepository registroFinanceiroRepository;

    public Divida adicionarDivida(Divida divida) {
        return dividaRepository.save(divida);
    }

    public List<Divida> listarDividas() {
        return dividaRepository.findAll();
    }

    public List<Divida> listarDividasAtuais() {
        LocalDate hoje = LocalDate.now();
        return dividaRepository.findByDataInicioLessThanEqualAndDataFimGreaterThanEqual(hoje, hoje);
    }

    public void atualizarRegistroFinanceiro(RegistroFinanceiro registro) {
        registroFinanceiroRepository.save(registro);
    }

    public RegistroFinanceiro obterRegistroFinanceiroAtual() {
        LocalDate hoje = LocalDate.now();
        return registroFinanceiroRepository.findByData(hoje)
                .orElse(new RegistroFinanceiro(hoje, BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));
    }

    public BigDecimal calcularSaldoMensal() {
        RegistroFinanceiro registroAtual = obterRegistroFinanceiroAtual();
        BigDecimal entradaTotal = registroAtual.getSalario().add(registroAtual.getEntradaExtra());
        BigDecimal totalDividas = listarDividasAtuais().stream()
                .map(Divida::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        return entradaTotal.subtract(totalDividas);
    }

    public void processarFimDoMes() {
        BigDecimal saldoMensal = calcularSaldoMensal();
        RegistroFinanceiro registroAtual = obterRegistroFinanceiroAtual();

        if (saldoMensal.compareTo(BigDecimal.ZERO) > 0) {
            registroAtual.setEconomias(registroAtual.getEconomias().add(saldoMensal));
            atualizarRegistroFinanceiro(registroAtual);
        }
    }

    public void adicionarEntradaExtra(BigDecimal valor) {
        RegistroFinanceiro registroAtual = obterRegistroFinanceiroAtual();
        registroAtual.setEntradaExtra(registroAtual.getEntradaExtra().add(valor));
        atualizarRegistroFinanceiro(registroAtual);
    }
}


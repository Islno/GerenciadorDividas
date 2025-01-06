package com.gerenciador.controller;

import com.gerenciador.model.Divida;
import com.gerenciador.model.RegistroFinanceiro;
import com.gerenciador.service.GerenciadorFinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Controller
public class GerenciadorFinanceiroController {

    @Autowired
    private GerenciadorFinanceiroService service;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dividas", service.listarDividasAtuais());
        model.addAttribute("registroFinanceiro", service.obterRegistroFinanceiroAtual());
        model.addAttribute("saldoMensal", service.calcularSaldoMensal());
        model.addAttribute("novaDivida", new Divida());
        return "index";
    }

    @PostMapping("/adicionarDivida")
    public String adicionarDivida(@ModelAttribute Divida divida) {
        service.adicionarDivida(divida);
        return "redirect:/";
    }

    @PostMapping("/atualizarRegistroFinanceiro")
    public String atualizarRegistroFinanceiro(@ModelAttribute RegistroFinanceiro registro) {
        service.atualizarRegistroFinanceiro(registro);
        return "redirect:/";
    }

    @PostMapping("/adicionarEntradaExtra")
    public String adicionarEntradaExtra(@RequestParam BigDecimal valor) {
        service.adicionarEntradaExtra(valor);
        return "redirect:/";
    }

    @PostMapping("/processarFimDoMes")
    public String processarFimDoMes() {
        service.processarFimDoMes();
        return "redirect:/";
    }
}


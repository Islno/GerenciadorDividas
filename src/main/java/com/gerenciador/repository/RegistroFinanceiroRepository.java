package com.gerenciador.repository;

import com.gerenciador.model.RegistroFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface RegistroFinanceiroRepository extends JpaRepository<RegistroFinanceiro, Long> {
    Optional<RegistroFinanceiro> findByData(LocalDate data);
}


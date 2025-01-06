package com.gerenciador.repository;

import com.gerenciador.model.Divida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface DividaRepository extends JpaRepository<Divida, Long> {
    List<Divida> findByDataInicioLessThanEqualAndDataFimGreaterThanEqual(LocalDate data, LocalDate mesmaData);
}


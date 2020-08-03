package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Banca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface BancaRepository extends JpaRepository<Banca, String> {

    Optional<Banca> findByData(Date data);
}

package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {

    Optional<List<Turma>> findBySemestre(Integer semestre);
    Optional<List<Turma>> findByAno(Integer ano);

}

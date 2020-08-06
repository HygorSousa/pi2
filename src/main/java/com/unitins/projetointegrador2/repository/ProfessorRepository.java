package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, String> {

    Optional<Pessoa> findByMatricula(String matricula);
}

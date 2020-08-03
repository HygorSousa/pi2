package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, String> {

    Optional<Pessoa> findByMatricula(String matricula);

}

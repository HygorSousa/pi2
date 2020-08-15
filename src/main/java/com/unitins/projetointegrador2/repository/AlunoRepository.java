package com.unitins.projetointegrador2.repository;

import java.util.List;
import java.util.Optional;

import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.model.Proposta;
import com.unitins.projetointegrador2.model.Turma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Aluno;

@Repository
@Transactional
public interface AlunoRepository extends CrudRepository<Aluno, Integer> {

    List<Aluno> findAlunoByNome(String nome);

    Optional<Pessoa> findByMatricula(String matricula);
}
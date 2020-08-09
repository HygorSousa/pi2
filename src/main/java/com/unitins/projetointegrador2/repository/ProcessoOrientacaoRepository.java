package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.ProcessoOrientacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ProcessoOrientacaoRepository extends CrudRepository<ProcessoOrientacao, Integer> {

    Optional<List<ProcessoOrientacao>> findByAluno_NomeOrProfessorOrientador_Nome(String nomeAluno, String nomeProfessor);

}
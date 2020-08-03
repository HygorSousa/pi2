package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.model.ProcessoOrientacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProcessoOrientacaoRepository extends JpaRepository<ProcessoOrientacao, String> {

    Optional<List<ProcessoOrientacao>> findByAluno_NomeOrProfessorOrientador_Nome(String nomeAluno, String nomeProfessor);

}

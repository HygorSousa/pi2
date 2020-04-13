package com.projetointegrador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.Aluno;

@Repository
public interface AlunoRepository extends CrudRepository<Aluno, Integer>{

}

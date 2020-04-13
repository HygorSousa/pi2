package com.projetointegrador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.Turma;

@Repository
public interface TurmaRepository extends CrudRepository<Turma, Integer> {

}

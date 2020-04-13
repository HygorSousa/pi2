package com.gerenciarturma.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gerenciarturma.model.Turma;

@Repository
public interface ListarProcessosRepository extends CrudRepository<Turma, Integer> {

}

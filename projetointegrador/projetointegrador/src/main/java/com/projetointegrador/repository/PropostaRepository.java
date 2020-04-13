package com.projetointegrador.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.projetointegrador.model.Proposta;

@Repository
public interface PropostaRepository extends CrudRepository<Proposta, Integer> {

}

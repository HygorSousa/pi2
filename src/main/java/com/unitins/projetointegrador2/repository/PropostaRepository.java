package com.unitins.projetointegrador2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Proposta;

@Repository
@Transactional
public interface PropostaRepository extends CrudRepository<Proposta, Long> {

	@Query("select t from Proposta t where t.titulo like %?1%")
    List<Proposta> findPropostaByTitulo(String titulo);
}
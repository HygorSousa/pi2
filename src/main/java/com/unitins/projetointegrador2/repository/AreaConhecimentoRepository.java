package com.unitins.projetointegrador2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.*;

@Repository
@Transactional
public interface AreaConhecimentoRepository extends CrudRepository<AreaConhecimento, Integer> {

	@Query("select ac from AreaConhecimento ac where ac.nome like %?1%")
	List<AreaConhecimento> findAreaConhecimentoByNome(String nome);
}

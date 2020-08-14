package com.unitins.projetointegrador2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.FAQ;

@Repository
@Transactional
public interface FAQRepository extends CrudRepository<FAQ, Long> {

	List<FAQ> findByPerguntaContaining(String nomepesquisa);

}

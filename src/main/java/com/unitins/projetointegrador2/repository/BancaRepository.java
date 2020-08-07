
package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Banca;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
@Transactional
public interface BancaRepository extends CrudRepository<Banca, Integer> {

    Optional<Banca> findByData(Date data);
}
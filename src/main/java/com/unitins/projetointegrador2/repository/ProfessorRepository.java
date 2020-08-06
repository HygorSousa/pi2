package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Professor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface ProfessorRepository extends CrudRepository<Professor, Integer> {

	@Query("SELECT al FROM Pessoa al WHERE al.nome LIKE %?1%")
    List<Professor> findAlunoByNome(String nome);
}
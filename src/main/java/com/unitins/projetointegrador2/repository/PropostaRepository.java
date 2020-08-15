package com.unitins.projetointegrador2.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Proposta;

@Repository
@Transactional
public interface PropostaRepository extends CrudRepository<Proposta, Integer> {
	
	@Query("select p from Proposta p Inner Join Aluno al on p.aluno.id = al.id Inner Join Professor pr on p.professor.id = pr.id Where p.id = ?1")
	public Optional<Proposta> findGeneralById(Integer id);
	
	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') and p.tipo = upper(?5) and p.dataInicio >= ?6 and p.dataFim <= ?7 order by id")
	public List<Proposta> findGeneral(String titulo, String aluno, String professor, String turma, String tipo,
			LocalDate dataInicio, LocalDate dataFim);
	
	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') and p.tipo = upper(?5) and p.dataInicio >= ?6 order by id")
	public List<Proposta> findGeneralWithoutDataFim(String titulo, String aluno, String professor, String turma,
			String tipo, LocalDate dataInicio);

	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') and p.tipo = upper(?5) and p.dataFim <= ?6 order by id")
	public List<Proposta> findGeneralWithoutDataInicio(String titulo, String aluno, String professor, String turma,
			String tipo, LocalDate dataFim);
	
	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') and p.tipo = upper(?5) order by id")
	public List<Proposta> findGeneralWithoutDatas(String titulo, String aluno, String professor, String turma,
			String tipo);
	
	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') and p.dataInicio >= ?5 and p.dataFim <= ?6 order by id")
	public List<Proposta> findWithoutTipo(String titulo, String aluno, String professor, String turma,
			LocalDate dataInicio, LocalDate dataFim);

	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') and p.dataInicio >= ?5 order by id")
	public List<Proposta> findWithoutTipoAndDataFim(String titulo, String aluno, String professor, String turma,
			LocalDate dataInicio);

	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') and p.dataFim <= ?5 order by id")
	public List<Proposta> findWithoutTipoAndDataInicio(String titulo, String aluno, String professor, String turma,
			LocalDate dataFim);

	@Query("select p from Proposta p Where upper(p.titulo) like concat('%',upper(?1), '%') and upper(p.aluno.nome) like concat('%',upper(?2), '%') and upper(p.professor.nome) like concat('%',upper(?3), '%') and upper(p.aluno.turma.semestre) like concat('%',upper(?4), '%') order by id")
	public List<Proposta> findWithoutTipoAndDatas(String titulo, String aluno, String professor, String turma);
}
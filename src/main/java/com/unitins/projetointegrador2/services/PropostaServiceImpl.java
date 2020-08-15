package com.unitins.projetointegrador2.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.unitins.projetointegrador2.model.Proposta;
import com.unitins.projetointegrador2.repository.PropostaRepository;

@Repository
@Transactional(readOnly = false)
public class PropostaServiceImpl implements PropostaService {
	
	PropostaRepository repo;

	@Override
	public List<Proposta> findWithoutTipoAndDatas(String descricao, String aluno, String professor, String turma) {
		return repo.findWithoutTipoAndDatas(descricao, aluno, professor, turma);
	}

	@Override
	public List<Proposta> findWithoutTipo(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio, LocalDate dataFim) {
		return repo.findWithoutTipo(descricao, aluno, professor, turma, dataInicio, dataFim);
	}

	@Override
	public List<Proposta> findWithoutTipoAndDataFim(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio) {
		return repo.findWithoutTipoAndDataFim(descricao, aluno, professor, turma, dataInicio);
	}

	@Override
	public List<Proposta> findWithoutTipoAndDataInicio(String descricao, String aluno, String professor, String turma,
			LocalDate dataFim) {
		return repo.findWithoutTipoAndDataInicio(descricao, aluno, professor, turma, dataFim);
	}

	@Override
	public List<Proposta> findGeneralWithoutDatas(String descricao, String aluno, String professor, String turma,
			String tipo) {
		return repo.findGeneralWithoutDatas(descricao, aluno, professor, turma, tipo);
	}

	@Override
	public List<Proposta> findGeneral(String descricao, String aluno, String professor, String turma, String tipo,
			LocalDate dataInicio, LocalDate dataFim) {
		return repo.findGeneral(descricao, aluno, professor, turma, tipo, dataInicio, dataFim);
	}

	@Override
	public List<Proposta> findGeneralWithoutDataFim(String descricao, String aluno, String professor, String turma,
			String tipo, LocalDate dataInicio) {
		return repo.findGeneralWithoutDataFim(descricao, aluno, professor, turma, tipo, dataInicio);
	}

	@Override
	public List<Proposta> findGeneralWithoutDataInicio(String descricao, String aluno, String professor, String turma,
			String tipo, LocalDate dataFim) {
		return repo.findGeneralWithoutDataInicio(descricao, aluno, professor, turma, tipo, dataFim);
	}

    
}
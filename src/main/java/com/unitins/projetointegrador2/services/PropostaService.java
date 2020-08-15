package com.unitins.projetointegrador2.services;

import java.time.LocalDate;
import java.util.List;

import com.unitins.projetointegrador2.model.Proposta;

public interface PropostaService {
	
	public List<Proposta> findWithoutTipoAndDatas(String descricao, String aluno, String professor, String turma);
	
	public List<Proposta> findWithoutTipo(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio, LocalDate dataFim);
	
	public List<Proposta> findWithoutTipoAndDataFim(String descricao, String aluno, String professor, String turma,
			LocalDate dataInicio);
	
	public List<Proposta> findWithoutTipoAndDataInicio(String descricao, String aluno, String professor, String turma,
			LocalDate dataFim);
	
	public List<Proposta> findGeneralWithoutDatas(String descricao, String aluno, String professor, String turma,
			String tipo);
	
	public List<Proposta> findGeneral(String descricao, String aluno, String professor, String turma, String tipo,
			LocalDate dataInicio, LocalDate dataFim);
	
	public List<Proposta> findGeneralWithoutDataFim(String descricao, String aluno, String professor, String turma,
			String tipo, LocalDate dataInicio);
	
	public List<Proposta> findGeneralWithoutDataInicio(String descricao, String aluno, String professor, String turma,
			String tipo, LocalDate dataFim);
	
}
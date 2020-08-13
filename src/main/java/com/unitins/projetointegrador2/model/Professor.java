package com.unitins.projetointegrador2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professor extends Pessoa {

	private boolean professorDisciplina;

	private TipoProcessoOrientacao disciplina;

	@OneToMany(mappedBy = "professorOrientador")
	private List<ProcessoOrientacao> orientacoes;

	@ManyToMany
	@JoinTable(name = "AreaConhecimentoProfessor", 
	joinColumns = @JoinColumn(name = "idProfessor"), 
	inverseJoinColumns = @JoinColumn(name = "idAreaConhecimento"))
	private List<AreaConhecimento> areasConhecimento;

	@OneToMany
	@JoinTable(name = "DisponibilidadeProfessor", joinColumns = @JoinColumn(name = "idProfessor"), inverseJoinColumns = @JoinColumn(name = "idDisponibilidade"))
	private List<Disponibilidade> disponibilidades;

	@ManyToMany(mappedBy = "professores")
	private List<Banca> bancas;

	public Professor() {
	}

	public Professor(String nome, String matricula, String cpf, String senha, String roles, List<AreaConhecimento> areasConhecimento) {
		setNome(nome);
		setMatricula(matricula);
		setCpf(cpf);
		setSenha(senha);
		setRoles(roles);
		setEmail("hygor-araujo1@hotmail.com");
		setAreasConhecimento(areasConhecimento);

	}

	public boolean isProfessorDisciplina() {
		return professorDisciplina;
	}

	public void setProfessorDisciplina(boolean professorDisciplina) {
		this.professorDisciplina = professorDisciplina;
	}

	public TipoProcessoOrientacao getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(TipoProcessoOrientacao disciplina) {
		this.disciplina = disciplina;
	}

	public List<ProcessoOrientacao> getOrientacoes() {
		return orientacoes;
	}

	public void setOrientacoes(List<ProcessoOrientacao> orientacoes) {
		this.orientacoes = orientacoes;
	}

	public List<AreaConhecimento> getAreasConhecimento() {
		return areasConhecimento;
	}

	public void setAreasConhecimento(List<AreaConhecimento> areasConhecimento) {
		this.areasConhecimento = areasConhecimento;
	}

	public List<Disponibilidade> getDisponibilidades() {
		return disponibilidades;
	}

	public void setDisponibilidades(List<Disponibilidade> disponibilidades) {
		this.disponibilidades = disponibilidades;
	}

	public List<Banca> getBancas() {
		return bancas;
	}

	public void setBancas(List<Banca> bancas) {
		this.bancas = bancas;
	}
}

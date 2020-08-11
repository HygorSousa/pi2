package com.unitins.projetointegrador2.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professor extends Pessoa {

	private boolean professorDisciplina;

	private TipoProcessoOrientacao disciplina;

	@OneToMany(mappedBy = "professorOrientador")
	private List<ProcessoOrientacao> orientacoes;

	@OneToMany
	@JoinTable(name = "AreaConhecimentoProfessor", joinColumns = @JoinColumn(name = "idProfessor"), inverseJoinColumns = @JoinColumn(name = "idAreaConhecimento"))
	private List<AreaConhecimento> areasConhecimento;

	@OneToMany
	@JoinTable(name = "DisponibilidadeProfessor", joinColumns = @JoinColumn(name = "idProfessor"), inverseJoinColumns = @JoinColumn(name = "idDisponibilidade"))
	private List<Disponibilidade> disponibilidades;

	@ManyToMany
	@JoinTable(name = "ProfessorBanca",
			joinColumns = @JoinColumn(name = "idProfessor"),
			inverseJoinColumns = @JoinColumn(name = "idBanca"))
	private List<Banca> banca;

	public Professor() {
	}

	public Professor(String nome, String matricula, String cpf, String senha, String roles) {
		setNome(nome);
		setMatricula(matricula);
		setCpf(cpf);
		setSenha(senha);
		setRoles(roles);
		setEmail("hygor-araujo1@hotmail.com");

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
}

package com.projetointegrador.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Turma {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ano;
 
    public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	private String semestre;
    
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", ano=" + ano + ", semestre=" + semestre + "]";
	}
    
    
	

}

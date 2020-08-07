package com.unitins.projetointegrador2.model;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Data
@Entity
public class Turma {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ano;
 
    private Integer semestre;
    
    @OneToMany(mappedBy = "turma")
    private List<Aluno> alunos;

    public Turma() {
    }

    public Turma(Integer ano, String semestre, List<Aluno> alunos) {
        this.ano = ano;
        this.semestre = semestre;
        this.alunos = alunos;
    }

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

	public Integer getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
  }

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	@Override
	public String toString() {
		return "Turma [id=" + id + ", ano=" + ano + ", semestre=" + semestre + "]";
	}
}

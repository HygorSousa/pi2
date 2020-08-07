package com.unitins.projetointegrador2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Turma {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Integer ano;
 
    private String semestre;
    
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

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
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

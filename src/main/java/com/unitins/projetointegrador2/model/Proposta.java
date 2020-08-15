package com.unitins.projetointegrador2.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Proposta extends AuditoriaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	private String titulo;

	@ManyToOne
	@JoinColumn(name = "id_aluno_fk")
	private Aluno aluno;

	@ManyToOne
	@JoinColumn(name = "professor_id_fk")
	private Professor professor;
	
	@Column
	@Enumerated(EnumType.STRING)
	private Status status;

	@Column
	@Enumerated(EnumType.STRING)
	private TipoProcessoOrientacao tipo;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_inicio", nullable = false, columnDefinition = "DATE")
    private LocalDate dataInicio;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(name = "data_fim", columnDefinition = "DATE")
    private LocalDate dataFim;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TipoProcessoOrientacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoProcessoOrientacao tipo) {
		this.tipo = tipo;
	}

}
package com.unitins.projetointegrador2.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class FAQ implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String pergunta;

	private String resposta;
	
	@Transient
	private String nomepesquisa;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNomepesquisa() {
		return nomepesquisa;
	}

	public void setNomepesquisa(String nomepesquisa) {
		this.nomepesquisa = nomepesquisa;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public FAQ(String pergunta, String resposta) {
		this.pergunta = pergunta;
		this.resposta = resposta;
	}

	public FAQ() {
	}
	
}

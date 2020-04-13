package com.unitins.projetointegrador2.model;

import javax.persistence.Entity;

@Entity
public class Adminstrador extends Pessoa {

	public Adminstrador() {
	}

	public Adminstrador(String nome, String matricula, String cpf, String senha, String roles) {
		setNome(nome);
		setMatricula(matricula);
		setCpf(cpf);
		setSenha(senha);
		setEmail("hygor-araujo@hotmail.com");
		setRoles(roles);
	}
}

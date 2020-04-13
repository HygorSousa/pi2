package com.projetointegrador.service;

import java.util.List;

import com.projetointegrador.model.Aluno;

public interface AlunoService {
	
	public void salvar(Aluno aluno);
	public Aluno buscarPorId(Integer id);
	public List<Aluno> listarTodos();
	public void removerPorId(Integer id);

}

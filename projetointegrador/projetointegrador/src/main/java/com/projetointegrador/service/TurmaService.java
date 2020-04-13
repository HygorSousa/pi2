package com.projetointegrador.service;

import java.util.List;

import com.projetointegrador.model.Turma;

public interface TurmaService {
public void salvar(Turma turma);
	
	public Turma buscarPorId(Integer id);
	
	public List<Turma> listarTodos();
	
	public void removerPorId(Integer id);
}

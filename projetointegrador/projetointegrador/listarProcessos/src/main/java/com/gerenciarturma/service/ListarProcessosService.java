package com.gerenciarturma.service;

import java.util.List;

import com.gerenciarturma.model.Turma;

public interface ListarProcessosService {
public void salvar(Turma turma);
	
	public Turma buscarPorId(Integer id);
	
	public List<Turma> listarTodos();
	
	public void removerPorId(Integer id);
}

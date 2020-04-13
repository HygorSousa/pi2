package com.projetointegrador.service;

import java.util.List;

import com.projetointegrador.model.Proposta;

public interface PropostaService {
	
	public void salvar(Proposta proposta);
	
	public Proposta buscarPorId(Integer id);
	
	public List<Proposta> listartodos();
	public void removerPorId(Integer id);

}

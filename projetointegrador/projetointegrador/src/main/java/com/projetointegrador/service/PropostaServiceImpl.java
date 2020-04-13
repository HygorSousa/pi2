package com.projetointegrador.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetointegrador.model.Proposta;
import com.projetointegrador.repository.PropostaRepository;

@Service
public class PropostaServiceImpl implements PropostaService {

	private PropostaRepository propostaReposotory;

	public PropostaServiceImpl(PropostaRepository propostaReposotory) {
		super();
		this.propostaReposotory = propostaReposotory;
	}

	@Override
	public void salvar(Proposta proposta) {
		
		this.propostaReposotory.save(proposta);
		
	}

	@Override
	public Proposta buscarPorId(Integer id) {
		Optional<Proposta> p = this.propostaReposotory.findById(id);
		return p.get();
	}

	@Override
	public List<Proposta> listartodos() {
		List<Proposta> propostas = new ArrayList<>();
		Iterator<Proposta> iterator = this.propostaReposotory.findAll().iterator();
		
		while(iterator.hasNext()) {
			propostas.add(iterator.next());
		}
		return propostas;
	}

	@Override
	public void removerPorId(Integer id) {
		this.propostaReposotory.deleteById(id);
		
	}
	
	
	
	
}

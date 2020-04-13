package com.gerenciarturma.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gerenciarturma.model.Turma;
import com.gerenciarturma.repository.ListarProcessosRepository;

@Service
public class ListarProcessosServiceImpl implements ListarProcessosService {

	private ListarProcessosRepository turmaRepository;
	
	
	
	public ListarProcessosServiceImpl(ListarProcessosRepository turmaRepository) {
		super();
		this.turmaRepository = turmaRepository;
	}

	@Override
	public void salvar(Turma turma) {
		
		this.turmaRepository.save(turma);
		
	}

	@Override
	public Turma buscarPorId(Integer id) {
		Optional<Turma> t = this.turmaRepository.findById(id);
 		return t.get();
	}

	@Override
	public List<Turma> listarTodos() {
		List<Turma> turmas = new ArrayList<>();
		Iterator<Turma> iterator = this.turmaRepository.findAll().iterator();
		
		while(iterator.hasNext()) {
			turmas.add(iterator.next());
		}
		
		return turmas;
	}

	@Override
	public void removerPorId(Integer id) {
		
		this.turmaRepository.deleteById(id);
		
	}

}

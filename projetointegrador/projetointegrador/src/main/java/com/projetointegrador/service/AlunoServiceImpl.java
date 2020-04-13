package com.projetointegrador.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.projetointegrador.model.Aluno;
import com.projetointegrador.repository.AlunoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {

	private AlunoRepository alunoRepository;
	private String texto;

	public AlunoServiceImpl(AlunoRepository alunoRepository) {
		super();
		this.alunoRepository = alunoRepository;
	}

	@Override
	public void salvar(Aluno aluno) {

		this.alunoRepository.save(aluno);

	}

	@Override
	public Aluno buscarPorId(Integer id) {
		Optional<Aluno> a = this.alunoRepository.findById(id);
		return a.get();
	}

	@Override
	public List<Aluno> listarTodos() {
		List<Aluno> alunos = new ArrayList<>();
		Iterator<Aluno> iterator = this.alunoRepository.findAll().iterator();

		while (iterator.hasNext()) {
			alunos.add(iterator.next());
		}

		return alunos;
	}

	@Override
	public void removerPorId(Integer id) {

		this.alunoRepository.deleteById(id);

	}

	public void pesquisar() {

		String hql = "SELECT po FROM Proposta po WHERE po.nome LIKE '%" + this.texto.toUpperCase() + "%' ";

	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}

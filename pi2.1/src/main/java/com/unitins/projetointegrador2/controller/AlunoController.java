package com.unitins.projetointegrador2.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.repository.AlunoRepository;

@Controller
public class AlunoController {
	@Autowired
	private AlunoRepository alunoRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/cadastro_aluno")
	public ModelAndView inicio() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_aluno");
		modelAndView.addObject("aluno_obj", new Aluno());

		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		modelAndView.addObject("alunos", alunosIt);

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST, value = "**/salvar_aluno")
	public ModelAndView salvar(Aluno aluno) {

		alunoRepository.save(aluno);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_aluno");

		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		modelAndView.addObject("alunos", alunosIt);

		modelAndView.addObject("aluno_obj", new Aluno());

		return modelAndView;
	}

	@GetMapping("/alterar_aluno/{id_aluno}")
	public ModelAndView alterar(@PathVariable("id_aluno") Integer id_aluno) {

		Optional<Aluno> aluno = alunoRepository.findById(id_aluno);

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_aluno");
		modelAndView.addObject("aluno_obj", aluno.get());

		return modelAndView;
	}

	@GetMapping("/deletar_aluno/{id_aluno}")
	public ModelAndView excluir(@PathVariable("id_aluno") Integer id_aluno) {

		alunoRepository.deleteById(id_aluno);
	
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_aluno");
		modelAndView.addObject("alunos", alunoRepository.findAll());
		
		modelAndView.addObject("aluno_obj", new Aluno());
		
		return modelAndView;
	}
	
	@GetMapping("/lista_aluno")
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_aluno");
		Iterable<Aluno> alunosIt = alunoRepository.findAll();
		
		modelAndView.addObject("alunos", alunosIt);
		modelAndView.addObject("aluno_obj", new Aluno());
		
		return modelAndView;
	}
	
	@PostMapping("**/pesquisar_aluno")
	public ModelAndView pesquisar(@RequestParam("pesquisa_nome") String pesquisa_nome) {
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_aluno");
		modelAndView.addObject("alunos", alunoRepository.findAlunoByNome(pesquisa_nome));
		
		modelAndView.addObject("aluno_obj", new Aluno());
		
		return modelAndView;
	}
}

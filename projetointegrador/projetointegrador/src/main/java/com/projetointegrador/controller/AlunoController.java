package com.projetointegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetointegrador.model.Aluno;
import com.projetointegrador.service.AlunoService;
import com.projetointegrador.service.TurmaService;

@Controller
@RequestMapping("/aluno")
public class AlunoController {
	
	private AlunoService alunoService;
	private TurmaService turmaService;

	

	public AlunoController(AlunoService alunoService, TurmaService turmaService) {
		super();
		this.alunoService = alunoService;
		this.turmaService = turmaService;
	}

	@GetMapping("/listaraluno")
	public String listaraluno(Model model) {
		
		model.addAttribute("alunos", alunoService.listarTodos());

		return "/aluno/listaraluno";
	}
	
	@GetMapping("/formulario")
	public String listar(Model model) {
		model.addAttribute("aluno", new Aluno());
		model.addAttribute("turma", turmaService.listarTodos());
		
		return "/aluno/formulario";
	}

	@PostMapping("/salvar")
	public String salvar(Aluno aluno) {

		System.out.println(aluno);

		alunoService.salvar(aluno);

		return "redirect:/aluno/listaraluno";
	}
   
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable("id") Integer id, Model model) {

		System.out.println("Editar" + id);

		model.addAttribute("aluno", alunoService.buscarPorId(id));
		
		
		return "/aluno/formulario";
	}
	

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable("id") Integer id) {
		
		alunoService.removerPorId(id);
		
		return "redirect:/aluno/listaraluno";
	}

}

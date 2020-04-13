package com.projetointegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetointegrador.model.Turma;
import com.projetointegrador.service.TurmaService;

@Controller
@RequestMapping("/turma")
public class TurmaController {

	private TurmaService turmaService;

	public TurmaController(TurmaService turmaService) {
		super();
		this.turmaService = turmaService;
	}

	@GetMapping("/listarturma")
	public String listarturma(Model model) {
		model.addAttribute("turmas", turmaService.listarTodos());

		return "/turma/listarturma";
	}
	
	@GetMapping("/formulario")
	public String listar(Model model) {
		model.addAttribute("turma", new Turma());
		model.addAttribute("turmas", turmaService.listarTodos());
		
		return "/turma/formulario";
	}

	@PostMapping("/salvar")
	public String salvar(Turma turma) {

		System.out.println(turma);

		turmaService.salvar(turma);

		return "redirect:/turma/listarturma";
	}
   
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable("id") Integer id, Model model) {

		System.out.println("Editar" + id);

		model.addAttribute("turma", turmaService.buscarPorId(id));
		
		
		return "/turma/formulario";
	}
	

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable("id") Integer id) {
		
		turmaService.removerPorId(id);
		
		return "redirect:/turma/listarturma";
	}

}

package com.unitins.projetointegrador2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unitins.projetointegrador2.model.Turma;
import com.unitins.projetointegrador2.service.TurmaService;

@Controller
@RequestMapping("/")
public class TurmaController {

	private TurmaService turmaService;

	public TurmaController(TurmaService turmaService) {
		super();
		this.turmaService = turmaService;
	}

	@GetMapping("/listarturma")
	public String listarturma(Model model) {
		model.addAttribute("turmas", turmaService.listarTodos());

		return "/listarturma";
	}
	
	@GetMapping("/formularioturma")
	public String listar(Model model) {
		model.addAttribute("turma", new Turma());
		model.addAttribute("turmas", turmaService.listarTodos());
		
		return "/formularioturma";
	}

	@PostMapping("/salvar")
	public String salvar(Turma turma) {

		System.out.println(turma);

		turmaService.salvar(turma);

		return "redirect:/listarturma";
	}
   
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable("id") Integer id, Model model) {

		System.out.println("Editar" + id);

		model.addAttribute("turma", turmaService.buscarPorId(id));
		
		
		return "/formularioturma";
	}
	

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable("id") Integer id) {
		
		turmaService.removerPorId(id);
		
		return "redirect:/listarturma";
	}

}

package com.unitins.projetointegrador2.controller;

import com.unitins.projetointegrador2.model.Turma;
import com.unitins.projetointegrador2.repository.TurmaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TurmaController {

	private final TurmaRepository turmaRepository;

	public TurmaController(TurmaRepository turmaRepository) {
		this.turmaRepository = turmaRepository;
	}

	@GetMapping("/listarturma")
	public String listarturma(Model model) {
		model.addAttribute("turmas", turmaRepository.findAll());

		return "/listarturma";
	}
	
	@GetMapping("/formularioturma")
	public String listar(Model model) {
		model.addAttribute("turma", new Turma());
		model.addAttribute("turmas", turmaRepository.findAll());
		
		return "/formularioturma";
	}

	@PostMapping("/salvar")
	public String salvar(Turma turma) {

		System.out.println(turma);

		turmaRepository.save(turma);

		return "redirect:/listarturma";
	}
   
	@GetMapping("/{id}/editar")
	public String editar(@PathVariable("id") Integer id, Model model) {

		System.out.println("Editar" + id);

		model.addAttribute("turma", turmaRepository.findById(id));
		
		
		return "/formularioturma";
	}
	

	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable("id") Integer id) {
		
		turmaRepository.deleteById(id);
		
		return "redirect:/listarturma";
	}

}

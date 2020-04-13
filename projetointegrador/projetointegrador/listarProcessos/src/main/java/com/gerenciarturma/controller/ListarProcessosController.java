package com.gerenciarturma.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gerenciarturma.model.Turma;
import com.gerenciarturma.service.ListarProcessosService;

@Controller
@RequestMapping("/listarprocessos")
public class ListarProcessosController {

	private ListarProcessosService listarProcessosService;

	public ListarProcessosController(ListarProcessosService listarProcessosService) {
		super();
		this.listarProcessosService = listarProcessosService;
	}

	@GetMapping("/listarProcessos")
	public String listarturma(Model model) {
		model.addAttribute("listagem", listarProcessosService.listarTodos());

		return "/listarprocessos/listarProcessos";
	}

	@GetMapping("/formulario")
	public String listar(Model model) {
		model.addAttribute("turma", new Turma());
		
		return "/turma/formulario";
	}
	

}

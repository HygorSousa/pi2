package com.projetointegrador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projetointegrador.model.Proposta;
import com.projetointegrador.service.PropostaService;

@Controller
@RequestMapping("/proposta")
public class PropostaController {
	
	private PropostaService propostaService;
	private String colunaSelecionada;
	private Proposta proposta;
	private String texto;

	public PropostaController(PropostaService propostaService) {
		super();
		this.propostaService = propostaService;
	}
	
	@GetMapping("/listarproposta")
	public String listarTurma(Model model) {
		model.addAttribute("propostas", propostaService.listartodos());
		return "/proposta/listarproposta";
	}
	
	@GetMapping("/formulario")
	public String listar(Model model) {
		model.addAttribute("proposta", new Proposta());
		model.addAttribute("propostas", propostaService.listartodos());
		
		return "/proposta/formulario";
	}
	
	@PostMapping("/salvar")
	public String salvar(Proposta proposta) {
		System.out.println(proposta);
		
		propostaService.salvar(proposta);
		
		return "redirect:/proposta/listarproposta";
	}
	
	@GetMapping("/{id}/editar")
	public String editar (@PathVariable("id") Integer id, Model model) {
		System.out.println("Editar" + id);
		
		model.addAttribute("proposta", propostaService.buscarPorId(id));
		
		return "/proposta/formulario";
	}
	
	
	@GetMapping("/{id}/excluir")
	public String excluir(@PathVariable("id") Integer id) {
		
		propostaService.removerPorId(id);
		
		return "redirect:/proposta/listarproposta";
		
	}
	
	public void pesquisar() {

        String hql = "SELECT vo FROM Usuario vo"
                + " WHERE UPPER(CAST(vo." + this.colunaSelecionada + " as text)) "
                + " LIKE '" + this.texto.toUpperCase() + "%' "
                + " AND vo.nivel!='SUPER'"
                + " ORDER BY vo." + this.colunaSelecionada + " ASC";
        
    }

	public String getColunaSelecionada() {
		return colunaSelecionada;
	}

	public void setColunaSelecionada(String colunaSelecionada) {
		this.colunaSelecionada = colunaSelecionada;
	}

	public Proposta getProposta() {
		return proposta;
	}

	public void setProposta(Proposta proposta) {
		this.proposta = proposta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}

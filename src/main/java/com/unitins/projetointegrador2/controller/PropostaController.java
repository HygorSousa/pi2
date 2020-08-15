package com.unitins.projetointegrador2.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.model.Proposta;
import com.unitins.projetointegrador2.model.Status;
import com.unitins.projetointegrador2.model.TipoProcessoOrientacao;
import com.unitins.projetointegrador2.model.Turma;
import com.unitins.projetointegrador2.repository.AlunoRepository;
import com.unitins.projetointegrador2.repository.ProfessorRepository;
import com.unitins.projetointegrador2.repository.PropostaRepository;
import com.unitins.projetointegrador2.repository.TurmaRepository;
import com.unitins.projetointegrador2.services.PropostaService;

@Controller
public class PropostaController {

	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;	

	@Autowired
	private AlunoRepository alunoRepository;
	
	@Autowired
	private TurmaRepository turmaRepository;
	
	@Autowired
	PropostaService service;
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/cadastro_proposta")
	public ModelAndView inicio() {

		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_proposta");
		modelAndView.addObject("propostaobj", new Proposta());

		Iterable<Proposta> propostaIt = propostaRepository.findAll();
		
		modelAndView.addObject("propostas", propostaIt);
		
		modelAndView.addObject("alunos", listaDeAlunos());
		
		modelAndView.addObject("professores", listaDeProfessores());
		
		modelAndView.addObject("turmas", listaDeTurmas());
		
		
		// carregando os tipos de proposta
		modelAndView.addObject("tipo", TipoProcessoOrientacao.values());

		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST,  value = "**/salvarproposta")
	public ModelAndView salvar(Proposta proposta) {

		propostaRepository.save(proposta);

		ModelAndView andView = new ModelAndView("cadastro/cadastro_proposta");
		Iterable<Proposta> propostaIt = propostaRepository.findAll();

		andView.addObject("propostas", propostaIt);
		andView.addObject("propostaobj", new Proposta());

		return andView;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/listapropostas")
	public ModelAndView propostas() {
		
		ModelAndView andView = new ModelAndView("cadastro/cadastro_proposta");
		Iterable<Proposta> propostaIt = propostaRepository.findAll();
		
		andView.addObject("propostas", propostaIt);
		andView.addObject("propostaobj", new Proposta());
		
		// carregando os tipos de proposta
		andView.addObject("tipo", TipoProcessoOrientacao.values());
		
		return andView;
	}
	
	@GetMapping("/editarprop/{idprop}")
	public ModelAndView editar(@PathVariable("idprop") Integer idprop) {
		
		Optional<Proposta> proposta = propostaRepository.findById(idprop);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_proposta");
		modelAndView.addObject("propostaobj", proposta.get());
		
		return modelAndView;
	}
	
	@GetMapping("/removerprop/{idprop}")
	public ModelAndView excluir(@PathVariable("idprop") Integer idprop) {
		
		propostaRepository.deleteById(idprop);
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_proposta");
		modelAndView.addObject("propostas", propostaRepository.findAll());
		modelAndView.addObject("propostaobj", new Proposta());
		
		return modelAndView;
	}
	
	@RequestMapping(value = "**/pesquisarprop", method = RequestMethod.POST)
	public ModelAndView pesquisar(@RequestParam("titulopesquisa") String titulopesquisa,
			@RequestParam("pesquisarAluno") String pesquisarAluno, 
			@RequestParam("pesquisarProfessor") String pesquisarProfessor,
			@RequestParam("pesquisarTurma") String pesquisarTurma, 
			@RequestParam(value = "tipo", required = false) String pesquisarTipo,
			@RequestParam("dataInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataInicio,
			@RequestParam("dataFim")  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dataFim){
		
		ModelAndView modelAndView = new ModelAndView("cadastro/cadastro_proposta");
		
		
		if (pesquisarTipo == null) {
			if (dataInicio == null && dataFim == null){
				modelAndView.addObject("propostas", propostaRepository.findWithoutTipoAndDatas(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma)); 
			} else if (dataInicio != null && dataFim != null) {
				modelAndView.addObject("propostas", propostaRepository.findWithoutTipo(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma, dataInicio, dataFim));  
			}else if (dataInicio != null){
				modelAndView.addObject("propostas", propostaRepository.findWithoutTipoAndDataFim(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma, dataInicio));  
			}else {
				modelAndView.addObject("propostas", propostaRepository.findWithoutTipoAndDataInicio(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma, dataFim));  
			}
		}
		else {
			if (dataInicio == null && dataFim == null){
				modelAndView.addObject("propostas", propostaRepository.findGeneralWithoutDatas(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma, pesquisarTipo));  
			} else if (dataInicio != null && dataFim != null) {
				modelAndView.addObject("propostas", propostaRepository.findGeneral(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma, pesquisarTipo, dataInicio, dataFim));  
			}else if (dataInicio != null){
				modelAndView.addObject("propostas", propostaRepository.findGeneralWithoutDataFim(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma, pesquisarTipo, dataInicio));
			}else {
				modelAndView.addObject("propostas", propostaRepository.findGeneralWithoutDataInicio(titulopesquisa, pesquisarAluno, pesquisarProfessor, pesquisarTurma, pesquisarTipo, dataFim));  
			}
		}
		
		modelAndView.addObject("propostaobj", new Proposta());
		
		// carregando os tipos de proposta
		modelAndView.addObject("tipo", TipoProcessoOrientacao.values());
		
		return modelAndView;
	}
	
	@GetMapping("/detalhes_processo/{idproposta}")
	public ModelAndView detalhes(@PathVariable("idproposta") Integer idproposta) {

		Optional<Proposta> proposta = propostaRepository.findGeneralById(idproposta);

		ModelAndView modelAndView = new ModelAndView("cadastro/detalhes_processo");
		modelAndView.addObject("propostaobj", proposta.get());

		return modelAndView;
	}
	
	public Status[] getListaStatus() {
		return Status.values();
	}
	
	@ModelAttribute("professores")
	public List<Professor> listaDeProfessores() {
		return (List<Professor>) professorRepository.findAll();
	}
	
	@ModelAttribute("turmas") 
	public List<Turma> listaDeTurmas() {
		return (List<Turma>) turmaRepository.findAll();
	}

	@ModelAttribute("alunos")
	public List<Aluno> listaDeAlunos() {
		return (List<Aluno>) alunoRepository.findAll();
	}

	@ModelAttribute("tipos")
	public TipoProcessoOrientacao[] getTipos() {
		return TipoProcessoOrientacao.values();
	}
}

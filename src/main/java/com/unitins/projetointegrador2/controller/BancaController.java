package com.unitins.projetointegrador2.controller;

import com.unitins.projetointegrador2.model.Banca;
import com.unitins.projetointegrador2.model.ProcessoOrientacao;
import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.repository.BancaRepository;
import com.unitins.projetointegrador2.repository.ProcessoOrientacaoRepository;
import com.unitins.projetointegrador2.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class BancaController {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private BancaRepository bancaRepository;

    @Autowired
    private ProcessoOrientacaoRepository processoOrientacaoRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro_banca")
    public ModelAndView inicio() {

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");
        modelAndView.addObject("banca_obj", new Banca());

        Iterable<Banca> bancasIt = bancaRepository.findAll();
        modelAndView.addObject("bancas", bancasIt);
        carregarListas(modelAndView);
        return modelAndView;
    }

    public ModelAndView carregarListas(ModelAndView modelAndView){

        Iterable<Professor> professorIt = professorRepository.findAll();
        modelAndView.addObject("list_professores", professorIt);

        Iterable<ProcessoOrientacao> processoOrientacaoIt = processoOrientacaoRepository.findAll();
        modelAndView.addObject("processos", processoOrientacaoIt);
        return modelAndView;
    }
    @RequestMapping(method = RequestMethod.POST, value = "**/salvar_banca")
    public ModelAndView salvar(Banca banca) {

        bancaRepository.save(banca);

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");

        Iterable<Banca> bancasIt = bancaRepository.findAll();
        modelAndView.addObject("bancas", bancasIt);

        return inicio();
    }

    @GetMapping("/alterar_banca/{id_banca}")
    public ModelAndView alterar(@PathVariable("id_banca") Integer id_banca) {

        Optional<Banca> banca = bancaRepository.findById(id_banca);

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");
        modelAndView.addObject("banca_obj", banca.get());
        carregarListas(modelAndView);
        return modelAndView;
    }

    @GetMapping("/deletar_banca/{id_banca}")
    public ModelAndView excluir(@PathVariable("id_banca") Integer id_banca) {

        bancaRepository.deleteById(id_banca);
        return inicio();
    }

    @GetMapping("/lista_banca")
    public ModelAndView listar() {

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");
        Iterable<Banca> bancasIt = bancaRepository.findAll();

        modelAndView.addObject("bancas", bancasIt);
        modelAndView.addObject("banca_obj", new Banca());
        carregarListas(modelAndView);
        return modelAndView;
    }
}

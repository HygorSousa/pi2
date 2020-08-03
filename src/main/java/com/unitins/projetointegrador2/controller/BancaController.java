package com.unitins.projetointegrador2.controller;

import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.model.ProcessoOrientacao;
import com.unitins.projetointegrador2.repository.ProcessoOrientacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class BancaController {

    private final ProcessoOrientacaoRepository repository;

    public BancaController(ProcessoOrientacaoRepository orientacaoRepository) {
        this.repository = orientacaoRepository;
    }

    @GetMapping("banca")
    public String index() {
        return "banca";
    }

    @PostMapping("buscarPropostas")
    public ModelAndView buscarProcessos(ModelAndView modelAndView, @RequestParam("nomeAluno") String nomeAluno, @RequestParam("nomeOrientador") String nomeProfessor, @RequestParam("turmaAno") String turmaAno) {

        Optional<List<ProcessoOrientacao>> processos = repository.findByAluno_NomeOrProfessorOrientador_Nome(nomeAluno, nomeProfessor);

        if (processos.isPresent()) {
            modelAndView.addObject("processos", processos);
        } else {
            modelAndView.addObject("errorMessage", "Oops! Não foi encontrado processo com esses filtros!");
        }

        modelAndView.setViewName("banca");
        return modelAndView;
    }

}

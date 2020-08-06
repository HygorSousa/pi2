package com.unitins.projetointegrador2.controller;

import com.unitins.projetointegrador2.model.Banca;
import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.repository.BancaRepository;
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
    private BancaRepository bancaRepository;

    @RequestMapping(method = RequestMethod.GET, value = "/cadastro_banca")
    public ModelAndView inicio() {

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");
        modelAndView.addObject("professor_obj", new Professor());

        Iterable<Professor> professorIt = professorRepository.findAll();
        modelAndView.addObject("professores", professorIt);

        //Iterable<Banca> bancasIt = bancaRepository.findAll();
        //modelAndView.addObject("bancas", bancasIt);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "**/salvar_banca")
    public ModelAndView salvar(Banca banca) {

        bancaRepository.save(banca);

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");

        Iterable<Banca> bancasIt = bancaRepository.findAll();
        modelAndView.addObject("bancas", bancasIt);

        modelAndView.addObject(" banca_obj", new Banca());

        return modelAndView;
    }

    @GetMapping("/alterar_banca/{id_banca}")
    public ModelAndView alterar(@PathVariable("id_banca") Integer id_banca) {

        Optional<Banca> banca = bancaRepository.findById(id_banca);

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");
        modelAndView.addObject("banca_obj", banca.get());

        return modelAndView;
    }

    @GetMapping("/deletar_banca/{id_banca}")
    public ModelAndView excluir(@PathVariable("id_banca") Integer id_banca) {

        bancaRepository.deleteById(id_banca);

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");
        modelAndView.addObject("bancas", bancaRepository.findAll());

        modelAndView.addObject("banca_obj", new Banca());

        return modelAndView;
    }

    @GetMapping("/lista_banca")
    public ModelAndView listar() {

        ModelAndView modelAndView = new ModelAndView("cadastro_banca");
        Iterable<Banca> bancasIt = bancaRepository.findAll();

        modelAndView.addObject("bancas", bancasIt);
        modelAndView.addObject("banca_obj", new Banca());

        return modelAndView;
    }
}

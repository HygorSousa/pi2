package com.unitins.projetointegrador2.controller;

import com.unitins.projetointegrador2.model.Curso;
import com.unitins.projetointegrador2.repository.CursoRepository;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/curso")
public class CursoController {

    private final CursoRepository cursoRepository;

    public CursoController(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @GetMapping()
    public String listar(Model model) {
        model.addAttribute("cursos", cursoRepository.findAll());
        return "listarCurso";
    }

    @GetMapping("/filtrarPorNome")
    public String listarFiltradaPorNome(@RequestParam(required = false) String nome,
                                        Model model) {

        model.addAttribute("cursos", cursoRepository.findByNome(nome));
        return "listarCurso";
    }

    @GetMapping("/filtrarPorDescricao")
    public String listarFiltradaPorDescricao(@RequestParam(required = false) String descricao,
                                             Model model) {

        model.addAttribute("cursos", cursoRepository.findByDescricao(descricao));
        return "listarCurso";
    }

    @PostMapping()
    public String salvarCurso( Curso curso, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/criarCurso";
        }
        cursoRepository.save(curso);

        model.addAttribute("cursos", cursoRepository.findAll());
        return "redirect:/listarCurso";
    }

    @PostMapping("/editarCurso/{id}")
    public String editarAluno(@PathVariable(required = false) Integer id, Model model) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Não foi possível encontrar esse Curso"));
        model.addAttribute("curso", curso);
        return "redirect:/cadastrarCurso";
    }

    @RequestMapping("/excluirCurso/{id}")
    public String excluirCurso(@PathVariable Integer id, Model model) {
        try {
            cursoRepository.deleteById(id);
            model.addAttribute("cursos", cursoRepository.findAll());
        } catch (ConstraintViolationException constraintViolationException) {
            model.addAttribute("erroAoExcluir", true);
        }
        return "redirect:/listarCurso";
    }

}

package com.unitins.projetointegrador2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BancaController {

    @GetMapping("cadastro/cadastro_banca")
    public String cadastroBanca() {
        return "cadastro_banca";
    }
}

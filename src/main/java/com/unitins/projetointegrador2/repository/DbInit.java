package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.Adminstrador;
import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.model.Professor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private final PessoaRepository pessoaRepository;

    public DbInit(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.pessoaRepository.deleteAll();

        // Crete users
        Pessoa admin = new Adminstrador("Sérgio Ian Nelson Caldeira", "324897078", "88389605937", new BCryptPasswordEncoder().encode("admin"), "ADMIN");
        Pessoa professor = new Professor("Valentina Nina Ferreira", "446544917", "99753154100", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR");
        Pessoa aluno = new Aluno("Tomás Lucca Giovanni Aragão", "336330418", "89433127170", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");

        List<Pessoa> users = Arrays.asList(admin, professor, aluno);

        // Save to db
        this.pessoaRepository.saveAll(users);
    }
}
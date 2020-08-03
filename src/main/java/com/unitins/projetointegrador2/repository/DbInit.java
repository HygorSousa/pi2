package com.unitins.projetointegrador2.repository;

import com.unitins.projetointegrador2.model.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DbInit implements CommandLineRunner {
    private final PessoaRepository pessoaRepository;
    private final ProcessoOrientacaoRepository processoOrientacaoRepository;

    public DbInit(PessoaRepository pessoaRepository, ProcessoOrientacaoRepository processoOrientacaoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.processoOrientacaoRepository = processoOrientacaoRepository;
    }

    @Override
    public void run(String... args) {
        // Delete all
        this.pessoaRepository.deleteAll();

        // Crete users
        Pessoa admin = new Adminstrador("Sérgio Ian Nelson Caldeira", "324897078", "88389605937", new BCryptPasswordEncoder().encode("admin"), "ADMIN");
        Professor professor = new Professor("Valentina Nina Ferreira", "446544917", "99753154100", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR");
        Aluno aluno = new Aluno("Tomás Lucca Giovanni Aragão", "336330418", "89433127170", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");

        List<Pessoa> users = Arrays.asList(admin, professor, aluno);

        // Save to db
        this.pessoaRepository.saveAll(users);

        this.processoOrientacaoRepository.deleteAll();

        ProcessoOrientacao processo1 = new ProcessoOrientacao(Status.ANALISE, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo2 = new ProcessoOrientacao(Status.REJEITADOANALISE, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo3 = new ProcessoOrientacao(Status.ENCAMINHADOORIENTADOR, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo4 = new ProcessoOrientacao(Status.REJEITADO, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo5 = new ProcessoOrientacao(Status.ACEITO, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo6 = new ProcessoOrientacao(Status.ASSINARTERMOCOMPROMISSO, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo7 = new ProcessoOrientacao(Status.ASSINARTERMORESPONSABILIDADE, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo8 = new ProcessoOrientacao(Status.ANDAMENTO, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo9 = new ProcessoOrientacao(Status.APROVADO, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo10 = new ProcessoOrientacao(Status.BANCA, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo11 = new ProcessoOrientacao(Status.CORRIGIDO, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo12 = new ProcessoOrientacao(Status.ENVIOATA, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo13 = new ProcessoOrientacao(Status.ENVIOFICHA, "", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo14 = new ProcessoOrientacao(Status.FINALIZADO, "", "", TipoProcessoOrientacao.PCC, aluno, professor);

        List<ProcessoOrientacao> processoOrientacaos = Arrays.asList(processo1, processo2, processo3, processo4, processo5, processo6, processo7, processo8, processo9, processo10, processo11, processo12, processo13, processo14);

        this.processoOrientacaoRepository.saveAll(processoOrientacaos);
    }
}
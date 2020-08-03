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
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;

    public DbInit(TurmaRepository turmaRepository, PessoaRepository pessoaRepository, ProcessoOrientacaoRepository processoOrientacaoRepository, AlunoRepository alunoRepository) {
        this.pessoaRepository = pessoaRepository;
        this.processoOrientacaoRepository = processoOrientacaoRepository;
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
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

        initAluno();
        initProcessoOrientacao(aluno, professor);
        initTurma();


    }

    private void initAluno(){
        Aluno aluno   = new Aluno("André Souza",    "336330419", "84565618435", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno1  = new Aluno("Jacklyn Snyder", "336330420", "89433127170", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno2  = new Aluno("Sandra Gonzales","336330421", "89433127171", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno3  = new Aluno("Donald Wilson",  "336330422", "89433127172", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno4  = new Aluno("Marie Trice",    "336330423", "89433127173", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno5  = new Aluno("Ryan Pinto",     "336330424", "89433127174", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno6  = new Aluno("Marcus Mertens", "336330425", "89433127175", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno7  = new Aluno("Victor Azevedo", "336330426", "89433127176", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno8  = new Aluno("Milton Frazier", "336330427", "89433127177", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno9  = new Aluno("Eduardo Santos", "336330428", "89433127178", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        Aluno aluno10 = new Aluno("Ginny Evans",    "336330429", "89433127179", new BCryptPasswordEncoder().encode("alu123"), "ALUNO");
        List<Pessoa> alunos = Arrays.asList(aluno, aluno1,aluno2,aluno3,aluno4,aluno5,aluno6,aluno7,aluno8,aluno9,aluno10);
        this.pessoaRepository.saveAll(alunos);
    }

    private void initProcessoOrientacao(Aluno aluno, Professor professor){
        this.processoOrientacaoRepository.deleteAll();

        ProcessoOrientacao processo1  = new ProcessoOrientacao(Status.ANALISE, "pss1", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo2  = new ProcessoOrientacao(Status.REJEITADOANALISE, "pss2", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo3  = new ProcessoOrientacao(Status.ENCAMINHADOORIENTADOR, "pss3", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo4  = new ProcessoOrientacao(Status.REJEITADO, "pss4", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo5  = new ProcessoOrientacao(Status.ACEITO, "pss5", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo6  = new ProcessoOrientacao(Status.ASSINARTERMOCOMPROMISSO, "pss6", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo7  = new ProcessoOrientacao(Status.ASSINARTERMORESPONSABILIDADE, "pss7", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo8  = new ProcessoOrientacao(Status.ANDAMENTO, "pss8", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo9  = new ProcessoOrientacao(Status.APROVADO, "pss9", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo10 = new ProcessoOrientacao(Status.BANCA, "pss10", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo11 = new ProcessoOrientacao(Status.CORRIGIDO, "pss11", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo12 = new ProcessoOrientacao(Status.ENVIOATA, "pss12", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo13 = new ProcessoOrientacao(Status.ENVIOFICHA, "pss13", "", TipoProcessoOrientacao.PCC, aluno, professor);
        ProcessoOrientacao processo14 = new ProcessoOrientacao(Status.FINALIZADO, "pss14", "", TipoProcessoOrientacao.PCC, aluno, professor);

        List<ProcessoOrientacao> processoOrientacaos = Arrays.asList(processo1, processo2, processo3, processo4, processo5, processo6, processo7, processo8, processo9, processo10, processo11, processo12, processo13, processo14);
        this.processoOrientacaoRepository.saveAll(processoOrientacaos);
    }

    private void initTurma(){
        Turma turmaA = new Turma(2020, 2, this.alunoRepository.findAll());
        Turma turmaB = new Turma(2019, 1, this.alunoRepository.findAll());
        List<Turma> turmas = Arrays.asList(turmaA,turmaB);
        this.turmaRepository.saveAll(turmas);
    }
}
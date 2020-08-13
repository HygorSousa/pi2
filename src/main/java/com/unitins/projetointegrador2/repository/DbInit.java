package com.unitins.projetointegrador2.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unitins.projetointegrador2.model.Adminstrador;
import com.unitins.projetointegrador2.model.Aluno;
import com.unitins.projetointegrador2.model.AreaConhecimento;
import com.unitins.projetointegrador2.model.Banca;
import com.unitins.projetointegrador2.model.Pessoa;
import com.unitins.projetointegrador2.model.ProcessoOrientacao;
import com.unitins.projetointegrador2.model.Professor;
import com.unitins.projetointegrador2.model.Status;
import com.unitins.projetointegrador2.model.TipoProcessoOrientacao;
import com.unitins.projetointegrador2.model.Turma;

@Service
public class DbInit implements CommandLineRunner {
    private final AlunoRepository alunoRepository;
    private final TurmaRepository turmaRepository;
    private final BancaRepository bancaRepository;
    private final PessoaRepository pessoaRepository;
    private final ProfessorRepository professorRepository;
    private final AreaConhecimentoRepository areaConhecimentoRepository;
    private final ProcessoOrientacaoRepository processoOrientacaoRepository;

    public DbInit(BancaRepository bancaRepository, ProfessorRepository professorRepository, AreaConhecimentoRepository areaConhecimentoRepository, TurmaRepository turmaRepository, PessoaRepository pessoaRepository, ProcessoOrientacaoRepository processoOrientacaoRepository, AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
        this.turmaRepository = turmaRepository;
        this.bancaRepository = bancaRepository;
        this.pessoaRepository = pessoaRepository;
        this.professorRepository = professorRepository;
        this.areaConhecimentoRepository = areaConhecimentoRepository;
        this.processoOrientacaoRepository = processoOrientacaoRepository;
    }

    @Override
    public void run(String... args) {
    	
        // Deleta todas as pessoas
        this.pessoaRepository.deleteAll();

        // Create admin
        Pessoa admin = new Adminstrador("Sérgio Ian Nelson Caldeira", "324897078", "88389605937", new BCryptPasswordEncoder().encode("admin"), "ADMIN");
        this.pessoaRepository.save(admin);
        
        // Deleta todas as turmas
        this.turmaRepository.deleteAll();
        // Cria turmas
        Turma turmaA = new Turma(2020, "1", (List<Aluno>) this.alunoRepository.findAll());
        Turma turmaB = new Turma(2019, "1", (List<Aluno>) this.alunoRepository.findAll());
        Turma turmaC = new Turma(2020, "2", (List<Aluno>) this.alunoRepository.findAll());
        Turma turmaD = new Turma(2019, "2", (List<Aluno>) this.alunoRepository.findAll());
        List<Turma> turmas = Arrays.asList(turmaA,turmaB,turmaC,turmaD);
        this.turmaRepository.saveAll(turmas);
       
        // Cria alunos
        Aluno aluno1  = new Aluno("Jacklyn Snyder", "336330420", "89433127170", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaA);
        Aluno aluno2  = new Aluno("Sandra Gonzales","336330421", "89433127171", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaA);
        Aluno aluno3  = new Aluno("Donald Wilson",  "336330422", "89433127172", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaA);
        Aluno aluno4  = new Aluno("Marie Trice",    "336330423", "89433127173", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaA);
        Aluno aluno5  = new Aluno("Ryan Pinto",     "336330424", "89433127174", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaA);
        Aluno aluno6  = new Aluno("Marcus Mertens", "336330425", "89433127175", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaB);
        Aluno aluno7  = new Aluno("Victor Azevedo", "336330426", "89433127176", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaB);
        Aluno aluno8  = new Aluno("Milton Frazier", "336330427", "89433127177", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaB);
        Aluno aluno9  = new Aluno("Eduardo Santos", "336330428", "89433127178", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaB);
        Aluno aluno10 = new Aluno("Ginny Evans",    "336330429", "89433127179", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaB);
        Aluno aluno11  = new Aluno("Michael Snyder", "336330420", "89433127170", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaB);
        Aluno aluno12  = new Aluno("Rodrigo Gonzales","336330421", "89433127171", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaB);
        Aluno aluno13  = new Aluno("Fernando Wilson",  "336330422", "89433127172", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaC);
        Aluno aluno14  = new Aluno("Magali Trice",    "336330423", "89433127173", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaC);
        Aluno aluno15  = new Aluno("Fred Pinto",     "336330424", "89433127174", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaC);
        Aluno aluno16  = new Aluno("Mateus Mertens", "336330425", "89433127175", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaC);
        Aluno aluno17  = new Aluno("Roni Azevedo", "336330426", "89433127176", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaD);
        Aluno aluno18  = new Aluno("Fatima Frazier", "336330427", "89433127177", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaD);
        Aluno aluno19  = new Aluno("Augusto Santos", "336330428", "89433127178", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaD);
        Aluno aluno20 = new Aluno("Marcos Evans",    "336330429", "89433127179", new BCryptPasswordEncoder().encode("alu123"), "ALUNO", turmaD);
        List<Pessoa> alunos = Arrays.asList(aluno1,aluno2,aluno3,aluno4,aluno5,aluno6,aluno7,aluno8,aluno9,aluno10,aluno11,aluno12,aluno13,aluno14,aluno15,aluno16,aluno17,aluno18,aluno19,aluno20);
        this.pessoaRepository.saveAll(alunos);
        
        // Deleta todas as AreaConhecimentos
        this.areaConhecimentoRepository.deleteAll();
        //Cria AreaConhecimentos
        AreaConhecimento areaA = new AreaConhecimento("SISTEMAS DINÂMICOS", "MATEMÁTICA");
        AreaConhecimento areaD = new AreaConhecimento("PROBABILIDADE E ESTATÍSTICA APLICADAS", "PROBABILIDADE E ESTATÍSTICA");
        AreaConhecimento areaB = new AreaConhecimento("ANÁLISE DE ALGORÍTMOS E COMPLEXIDADE DE COMPUTAÇÃO", "CIÊNCIA DA COMPUTAÇÃO");
        AreaConhecimento areaC = new AreaConhecimento("ENGENHARIA DE SOFTWARE", "CIÊNCIA DA COMPUTAÇÃO");
        AreaConhecimento areaE = new AreaConhecimento("BANCO DE DADOS", "CIÊNCIA DA COMPUTAÇÃO");
        List<AreaConhecimento> areas = Arrays.asList(areaA,areaB,areaC,areaD,areaE);
        this.areaConhecimentoRepository.saveAll(areas);
        
        // Cria professores
        Professor professor1 = new Professor("Lavinia Cavalcanti", "446544910", "99753154101", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor2 = new Professor("Eduardo Lima", "446544911", "99753154102", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor3 = new Professor("Matilde Cavalcanti", "446544912", "99753154103", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor4 = new Professor("Lois Preston", "446544913", "99753154104", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor5 = new Professor("Christopher Mosley", "446544914", "99753154105", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor6 = new Professor("José Augusto", "446544910", "99753154101", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor7 = new Professor("Maria Santa", "446544911", "99753154102", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor8 = new Professor("Rodrigo Rodrigues", "446544912", "99753154103", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor9 = new Professor("Fernando Pinhão", "446544913", "99753154104", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        Professor professor10 = new Professor("Cristian Ferri", "446544914", "99753154105", new BCryptPasswordEncoder().encode("pro123"), "PROFESSOR", areas);
        List<Professor> professors = Arrays.asList(professor1,professor2,professor3,professor4,professor5,professor6,professor7,professor8,professor9,professor10);
        this.pessoaRepository.saveAll(professors);
        
        //Deleta todos ProcessoOrientacao
        this.processoOrientacaoRepository.deleteAll();
        // Create ProcessoOrientacao
        ProcessoOrientacao processo1  = new ProcessoOrientacao(Status.ANALISE, "Novas formas de inovar em saúde e bem estar", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno1, professor1);
        ProcessoOrientacao processo2  = new ProcessoOrientacao(Status.REJEITADOANALISE, "Analisar o impacto do BitCoin no direito digital e economia mundial.", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno2, professor2);
        ProcessoOrientacao processo3  = new ProcessoOrientacao(Status.ENCAMINHADOORIENTADOR, "BitCoin pode levantar na legislação atual", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno3, professor3);
        ProcessoOrientacao processo4  = new ProcessoOrientacao(Status.REJEITADO, "Estudar projetos, limitações, e modelos de negócio para o sistema opensource", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno4, professor4);
        ProcessoOrientacao processo5  = new ProcessoOrientacao(Status.ACEITO, "Propriedade de bens virtuais", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno5, professor5);
        ProcessoOrientacao processo6  = new ProcessoOrientacao(Status.ASSINARTERMOCOMPROMISSO, "Como garantir seus direitos e, mais importante", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno6, professor6);
        ProcessoOrientacao processo7  = new ProcessoOrientacao(Status.ASSINARTERMORESPONSABILIDADE, "O que acontece quando os prisioneiros da China", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno7, professor7);
        ProcessoOrientacao processo8  = new ProcessoOrientacao(Status.ANDAMENTO, "Investigar legislação para software que utiliza o poder ocioso das pessoas", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno8, professor8);
        ProcessoOrientacao processo9  = new ProcessoOrientacao(Status.APROVADO, "Técnicas para processamento de Linguagem Natural", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno9, professor9);
        ProcessoOrientacao processo10 = new ProcessoOrientacao(Status.BANCA, "Algoritmos para tagging de imagens automaticamente usando a internet", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno10, professor10);
        ProcessoOrientacao processo11 = new ProcessoOrientacao(Status.CORRIGIDO, "Porte ou criação de algoritmos explorando alto paralelismo em GPUs", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno11, professor1);
        ProcessoOrientacao processo12 = new ProcessoOrientacao(Status.ENVIOATA, "Desenvolvimento de IDE ou plugins para Cuda", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno12, professor2);
        ProcessoOrientacao processo13 = new ProcessoOrientacao(Status.ENVIOFICHA, "Melhores compiladores para o hardware gráfico baseado no código compilado do Cuda", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno13, professor3);
        ProcessoOrientacao processo14 = new ProcessoOrientacao(Status.FINALIZADO, "Volunteer Computing e / ou Computação Soberana", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.PCC, aluno14, professor4);
        ProcessoOrientacao processo15  = new ProcessoOrientacao(Status.BANCA, "Qual a diferença entre jogo ilegal e o BitCoin ", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.TCC, aluno15, professor5);
        ProcessoOrientacao processo16  = new ProcessoOrientacao(Status.BANCA, "Novas interfaces para dispositivos médicos e tecnologia da informação para a Medicina", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.TCC, aluno16, professor1);
        ProcessoOrientacao processo17  = new ProcessoOrientacao(Status.BANCA, "Assim como qualquer superfície é um display em potencial", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.TCC, aluno17, professor2);
        ProcessoOrientacao processo18  = new ProcessoOrientacao(Status.BANCA, "Ferramentas para gerência de acões em bolsa de valores e algorítmos", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.TCC, aluno18, professor3);
        ProcessoOrientacao processo19  = new ProcessoOrientacao(Status.BANCA, "Sistemas de gerência agrária, pecuária e pesca", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.TCC, aluno19, professor4);
        ProcessoOrientacao processo20 = new ProcessoOrientacao(Status.BANCA, "Uso de sesores de clima é essencial", "Idéias e Temas Quentes para TCC em Computação", TipoProcessoOrientacao.TCC, aluno20, professor5);
        List<ProcessoOrientacao> processoOrientacaos = Arrays.asList(processo1, processo2, processo3, processo4, processo5, processo6, processo7, processo8, processo9, processo10, 
        		processo11, processo12, processo13, processo14, processo15, processo16, processo17, processo18, processo19, processo20);
        this.processoOrientacaoRepository.saveAll(processoOrientacaos);

        
        //Montando professores para as bancas
        List<Professor> professoresBanca = (List<Professor>) this.professorRepository.findAll();
        List<Professor> professoresBancaAux1 = new ArrayList<>();
        professoresBancaAux1.add(professoresBanca.get(0));
        professoresBancaAux1.add(professoresBanca.get(1));
        professoresBancaAux1.add(professoresBanca.get(2));
        List<Professor> professoresBancaAux2 = new ArrayList<>();
        professoresBancaAux2.add(professoresBanca.get(3));
        professoresBancaAux2.add(professoresBanca.get(4));
        professoresBancaAux2.add(professoresBanca.get(5));
        List<Professor> professoresBancaAux3 = new ArrayList<>();
        professoresBancaAux3.add(professoresBanca.get(6));
        professoresBancaAux3.add(professoresBanca.get(7));
        professoresBancaAux3.add(professoresBanca.get(8));
        
        //Deleta bancas
        this.bancaRepository.deleteAll();
        // Create Banca
        Banca bancaA = new Banca(new Date(), new Date(), professoresBancaAux1, processo15);
        Banca bancaB = new Banca(new Date(), new Date(), professoresBancaAux1, processo16);
        Banca bancaC = new Banca(new Date(), new Date(), professoresBancaAux2, processo17);
        Banca bancaD = new Banca(new Date(), new Date(), professoresBancaAux2, processo18);
        Banca bancaE = new Banca(new Date(), new Date(), professoresBancaAux3, processo19);
        Banca bancaF = new Banca(new Date(), new Date(), professoresBancaAux3, processo20);
        List<Banca> bancas = Arrays.asList(bancaA,bancaB,bancaC,bancaD,bancaE,bancaF);
        this.bancaRepository.saveAll(bancas);
    }
}
package com.projetointegrador.seed;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.projetointegrador.model.Aluno;
import com.projetointegrador.model.Proposta;
import com.projetointegrador.model.Turma;
import com.projetointegrador.repository.AlunoRepository;
import com.projetointegrador.repository.PropostaRepository;
import com.projetointegrador.repository.TurmaRepository;

@Component
public class SeedDev implements ApplicationListener<ContextRefreshedEvent> {
	
	private TurmaRepository turmaRepository;
	private AlunoRepository alunoRepository;
	private PropostaRepository propostaRepository;

	

	public SeedDev(TurmaRepository turmaRepository, AlunoRepository alunoRepository,
			PropostaRepository propostaRepository) {
		super();
		this.turmaRepository = turmaRepository;
		this.alunoRepository = alunoRepository;
		this.propostaRepository = propostaRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		inserirDados();
		
	}
	
	public void inserirDados() {
		
		Turma turma1 = new Turma();
		turma1.setSemestre("1º Semestre");
		
		Turma turma2 = new Turma();
		turma2.setSemestre("2° Semestre");
		
		if(turmaRepository.count() == 0) {
			
			turma1.setAno(2018);
			turma2.setAno(2018);	
			
			
			turmaRepository.save(turma1);
			turmaRepository.save(turma2);
			
		}
		
		Aluno aluno1 = new Aluno();
//		aluno1.setTurma(turma1);
		
		Aluno aluno2 = new Aluno();
//		aluno2.setTurma(turma2);
		
		
		if(alunoRepository.count() == 0) {
			aluno1.setNome("Paulo");
			aluno1.setMatricula("20181");
			aluno1.setCpf("01001001010");
			
			alunoRepository.save(aluno1);
			
			aluno2.setNome("Mateus");
			aluno2.setMatricula("20182");
			aluno2.setCpf("01001011111");
			
			alunoRepository.save(aluno2);
		}
		
		
		Proposta proposta = new Proposta();
		
		if(propostaRepository.count() == 0) {
			proposta.setNome("Jhemys");
			
			propostaRepository.save(proposta);
		}
		
		
		
	}

}

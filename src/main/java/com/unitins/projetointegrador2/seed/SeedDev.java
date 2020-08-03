package com.unitins.projetointegrador2.seed;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.unitins.projetointegrador2.model.Turma;
import com.unitins.projetointegrador2.security.TurmaRepository;

@Component
public class SeedDev implements ApplicationListener<ContextRefreshedEvent> {
	
	private TurmaRepository turmaRepository;
	
	

	public SeedDev(TurmaRepository turmaRepository) {
		super();
		this.turmaRepository = turmaRepository;
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
		
		
	}

}

package com.gerenciarturma.seed;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.gerenciarturma.model.Turma;
import com.gerenciarturma.repository.ListarProcessosRepository;

@Component
public class SeedDev implements ApplicationListener<ContextRefreshedEvent> {
	
	private ListarProcessosRepository turmaRepository;
	
	

	public SeedDev(ListarProcessosRepository turmaRepository) {
		super();
		this.turmaRepository = turmaRepository;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		inserirDados();
		
	}
	
	public void inserirDados() {
		
		
		if(turmaRepository.count() == 0) {
			Turma turma1 = new Turma();
			turma1.setAno(2018);
			turma1.setSemestre("1º Semestre");
			
			Turma turma2 = new Turma();
			turma2.setAno(2018);	
			turma2.setSemestre("2° Semestre");
			
			turmaRepository.save(turma1);
			turmaRepository.save(turma2);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

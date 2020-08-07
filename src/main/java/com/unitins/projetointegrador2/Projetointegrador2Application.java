package com.unitins.projetointegrador2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Projetointegrador2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projetointegrador2Application.class, args);
	}

}

package com.unitins.projetointegrador2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "com.unitins.projetointegrador2.model") 
@ComponentScan(basePackages = {"com.*"})
@EnableJpaRepositories(basePackages = {"com.unitins.projetointegrador2.repository"}) 
@EnableTransactionManagement
public class Projetointegrador2Application {

	public static void main(String[] args) {
		SpringApplication.run(Projetointegrador2Application.class, args);
	}

}

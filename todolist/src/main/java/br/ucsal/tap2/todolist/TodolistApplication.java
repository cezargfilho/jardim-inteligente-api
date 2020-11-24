package br.ucsal.tap2.todolist;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.ucsal.tap2.todolist.model.Dados;
import br.ucsal.tap2.todolist.repository.DadosRepository;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(DadosRepository repo) {

		return (args) -> {
			repo.save(new Dados(65, 36.0d, 75, "24/11/2020", "13:00", 20));
			repo.save(new Dados(80, 35.5d, 70, "24/11/2020", "13:50", 0));
			repo.save(new Dados(40, 32.8d, 55, "24/11/2020", "14:40", 30));
			repo.save(new Dados(75, 32.7d, 29, "24/11/2020", "15:30", 0));
			repo.save(new Dados(29, 30.5d, 90, "24/11/2020", "16:20", 100));
		};
	}

}

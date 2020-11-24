package br.ucsal.tap2.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.tap2.todolist.model.Dados;

public interface DadosRepository extends JpaRepository<Dados, Long> {

}

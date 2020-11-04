package br.ucsal.tap2.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.tap2.todolist.model.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {

}

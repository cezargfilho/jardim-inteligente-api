package br.ucsal.tap2.todolist.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.ucsal.tap2.todolist.enums.Prioridade;

@Entity
public class Atividade {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	@Enumerated(EnumType.STRING)
	private Prioridade prioridade;

	public Atividade() {
	}

	public Atividade(AtividadeForm form) {
		this.titulo = form.getTitulo();
		this.prioridade = form.getPrioridade();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		this.prioridade = prioridade;
	}

	public Long getId() {
		return id;
	}

}

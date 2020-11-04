package br.ucsal.tap2.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.tap2.todolist.model.Atividade;
import br.ucsal.tap2.todolist.model.AtividadeForm;
import br.ucsal.tap2.todolist.repository.AtividadeRepository;

@RestController
@RequestMapping("/")
public class AtividadeController {

	@Autowired
	private AtividadeRepository repository;

	@GetMapping("/listar")
	public List<Atividade> listar() {
		return repository.findAll();
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Atividade> cadastrar(@RequestBody AtividadeForm form) {
		if (form == null) {
			return ResponseEntity.badRequest().build();
		}
		Atividade atividade = new Atividade(form);
		repository.save(atividade);
		return ResponseEntity.ok(atividade);
	}

	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Atividade> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();

	}

}

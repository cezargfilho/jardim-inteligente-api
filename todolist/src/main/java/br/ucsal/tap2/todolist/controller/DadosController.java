package br.ucsal.tap2.todolist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.tap2.todolist.model.Dados;
import br.ucsal.tap2.todolist.model.DadosForm;
import br.ucsal.tap2.todolist.model.DadosFormCript;
import br.ucsal.tap2.todolist.repository.DadosRepository;

@RestController
@RequestMapping("/dados")
public class DadosController {

	@Autowired
	private DadosRepository repository;

	@CrossOrigin
	@GetMapping("/list")
	public List<Dados> listar() {
		return repository.findAll();
	}

	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity<Dados> cadastrar(@RequestBody DadosForm form) {
		if (form == null) {
			return ResponseEntity.badRequest().build();
		}
		Dados atividade = new Dados(form);
		repository.save(atividade);
		return ResponseEntity.ok(atividade);
	}

	@CrossOrigin
	@PostMapping("/create/list")
	public ResponseEntity<?> cadastrar(
			@RequestBody List<DadosFormCript> forms,
			@RequestHeader("key") String key) {
		if (forms == null|| key == null || !key.equals("etmtNSgn") ) {
			return ResponseEntity.badRequest().build();
		}
		Dados dado;
		for (DadosFormCript dadosForm : forms) {
			dado = new Dados(dadosForm, key);
			repository.save(dado);
		}
		return ResponseEntity.ok().build();
	}

	@CrossOrigin
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Dados> optional = repository.findById(id);
		if (optional.isPresent()) {
			repository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}

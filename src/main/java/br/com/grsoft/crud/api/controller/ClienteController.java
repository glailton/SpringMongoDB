package br.com.grsoft.crud.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.grsoft.crud.api.document.Cliente;
import br.com.grsoft.crud.api.services.ClienteService;
import br.com.grsoft.crud.api.utils.Response;

@Controller
@RequestMapping(path = "/api/clientes")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public ResponseEntity<Response<List<Cliente>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<Cliente>>(clienteService.listarTodos()));
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Cliente>> listarPorId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(new Response<Cliente>(clienteService.listarPorId(id)));
	}

	@PostMapping
	public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Cliente>(errors));
		}

		return ResponseEntity.ok(new Response<Cliente>(clienteService.cadastrar(cliente)));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Cliente>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Cliente cliente,
			BindingResult result) {
		if (result.hasErrors()) {
			List<String> errors = new ArrayList<>();
			result.getAllErrors().forEach(error -> errors.add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Cliente>(errors));
		}
		
		cliente.setId(id);
		return ResponseEntity.ok(new Response<Cliente>(clienteService.atualizar(cliente)));
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		clienteService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}

}

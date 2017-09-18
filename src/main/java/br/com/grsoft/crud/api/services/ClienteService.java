package br.com.grsoft.crud.api.services;

import java.util.List;

import br.com.grsoft.crud.api.document.Cliente;

public interface ClienteService {
	List<Cliente> listarTodos();
	
	Cliente listarPorId(String id);
	
	Cliente cadastrar(Cliente cliente);
	
	Cliente atualizar(Cliente cliente);
	
	void remover(String id);
}

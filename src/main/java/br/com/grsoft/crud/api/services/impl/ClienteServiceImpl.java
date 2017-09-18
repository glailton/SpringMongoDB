package br.com.grsoft.crud.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grsoft.crud.api.document.Cliente;
import br.com.grsoft.crud.api.repositories.ClienteReposytory;
import br.com.grsoft.crud.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteReposytory clientRepository;

	@Override
	public List<Cliente> listarTodos() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Cliente listarPorId(String id) {
		// TODO Auto-generated method stub
		return clientRepository.findOne(id);
	}

	@Override
	public Cliente cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub
		return clientRepository.save(cliente);
	}

	@Override
	public Cliente atualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		return clientRepository.save(cliente);
	}

	@Override
	public void remover(String id) {
		// TODO Auto-generated method stub
		clientRepository.delete(id);

	}

}

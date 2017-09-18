package br.com.grsoft.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.grsoft.crud.api.document.Cliente;

public interface ClienteReposytory extends MongoRepository<Cliente, String> {

}

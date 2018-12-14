package com.lopes.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.lopes.crud.api.documents.Usuario;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}

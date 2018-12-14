package com.lopes.crud.api.service;

import java.util.List;
import java.util.Optional;

import com.lopes.crud.api.documents.Usuario;

public interface UsuarioService {
	
	List<Usuario> listAll();
	
	Optional<Usuario> listForId(String id);
	
	Usuario register(Usuario usuario);
	
	Usuario upgrade(Usuario usuario);
	
	void delete(String id);

}

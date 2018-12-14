package com.lopes.crud.api.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopes.crud.api.documents.Usuario;
import com.lopes.crud.api.repositories.UsuarioRepository;
import com.lopes.crud.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<Usuario> listAll() {
		return this.usuarioRepository.findAll();
	}

	@Override
	public Optional<Usuario> listForId(String id) {
		return this.usuarioRepository.findById(id);
	}

	@Override
	public Usuario register(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public Usuario upgrade(Usuario usuario) {
		return this.usuarioRepository.save(usuario);
	}

	@Override
	public void delete(String id) {
		this.usuarioRepository.deleteById(id);
		 
		
	}
	
	
}

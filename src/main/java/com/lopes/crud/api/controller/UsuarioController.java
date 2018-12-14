package com.lopes.crud.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lopes.crud.api.documents.Usuario;
import com.lopes.crud.api.responses.Response;
import com.lopes.crud.api.service.UsuarioService;

@RestController
@RequestMapping(path = "/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listAll() {
		return ResponseEntity.ok(this.usuarioService.listAll());
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Optional<Usuario>> lisForId(@PathVariable(name = "id") String id) {
		return ResponseEntity.ok(this.usuarioService.listForId(id));
	}

	@PostMapping
	public ResponseEntity<Response<Usuario>> register(@Valid @RequestBody Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Usuario>(erros));
		}
		return ResponseEntity.ok(new Response<Usuario>(this.usuarioService.register(usuario)));
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Usuario>> upgrade(@PathVariable (name = "id") String id, @Valid @RequestBody Usuario usuario, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erro.getDefaultMessage());
			return ResponseEntity.badRequest().body(new Response<Usuario>(erros));
		}

		return ResponseEntity.ok(new Response<Usuario>(this.usuarioService.upgrade(usuario)));

	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Integer> delete(@PathVariable(name = "id") String id) {
		this.usuarioService.delete(id);
		return ResponseEntity.ok(1);
	}
}

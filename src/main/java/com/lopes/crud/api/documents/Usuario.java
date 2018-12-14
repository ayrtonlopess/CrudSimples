package com.lopes.crud.api.documents;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Usuario {
	
	@Id
	private String id;
	private String nome;
	private String email;
	private String cpf;
	
	
	public Usuario(){
		
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	@NotEmpty(message = "nao pode ser vazio")
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}

	@NotEmpty(message = "nao pode ser vazio")
	@Email(message = "email invalido")
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "nao pode estar vazio")
	@CPF(message = "cpf invalido")
	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}

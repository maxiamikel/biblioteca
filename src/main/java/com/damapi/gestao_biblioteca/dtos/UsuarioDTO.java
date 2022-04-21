package com.damapi.gestao_biblioteca.dtos;

import java.io.Serializable;

import com.damapi.gestao_biblioteca.entities.Usuario;

public class UsuarioDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String email;
	private String sexo;
	private String celular;
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.sexo = usuario.getSexo();
		this.celular = usuario.getCelular();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	
}

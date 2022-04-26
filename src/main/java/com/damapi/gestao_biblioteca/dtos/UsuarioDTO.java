package com.damapi.gestao_biblioteca.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.damapi.gestao_biblioteca.entities.Usuario;

public class UsuarioDTO implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "Preenche o nome")
	@Length(min = 3, max = 50)
	private String nome;
	@NotEmpty(message = "O CPF é obrigatorio")
	@Length(min = 11, max = 14)
	private String cpf;
	@NotEmpty(message = "Preenche o EMAIL")
	@Length(min = 10, max =100 )
	private String email;
	@NotEmpty(message = "O sex não pode ser vázio")
	@Length(min = 1, max =9 )
	private String sexo;
	@NotEmpty(message = "O celular é obrigatorio")
	@Length(min = 9, max =16 )
	private String celular;
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(Usuario usuario) {
		super();
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.cpf = usuario.getCpf();
		this.email = usuario.getEmail();
		this.sexo = usuario.getSexo();
		this.celular = usuario.getCelular();
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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

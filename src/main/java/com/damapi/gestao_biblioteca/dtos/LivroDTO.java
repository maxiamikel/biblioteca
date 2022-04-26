package com.damapi.gestao_biblioteca.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.damapi.gestao_biblioteca.entities.Livro;

public class LivroDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	@NotEmpty(message = "O preenchimento do titulo do livro é obrigatorio.")
	@Length(min = 8, max = 1000)
	private String titulo;
	@NotEmpty(message = "Não é permitido criar um livro sem o nome do autor.")
	@Length(min = 5, max = 100)
	private String autor;
	@NotEmpty(message = "Preenche o idioma do livro")
	@Length(min = 3, max = 50)
	private String idioma;
	
	public LivroDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LivroDTO(Livro livro) {
		super();
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = livro.getAutor();
		this.idioma = livro.getIdioma();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	
}

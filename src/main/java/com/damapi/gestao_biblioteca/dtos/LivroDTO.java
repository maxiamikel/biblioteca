package com.damapi.gestao_biblioteca.dtos;

import java.io.Serializable;

import com.damapi.gestao_biblioteca.entities.Livro;

public class LivroDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String titulo;
	private String autor;
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

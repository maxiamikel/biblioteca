package com.damapi.gestao_biblioteca.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Livro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Emprestimo emprestimo;

	public Livro() {
		super();
	}

	public Livro(Long id, String titulo, String autor, String idioma, Categoria categoria) {
		//super();
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.idioma = idioma;
		this.categoria = categoria;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		return Objects.equals(id, other.id);
	}
	
	

}

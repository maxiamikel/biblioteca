package com.damapi.gestao_biblioteca.dtos;

import com.damapi.gestao_biblioteca.entities.Categoria;

public class CategoriaDTO {

	private Long id;
	private String nome;
	private String descricao;
	
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoriaDTO(Categoria obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
	}
	
	
}

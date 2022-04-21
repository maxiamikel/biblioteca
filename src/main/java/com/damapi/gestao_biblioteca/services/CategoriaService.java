package com.damapi.gestao_biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damapi.gestao_biblioteca.entities.Categoria;
import com.damapi.gestao_biblioteca.repositories.CategoriaRepository;
import com.damapi.gestao_biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
	public Categoria obterCategoriaPorId(Long id) {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado, ID: "+id+ ", TIPO: "+ Categoria.class.getName()));
	}
	
	public List<Categoria> obterCategorias() {
		return repo.findAll();
	}
	
	public Categoria criarCategoria(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria updateCategoria(Long id, Categoria categoria) {
		Categoria obj = obterCategoriaPorId(id);
		obj.setDescricao(categoria.getDescricao());
		obj.setNome(categoria.getNome());
		return repo.save(obj);
		
	}
	
	public void deleteUmaCategoria(Long id) {
		this.obterCategoriaPorId(id);
		repo.deleteById(id);
	}
}

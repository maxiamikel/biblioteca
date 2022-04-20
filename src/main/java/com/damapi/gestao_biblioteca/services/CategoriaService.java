package com.damapi.gestao_biblioteca.services;

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
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontredo: "+id+ ", Tipo: "+ Categoria.class.getName()));
	}
}

package com.damapi.gestao_biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.damapi.gestao_biblioteca.entities.Livro;
import com.damapi.gestao_biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repo;
	
	public Livro obterLivroPorId(Long id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Livro> obterTodosOsLivros(){
		List<Livro> livros = repo.findAll();
		return livros;
	}
	
	public Livro salvarUmLivro(Livro livro) {
		livro.setId(null);
		return repo.save(livro);
	}
	
	public void  apagarUmLivro(Long id) {
		this.obterLivroPorId(id);
		repo.deleteById(id);
	}
	
	public Livro atualizarLivro( long id, Livro livro) {
		Livro obj = obterLivroPorId(id);
		obj.setAutor(livro.getAutor());
		obj.setCategoria(livro.getCategoria());
		obj.setIdioma(livro.getIdioma());
		obj.setTitulo(livro.getTitulo());
		return repo.save(obj);
	}
	
	

}

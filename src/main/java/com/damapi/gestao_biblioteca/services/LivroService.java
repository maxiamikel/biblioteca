package com.damapi.gestao_biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damapi.gestao_biblioteca.entities.Livro;
import com.damapi.gestao_biblioteca.repositories.LivroRepository;
import com.damapi.gestao_biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository repo;
	
	public Livro obterLivroPorId(Long id) {
		Optional<Livro> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Não encontramos esse Livro ID: "+id+" TIPO: " + Livro.class.getSimpleName()));
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

package com.damapi.gestao_biblioteca.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.damapi.gestao_biblioteca.dtos.LivroDTO;
import com.damapi.gestao_biblioteca.entities.Livro;
import com.damapi.gestao_biblioteca.services.LivroService;

@RestController
@RequestMapping(value = "/api/livros")
public class LivroController {
	
	@Autowired
	private LivroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> getLivroPorId(@PathVariable Long id){
		Livro livro = service.obterLivroPorId(id);
		return ResponseEntity.ok().body(livro);
	}
	
	@GetMapping
	public ResponseEntity<List<LivroDTO>> getTodosOsLivros(){
		List<Livro> lista = service.obterTodosOsLivros();
		List<LivroDTO> listaDTO = lista.stream().map(mapa -> new LivroDTO(mapa)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<Livro> postLovro(@Valid @RequestBody Livro livro){
		Livro obj = service.salvarUmLivro(livro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(livro.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> updateLivro(@Valid @PathVariable Long id, @RequestBody Livro livro){
		Livro newLivro = service.atualizarLivro(id, livro);
		return ResponseEntity.ok().body(newLivro);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteLivro(@PathVariable Long id){
		service.apagarUmLivro(id);
		return ResponseEntity.noContent().build();
	}

}

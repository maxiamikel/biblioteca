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

import com.damapi.gestao_biblioteca.dtos.CategoriaDTO;
import com.damapi.gestao_biblioteca.entities.Categoria;
import com.damapi.gestao_biblioteca.services.CategoriaService;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> getCategoriaPorId(@PathVariable Long id) {
		Categoria obj = service.obterCategoriaPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	ResponseEntity<List<CategoriaDTO>> getTodasAsCategoria() {
		List<Categoria> lista = service.obterCategorias();
		List<CategoriaDTO> listaDTO = lista.stream().map(mapa -> new CategoriaDTO(mapa)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping()
	public ResponseEntity<Categoria> postCategoria(@Valid @RequestBody Categoria categoria){
		categoria = service.criarCategoria(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria){
		Categoria newObj = service.updateCategoria(id, categoria);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategoria(@PathVariable Long id){
		service.deleteUmaCategoria(id);
		return ResponseEntity.noContent().build();
	}
}

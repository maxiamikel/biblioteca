package com.damapi.gestao_biblioteca.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.damapi.gestao_biblioteca.entities.Categoria;
import com.damapi.gestao_biblioteca.services.CategoriaService;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> getCategoriaPorId(@PathVariable Long id){
		Categoria obj = service.obterCategoriaPorId(id);
		return ResponseEntity.ok().body(obj);
	}
}

package com.damapi.gestao_biblioteca.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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

import com.damapi.gestao_biblioteca.dtos.EmprestimoDTO;
import com.damapi.gestao_biblioteca.entities.Emprestimo;
import com.damapi.gestao_biblioteca.services.EmprestimoService;

@RestController
@RequestMapping(value = "/api/emprestimos")
public class EmprestimoController {
	
	@Autowired
	private EmprestimoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Emprestimo> getEmprestimoPorId(@PathVariable Long id) {
		Emprestimo obj = service.obterEmprestimoPorId(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	ResponseEntity<List<EmprestimoDTO>> getTodasAsEmprestimo() {
		List<Emprestimo> lista = service.obterTodosOsEmprestimos();
		List<EmprestimoDTO> listaDTO = lista.stream().map(mapa -> new EmprestimoDTO(mapa)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping()
	public ResponseEntity<Emprestimo> postEmprestimo(@RequestBody Emprestimo Emprestimo){
		Emprestimo = service.salvarUmEmprestimo(Emprestimo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(Emprestimo.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Emprestimo> updateEmprestimo(@PathVariable Long id, @RequestBody Emprestimo Emprestimo){
		Emprestimo newObj = service.atualizarEmprestimo(id, Emprestimo);
		return ResponseEntity.ok().body(newObj);
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteEmprestimo(@PathVariable Long id){
		service.apagarUmEmprestimo(id);
		return ResponseEntity.noContent().build();
	}

}

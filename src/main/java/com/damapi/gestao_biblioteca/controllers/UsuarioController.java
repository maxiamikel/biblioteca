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

import com.damapi.gestao_biblioteca.dtos.UsuarioDTO;
import com.damapi.gestao_biblioteca.entities.Usuario;
import com.damapi.gestao_biblioteca.services.UsuarioService;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable Long id){
		Usuario Usuario = service.obterUsuarioPorId(id);
		return ResponseEntity.ok().body(Usuario);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> getTodosOsUsuarios(){
		List<Usuario> lista = service.obterTodosOsUsuarios();
		List<UsuarioDTO> listaDTO = lista.stream().map(mapa -> new UsuarioDTO(mapa)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> postUsuario(@Valid @RequestBody Usuario Usuario){
		Usuario obj = service.salvarUmUsuario(Usuario);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(Usuario.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Usuario> updateUsuario(@Valid @PathVariable Long id, @RequestBody Usuario Usuario){
		Usuario newUsuario = service.atualizarUsuario(id, Usuario);
		return ResponseEntity.ok().body(newUsuario);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteUsuario(@PathVariable Long id){
		service.apagarUmUsuario(id);
		return ResponseEntity.noContent().build();
	}

}

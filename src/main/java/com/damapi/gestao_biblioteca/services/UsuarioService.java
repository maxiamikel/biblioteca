package com.damapi.gestao_biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damapi.gestao_biblioteca.entities.Livro;
import com.damapi.gestao_biblioteca.entities.Usuario;
import com.damapi.gestao_biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired 
	UsuarioRepository repo;
	
	public Usuario obterUsuarioPorId(Long id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public List<Usuario> obterTodosOsUsuarios(){
		List<Usuario> usuarios = repo.findAll();
		return usuarios;
	}
	
	public Usuario salvarUmUsuario(Usuario usuario) {
		usuario.setId(null);
		return repo.save(usuario);
	}
	
	public void  apagarUmUsuario(Long id) {
		this.obterUsuarioPorId(id);
		repo.deleteById(id);
	}
	
	public Usuario atualizarUsuario( long id, Usuario usuario) {
		Usuario obj = obterUsuarioPorId(id);
		obj.setCelular(usuario.getCelular());
		obj.setEmail(usuario.getEmail());
		obj.setNome(usuario.getNome());
		obj.setSexo(usuario.getSexo());
		return repo.save(obj);
	}
	
}

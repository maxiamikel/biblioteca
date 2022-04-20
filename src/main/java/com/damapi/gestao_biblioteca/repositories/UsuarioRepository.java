package com.damapi.gestao_biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damapi.gestao_biblioteca.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}

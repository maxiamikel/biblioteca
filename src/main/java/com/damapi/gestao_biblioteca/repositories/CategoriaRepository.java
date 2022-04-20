package com.damapi.gestao_biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damapi.gestao_biblioteca.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}

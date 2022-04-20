package com.damapi.gestao_biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damapi.gestao_biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}

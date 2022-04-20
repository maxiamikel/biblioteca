package com.damapi.gestao_biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.damapi.gestao_biblioteca.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}

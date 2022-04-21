package com.damapi.gestao_biblioteca.dtos;

import java.time.LocalDate;

import com.damapi.gestao_biblioteca.entities.Emprestimo;

public class EmprestimoDTO {

	private Long id;
	private String status;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	
	public EmprestimoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmprestimoDTO(Emprestimo emprestimo) {
		super();
		this.id = emprestimo.getId();
		this.status = emprestimo.getStatus();
		this.dataEmprestimo = emprestimo.getDataEmprestimo();
		this.dataDevolucao = emprestimo.getDataDevolucao();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(LocalDate dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	
	
}

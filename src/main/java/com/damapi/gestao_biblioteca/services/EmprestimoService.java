package com.damapi.gestao_biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.damapi.gestao_biblioteca.entities.Emprestimo;
import com.damapi.gestao_biblioteca.repositories.EmprestimoRepository;
import com.damapi.gestao_biblioteca.services.exceptions.ObjectNotFoundException;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository repo;

	public Emprestimo obterEmprestimoPorId(Long id) {
		Optional<Emprestimo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Não podemos encontrar o tipo: " + Emprestimo.class.getSimpleName() + " com o ID: " + id));
	}

	public List<Emprestimo> obterTodosOsEmprestimos() {
		List<Emprestimo> Emprestimos = repo.findAll();
		return Emprestimos;
	}

	public Emprestimo salvarUmEmprestimo(Emprestimo Emprestimo) {
		Emprestimo.setId(null);
		return repo.save(Emprestimo);
	}

	public void apagarUmEmprestimo(Long id) {
		this.obterEmprestimoPorId(id);
		repo.deleteById(id);
	}

	public Emprestimo atualizarEmprestimo(long id, Emprestimo emprestimo) {
		Emprestimo obj = obterEmprestimoPorId(id);
		obj.setDataDevolucao(emprestimo.getDataDevolucao());
		obj.setLivrosPrestados(emprestimo.getLivrosPrestados());
		obj.setId(emprestimo.getId());
		obj.setLivrosPrestados(emprestimo.getLivrosPrestados());
		obj.setStatus(emprestimo.getStatus());
		obj.setUsuario(emprestimo.getUsuario());
		return repo.save(obj);
	}

}

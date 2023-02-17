package br.edu.unoesc.alunos_H2.RestController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unoesc.alunos_H2.model.Aluno;

@RestController
public class AlunoRestController {

	List<Aluno> alunos;

	public AlunoRestController() {
		alunos = new ArrayList<Aluno>();
	}

	@RequestMapping(value = "/api")

// Incluir 
	@PostMapping("/alunos")
	public Aluno salvarAluno(@RequestBody Aluno aluno) {
		alunos.add(aluno);
		System.out.println("Inserindo aluno...");
		System.out.println(aluno);
		return aluno;
	}

	@PutMapping("/alunos")
	public Aluno atualizarAluno(@RequestBody Aluno aluno) {
		Aluno a = findById(aluno.getId());
		a.setNome(aluno.getNome());
		a.setSalario(aluno.getSalario());
		a.setNascimento(aluno.getNascimento());
		System.out.println("Atualizando produto...");
		System.out.println(a);
		return a;
	}

	@DeleteMapping(value = "/alunos/{id}")
	public void deletarAluno(@PathVariable Long id) {
		Aluno a = findById(id);
		alunos.remove(a);
		System.out.println("Excluindo aluno [" + id + "]...");
	}

	@GetMapping(value = "/alunos/{id}")
	public Aluno findById(@PathVariable Long id) {
		for (Aluno aluno : alunos) {
			if (alunos.equals(id)) {
				return aluno;
			}
		}
		return null;
	}

}

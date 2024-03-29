package main.java.arquiteturaweb.ac1.aula3.controller;

import main.java.arquiteturaweb.ac1.aula3.model.Aluno;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    public AlunoController(){
        alunos.add(new Aluno(nextId++, "Lucas da Silva", "159898988", 10, "Belas Artes", "lucassilva@email.com"));
    }
    
    @PostMapping
    public Aluno criarAluno(@RequestBody Aluno aluno) {
        aluno.setId((long) (alunos.size() + 1));//
        alunos.add(aluno);
        return aluno;
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return alunos;
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @PostMapping("/add")
    public Aluno addAluno(@RequestBody Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + aluno); 
        return aluno; 
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        alunos.removeIf(aluno -> aluno.getId().equals(id));
    }

    @PutMapping("/{id}")
    public Aluno atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno alunoExistente = getAlunoById(id);
        if (alunoExistente != null) {
            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setCelular(alunoAtualizado.getCelular());
            alunoExistente.setIdade(alunoAtualizado.getIdade());
            alunoExistente.setCurso(alunoAtualizado.getCurso());
            alunoExistente.setEmail(alunoAtualizado.getEmail());
        }
        return alunoExistente;
    }
}
//Mantendo a alteracao da etapa 3 Q faz funcionar
package arquiteturaweb.ac1.aula3.controller;

import main.java.arquiteturaweb.ac1.aula3.model.Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController

//Tem alterações a ser feita no controler
//Usar os Services

// A array q simula o BD vai passar a ser feita em um service

//fazer repository primeiro
// services segundo
// terceiro atualizar controller

@RequestMapping("/alunos")
public class AlunoController {

    private List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L;

    public AlunoController(){
        alunos.add(new Aluno(nextId++, "Lucas da Silva", "159898988", 10, "Belas Artes", "lucassilva@email.com"));
    }

    @PostMapping("/add")
    public Aluno addAluno(@RequestBody Aluno aluno) {
        aluno.setId((long) (alunos.size() + 1));
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + aluno); 
        return aluno; 
    }

    @GetMapping
    public List<Aluno> getAllAlunos() {
        return alunos;
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(@PathVariable Long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable Long id) {
        System.out.println("Removendo Aluno "); 
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
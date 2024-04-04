//Mantendo a alteracao da etapa 3 Q faz funcionar
package main.java.arquiteturaweb.ac1.aula3.controller;

import main.java.arquiteturaweb.ac1.aula3.model.Aluno;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import arquiteturaweb.ac1.aula3.services.AlunoService;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController

//tenho que refazer o delete pra nao ser void.
//Ta rodando mas o postman n acha

@RequestMapping("/alunos")
public class AlunoController {
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // o pre cadastro e os métodos agora estao no repository
    @GetMapping 
    public List<Aluno> getAllAlunos() {
        return alunoService.getAllAlunos();
    }

    @GetMapping("/{id}")
    public Aluno getAlunoById(Long id) {
        return alunoService.getAlunoById(id);
    }

    @PostMapping("/add")
    public Aluno addAluno(Aluno aluno) {
        return alunoService.addAluno(aluno);
    }

    @PutMapping("/{id}")
    public Aluno editAluno(Long id,  Aluno alunoAtualizado) {
        return alunoService.editAluno(id,alunoAtualizado);
    }

    //@DeleteMapping("/{id}")
    //public void deleteAluno(@PathVariable Long id) {
    //    return alunoService.deleteAluno(id);
    //}
}
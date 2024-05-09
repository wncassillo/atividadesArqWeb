package br.wncassillo.arquitetura.alunos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.wncassillo.arquitetura.alunos.model.Aluno;
import br.wncassillo.arquitetura.alunos.service.AlunoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/all")
    public List<Aluno> getAlunos(){
        return alunoService.getAlunos();
    }

    @GetMapping("/{id}") //500
    public Optional<Aluno> getAluno(@PathVariable Long id){
        return alunoService.getAlunoPorId(id);
    }

    @PostMapping("/add") 
    public void addAluno(@RequestBody Aluno aluno){
        alunoService.addAluno(aluno);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteAluno(@PathVariable Long id){
        alunoService.deleteAluno(id);
    }

    //metodos novos
    @GetMapping("/getAlunoByNome/{nome}") // aluno com nome igual 
    public Aluno getAlunosPorNome(@PathVariable String nome){
        return alunoService.getAlunoByNome(nome);
    }

    @GetMapping("/getAlunosByParteNome/{nome}") // alunos por nome contendo 
    public List<Aluno> getAlunosPorParteNome(@PathVariable String nome){
        return alunoService.getAlunosByParteNome(nome);
    }

    @GetMapping("/getAlunoByCelular/{numero}") // aluno por n de celular
    public Aluno getAlunoByCelular(@PathVariable String numero){
        return alunoService.getAlunoByCelular(numero);
    }

    @GetMapping("/getAlunosByIdade/{idade}") // alunos por idade 
    public List<Aluno> getAlunosPorIdade(@PathVariable int idade){
        return alunoService.getAlunosByIdade(idade);
    }

    @GetMapping("/getAlunosByCurso/{curso}") // alunos por curso ou contendo
    public List<Aluno> getAlunosPorCurso(@PathVariable String curso){
        return alunoService.getAlunosByCurso(curso);
    }

    @GetMapping("/getAlunoByEmail/{email}") // aluno por email 
    public Aluno getAlunoPorEmail(@PathVariable String email){
        return alunoService.getAlunoByEmail(email);
    }

    @GetMapping("/getAlunosByParteEmail/{email}") // alunos por email contendo
    public List<Aluno> getAlunosPorParteEmail(@PathVariable String email){
        return alunoService.getAlunosByParteEmail(email);
    }

}
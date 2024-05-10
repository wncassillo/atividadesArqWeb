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

//To Do
//Validação nos Controllers
    //BindingResults
    //Não precisa fazer Exceptions
//Readme
    //Nome dos integrandes
    //print das req nos end points
    //print das classes
    //prints validação

@RestController
@RequestMapping("/aluno")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @GetMapping("/all")
    public List<Aluno> getAlunos(){
        return alunoService.getAlunos();
    }

    @GetMapping("/{id}") 
    public Optional<Aluno> getAluno(@PathVariable Long id){
        return alunoService.getAlunoPorId(id);
    }

    @PostMapping("/add") //Além de adicionar, esse método também atualiza a instancia do objeto, se a requisição conter um id á existente
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

    @GetMapping("/getAlunosByCursoId/{cursoId}") // alunos por curso ou contendo
    public List<Aluno> getAlunosPorCurso(@PathVariable Long curso){
        return alunoService.getAlunosByCursoId(curso);
    }

    @GetMapping("/getAlunoByEmail/{email}") // aluno por email 
    public Aluno getAlunoPorEmail(@PathVariable String email){
        return alunoService.getAlunoByEmail(email);
    }

    @GetMapping("/getAlunosByParteEmail/{email}") // alunos por email contendo
    public List<Aluno> getAlunosPorParteEmail(@PathVariable String email){
        return alunoService.getAlunosByParteEmail(email);
    }

    //metodos da parte 8

    @GetMapping("/getAlunosByCursoTitulo/{curso}") // alunos por curso ou contendo
    public List<Aluno> getAlunosPorCursoTitulo(@PathVariable String curso){
        return alunoService.getAlunosByCursoTitulo(curso);
    }

    @GetMapping("/countByCursoId/{cursoId}")
    public Long countAlunosByCursoId(@PathVariable Long cursoId) {
        return alunoService.countAlunosByCursoId(cursoId);
    }

    @GetMapping("/countByCursoTitulo/{cursoTitulo}")
    public Long countAlunosByCursoTitulo(@PathVariable String cursoTitulo) {
        return alunoService.countAlunosByCursoTitulo(cursoTitulo);
    }

}
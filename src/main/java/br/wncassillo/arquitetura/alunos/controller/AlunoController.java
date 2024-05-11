package br.wncassillo.arquitetura.alunos.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.wncassillo.arquitetura.alunos.exceptions.AlunoNaoEncontradoException;
import br.wncassillo.arquitetura.alunos.model.Aluno;
import br.wncassillo.arquitetura.alunos.service.AlunoService;
import jakarta.validation.Valid;
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

    @GetMapping("/{id}") 
    public Optional<Aluno> getAluno(@PathVariable Long id){
        return alunoService.getAlunoPorId(id);
    }

    @PostMapping("/add") //Além de adicionar, esse método também atualiza a instancia do objeto, se a requisição conter um id á existente
    public ResponseEntity<?> addAluno(@Valid @RequestBody Aluno aluno, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
            //cenário em que tem erros, então não é criado um novo aluno
        }
        Aluno createdAluno = alunoService.addAluno(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAluno);
        //Sem erros, o aluno do requestbody é passado adiante para o service.
        //e o metodo recebe o status de resposta de sucesso
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<String> editAluno(@Valid @PathVariable Long id, @RequestBody Aluno aluno, BindingResult result) {
        try{
            alunoService.editAluno(id, aluno);
            return ResponseEntity.ok("Aluno editado com sucesso.");
        } catch (AlunoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteAluno(@PathVariable Long id){
        try{
            alunoService.deleteAluno(id);
            return ResponseEntity.ok("Aluno apagado com sucesso!");
        } catch (AlunoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

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

    @GetMapping("/getAlunosByCursoId/{curso}") 
    public List<Aluno> getAlunosPorCursoId(@PathVariable Long curso){
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
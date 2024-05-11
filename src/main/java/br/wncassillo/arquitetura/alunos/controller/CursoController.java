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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.wncassillo.arquitetura.alunos.exceptions.CursoNaoEncontradoException;
import br.wncassillo.arquitetura.alunos.model.Curso;
import br.wncassillo.arquitetura.alunos.service.CursoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/curso")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @GetMapping("/all")
    public List<Curso> getCursos(){
        return cursoService.getCursos();
    }

    @GetMapping("/{id}") 
    public Optional<Curso> getCurso(@PathVariable Long id){
        return cursoService.getCursoPorId(id);
    }

    @PostMapping("/add") 
    public ResponseEntity<?> addCurso(@Valid @RequestBody Curso curso, BindingResult result){
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }
        Curso createdCurso = cursoService.addCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCurso);
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<String> deleteCurso(@PathVariable Long id){
        try{
            cursoService.deleteCurso(id);
            return ResponseEntity.ok("Curso apagado com sucesso!");
        } catch (CursoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
}

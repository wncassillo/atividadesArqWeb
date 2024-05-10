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

import br.wncassillo.arquitetura.alunos.model.Curso;
import br.wncassillo.arquitetura.alunos.service.CursoService;
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
    public void addCurso(@RequestBody Curso curso){
        cursoService.addCurso(curso);
    }

    @DeleteMapping("/remove/{id}")
    public void deleteCurso(@PathVariable Long id){
        cursoService.deleteCurso(id);
    }
    
}

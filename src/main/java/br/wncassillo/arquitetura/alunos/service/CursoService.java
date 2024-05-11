package br.wncassillo.arquitetura.alunos.service;

import java.util.List;
import java.util.Optional;

import br.wncassillo.arquitetura.alunos.model.Curso;

public interface CursoService {
    public List<Curso> getCursos();
    public Optional<Curso> getCursoPorId(Long id);
    public Curso addCurso (Curso curso);
    public void deleteCurso(Long id);

}

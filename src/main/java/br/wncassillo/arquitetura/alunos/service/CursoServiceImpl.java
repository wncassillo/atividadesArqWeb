package br.wncassillo.arquitetura.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.wncassillo.arquitetura.alunos.model.Curso;
import br.wncassillo.arquitetura.alunos.repository.CursoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CursoServiceImpl implements CursoService {
    private final CursoRepository cursoRepository;

    @Override
    public List<Curso> getCursos() {
        return cursoRepository.findAll();
    }

    @Override
    public Optional<Curso> getCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }

    @Override
    public void addCurso(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        cursoRepository.deleteById(id);
    }

}

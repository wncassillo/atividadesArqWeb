package br.wncassillo.arquitetura.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.wncassillo.arquitetura.alunos.exceptions.CursoNaoEncontradoException;
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
    public Curso addCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Override
    public void deleteCurso(Long id) {
        Optional <Curso> curso = getCursoPorId(id);
        if (curso.isPresent()){
            cursoRepository.deleteById(id);
        } else {
            throw new CursoNaoEncontradoException("Não foi encontrado nenhum Curso com o ID: " + id);
        }
    }

}

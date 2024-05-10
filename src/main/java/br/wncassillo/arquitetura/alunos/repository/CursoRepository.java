package br.wncassillo.arquitetura.alunos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.wncassillo.arquitetura.alunos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
     public Optional<Curso> findById(Long id);
}

package br.wncassillo.arquitetura.alunos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.wncassillo.arquitetura.alunos.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    public Optional<Aluno> findById(Long id);//?

    public Aluno findByNome(String nome); // Retorna 1 Aluno com o nome igual args

    public List<Aluno> findByNomeContaining(String nome); // retrona lista de alunos com nome contendo args

    public Aluno findByCelular(String celular);

    public List<Aluno> findByIdade(int idade);

    public List<Aluno> findByCursoId(Long cursoId);// Retorna lista de alunos, com o curso com o id correspondente

    public Aluno findByEmail(String email);

    public List<Aluno> findByEmailContaining(String email);

    public List<Aluno> findByCursoTitulo(String curso);

    @Query("SELECT COUNT(a) FROM Aluno a WHERE a.curso.id = :cursoId")
    Long countAlunosPorCursoId(@Param("cursoId") Long cursoId);

    @Query("SELECT COUNT(a) FROM Aluno a WHERE a.curso.titulo = :cursoTitulo")
    Long countAlunosPorCursoTitulo(@Param("cursoTitulo") String cursoTitulo);/////
}
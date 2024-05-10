package br.wncassillo.arquitetura.alunos.service;

import java.util.List;
import java.util.Optional;

import br.wncassillo.arquitetura.alunos.model.Aluno;

public interface AlunoService {
    public List<Aluno> getAlunos();
    public Optional<Aluno> getAlunoPorId(Long id);
    public void addAluno(Aluno aluno);
    public void deleteAluno(Long id);
    //metodos novos pra fechar os requisitos da aula5
    public Aluno getAlunoByNome(String nome);
    public List<Aluno> getAlunosByParteNome(String nome);
    public Aluno getAlunoByCelular(String celular);
    public List<Aluno> getAlunosByIdade(int idade);
    public List<Aluno> getAlunosByCursoId(Long curso);
    public Aluno getAlunoByEmail(String email);
    public List<Aluno> getAlunosByParteEmail(String email);
    public List<Aluno> getAlunosByCursoTitulo(String curso);
    public Long countAlunosByCursoId(Long curso);
    public Long countAlunosByCursoTitulo(String curso);
}

package br.wncassillo.arquitetura.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.wncassillo.arquitetura.alunos.model.Aluno;
import br.wncassillo.arquitetura.alunos.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService{
    private final AlunoRepository alunoRepository;

    @Override
    public List<Aluno> getAlunos() {
        return alunoRepository.findAll();
    }
    @Override
    public Optional<Aluno> getAlunoPorId(Long id) { 
        return alunoRepository.findById(id);
        //return alunoRepository.getReferenceById(id);
    }
    @Override
    public void addAluno(Aluno aluno) {
        alunoRepository.save(aluno);
    }
    @Override
    public void deleteAluno(Long id) {
        alunoRepository.deleteById(id);
    }

    //metodos novos 
    @Override
    public Aluno getAlunoByNome(String nome) {
        return alunoRepository.findByNome(nome);
    }
    @Override
    public List<Aluno> getAlunosByParteNome(String nome) {
        return alunoRepository.findByNomeContaining(nome);
    }
    @Override
    public Aluno getAlunoByCelular(String celular){
        return alunoRepository.findByCelular(celular);
    }
    @Override
    public List<Aluno> getAlunosByIdade(int idade){
        return alunoRepository.findByIdade(idade);
    }
    @Override
    public List<Aluno> getAlunosByCursoId(Long curso){
        return alunoRepository.findByCursoId(curso);
    }
    @Override
    public Aluno getAlunoByEmail(String email){
        return alunoRepository.findByEmail(email);
    }
    @Override
    public List<Aluno> getAlunosByParteEmail(String email){
        return alunoRepository.findByEmailContaining(email);
    }
    @Override
    public List<Aluno> getAlunosByCursoTitulo(String curso) {
        return alunoRepository.findByCursoTitulo(curso);
    }
    @Override
    public Long countAlunosByCursoId(Long id) {
        return alunoRepository.countAlunosPorCursoId(id);
    }
    @Override
    public Long countAlunosByCursoTitulo(String curso) {
        return alunoRepository.countAlunosPorCursoTitulo(curso);
    }

}

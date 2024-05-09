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
    public Optional<Aluno> getAlunoPorId(Long id) { //500???
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
    public List<Aluno> getAlunosByParteNome(String nome) {
        return alunoRepository.findByNomeContaining(nome);
    }
    public Aluno getAlunoByCelular(String celular){
        return alunoRepository.findByCelular(celular);
    }
    public List<Aluno> getAlunosByIdade(int idade){
        return alunoRepository.findByIdade(idade);
    }
    public List<Aluno> getAlunosByCurso(String curso){
        return alunoRepository.findByCursoContaining(curso);
    }
    public Aluno getAlunoByEmail(String email){
        return alunoRepository.findByEmail(email);
    }
    public List<Aluno> getAlunosByParteEmail(String email){
        return alunoRepository.findByEmailContaining(email);
    }

}

package arquiteturaweb.ac1.aula3.services;

import main.java.arquiteturaweb.ac1.aula3.model.Aluno;
import arquiteturaweb.ac1.aula3.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService{
    private final AlunoRepository alunoRepository;

    public AlunoServiceImpl(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    @Override
    public List<Aluno> getAllAlunos(){
        return alunoRepository.getAllAlunos();
    }

    @Override
    public Aluno getAlunoById(Long id){
        return alunoRepository.getAlunoById(id);
    }

    @Override
    public Aluno addAluno(Aluno aluno){
        return alunoRepository.addAluno(aluno);
    }

    @Override
    public Aluno editAluno(Long id, Aluno aluno){
        return alunoRepository.editAluno(id, aluno);
    }

   // @Override
    //public void deleteAluno(long id){
    //    return alunoRepository.deleteAluno(id);
    //}


}

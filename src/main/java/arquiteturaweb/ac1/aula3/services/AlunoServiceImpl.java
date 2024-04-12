package arquiteturaweb.ac1.aula3.services;

import arquiteturaweb.ac1.aula3.model.Aluno;
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
    public Aluno editAluno(Aluno aluno){
        return alunoRepository.editAluno(aluno);//
    }

    @Override
    public String deleteAluno(long id){
        return alunoRepository.deleteAluno(id);
    }


}   

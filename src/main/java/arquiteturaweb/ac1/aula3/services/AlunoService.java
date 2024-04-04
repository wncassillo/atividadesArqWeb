package arquiteturaweb.ac1.aula3.services;

import main.java.arquiteturaweb.ac1.aula3.model.Aluno;
import java.util.List;

public interface AlunoService {
    List<Aluno> getAllAlunos(); 
    Aluno getAlunoById(Long id);
    Aluno addAluno(Aluno aluno);
    Aluno editAluno(Long id, Aluno aluno);
    //void deleteAluno(long id);
}

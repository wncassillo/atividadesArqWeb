package arquiteturaweb.ac1.aula3.services;

import arquiteturaweb.ac1.aula3.model.Aluno;
import java.util.List;

public interface AlunoService {
    List<Aluno> getAllAlunos(); 
    Aluno getAlunoById(Long id);
    Aluno addAluno(Aluno aluno);
    Aluno editAluno(Aluno aluno);
    String deleteAluno(long id);
}

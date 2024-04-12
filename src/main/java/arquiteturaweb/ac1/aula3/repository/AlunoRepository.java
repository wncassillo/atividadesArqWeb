package arquiteturaweb.ac1.aula3.repository;

import arquiteturaweb.ac1.aula3.model.Aluno;
import org.springframework.stereotype.Repository;
import java.util.List;

public interface AlunoRepository {
    List<Aluno> getAllAlunos(); 
    Aluno getAlunoById(Long id);
    //Aluno saveAluno(Aluno aluno); //add + edit
    Aluno addAluno(Aluno aluno);
    Aluno editAluno(Aluno aluno);
    String deleteAluno(long id);
} // Todos os metodos q terão de ser implementados

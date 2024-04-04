package arquiteturaweb.ac1.aula3.repository;

import main.java.arquiteturaweb.ac1.aula3.model.Aluno;
import org.springframework.stereotype.Repository;
import arquiteturaweb.ac1.aula3.repository.AlunoRepository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final List<Aluno> alunos = new ArrayList<>();
    private Long nextId = 1L; //Array e iniciando a var pra definir os ids

    //Aluno pre cadastrado pra ajudar a testar
    public AlunoRepositoryImpl(){
        alunos.add(new Aluno(nextId++, "Lucas da Silva", "159898988", 10, "Belas Artes", "lucassilva@email.com"));
        nextId = 2L; //ajusta p q o prox id seja 2 pra evitar erros
    }

    //Metodos Interface
    @Override
    public List<Aluno> getAllAlunos() {
        return alunos;
    }
    
    @Override
    public Aluno getAlunoById(Long id) {
        return alunos.stream()
                .filter(aluno -> aluno.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Aluno addAluno(Aluno aluno) {
        aluno.setId((long) (alunos.size() + 1));
        alunos.add(aluno);
        System.out.println("Aluno adicionado: " + aluno); 
        return aluno; 
    }
    
    @Override //Alterar pra String pra ter feedback(?)
    public Aluno editAluno(Long id, Aluno alunoAtualizado) {
        Aluno alunoExistente = getAlunoById(id);
        if (alunoExistente != null) {
            alunoExistente.setNome(alunoAtualizado.getNome());
            alunoExistente.setCelular(alunoAtualizado.getCelular());
            alunoExistente.setIdade(alunoAtualizado.getIdade());
            alunoExistente.setCurso(alunoAtualizado.getCurso());
            alunoExistente.setEmail(alunoAtualizado.getEmail());
        }
        return alunoExistente;
    }

   // @Override
    //public void deleteAluno(Long id) {
    //    System.out.println("Removendo Aluno "); 
    //    alunos.removeIf(aluno -> aluno.getId().equals(id));
   // }

}

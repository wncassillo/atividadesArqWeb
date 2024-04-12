package arquiteturaweb.ac1.aula3.repository;

import arquiteturaweb.ac1.aula3.model.Aluno;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

@Repository
public class AlunoRepositoryImpl implements AlunoRepository {
    private final JdbcTemplate jdbcTemplate;

    public AlunoRepositoryImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    //Metodos 
    @Override
    public List<Aluno> getAllAlunos() { 
        return jdbcTemplate.query("SELECT * FROM aluno", (resultSet, rowNum) -> {
                    System.out.println("Numero da linha: " + rowNum);
                    return new Aluno(
                            resultSet.getLong("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("celular"),
                            resultSet.getInt("idade"),
                            resultSet.getString("curso"),
                            resultSet.getString("email")
                    );
                }
        );
    }
    
    @Override
    public Aluno getAlunoById(Long id) {
        String query = "SELECT * FROM aluno WHERE id = ?";
        return jdbcTemplate.queryForObject(query, new Object[]{id}, (resultSet, rowNum) ->
                new Aluno(
                       resultSet.getLong("id"),
                            resultSet.getString("nome"),
                            resultSet.getString("celular"),
                            resultSet.getInt("idade"),
                            resultSet.getString("curso"),
                            resultSet.getString("email")
                )
        );
    }

    //juntando o Add e o edit em um só
    
            String updateQuery = "UPDATE public.aluno SET nome = ?, celular = ?, idade = ?, curso = ?, email = ? WHERE id = ?";
               
       
    @Override
    public Aluno addAluno(Aluno aluno) {
        if (aluno.getId() != null) {
            String insertQuery = "INSERT INTO public.aluno (id, nome, celular, idade, curso, email) VALUES (?, ?, ?, ?, ?, ?)";
            jdbcTemplate.update(insertQuery, aluno.getId(), aluno.getNome(), aluno.getCelular(),
                    aluno.getIdade(), aluno.getCurso(), aluno.getEmail());        }
        return aluno;
    }

    @Override
    public Aluno editAluno(Aluno aluno) {
        
            String updateQuery = "UPDATE public.aluno SET nome = ?, celular = ?, idade = ?, curso = ?, email = ? WHERE id = ?";
            jdbcTemplate.update(updateQuery, aluno.getNome(), aluno.getCelular(),
                 aluno.getIdade(), aluno.getCurso(), aluno.getEmail(), aluno.getId());  
        
        return aluno;
    }

    @Override // Tem que mudar
    public String deleteAluno(long id) {
        Aluno alunoExistente = getAlunoById(id);
        if (alunoExistente != null) {
            return "Aluno removido com sucesso";
        } else {
            return "Aluno não encontrado";
        }
    }

}

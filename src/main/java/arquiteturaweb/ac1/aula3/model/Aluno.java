package arquiteturaweb.ac1.aula3.model;

public class Aluno {
    private Long id;
    private String nome;
    private String celular;
    private int idade;
    private String curso;
    private String email;

    public Aluno(Long id, String nome, String celular, int idade, String curso, String email) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.idade = idade;
        this.curso = curso;
        this.email = email;
    }
    
    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getCelular() {
        return celular;
    }
    public String getCurso() {
        return curso;
    }
    public String getEmail() {
        return email;
    }
    public int getIdade() {
        return idade;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
}

package br.wncassillo.arquitetura.alunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "aluno") 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Aluno não pode ter um nome em branco.")
    @Size(min = 3, max = 120, message = "O Nome deve ter entre 3 e 120 caracteres.")
    private String nome;

    @NotBlank(message = "O Aluno deve ter um numero de celular.")
    @Size(min = 5, max = 30, message = "O numero deve possuir de 5 a 20 caracteres.") 
    private String celular;

    private int idade;  //Idade pode ser em branco

    @NotNull(message = "O curso não pode ser nulo.")//foreign key
    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @NotBlank(message = "O Aluno deve ter um endereço de email.") 
    @Size(min = 10, max = 120, message = "O email deve possuir de 10 a 120 caracteres.") 
    @Email(message = "O endereço de E-Mail deve ser válido.")
    private String email;

}

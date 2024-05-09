package br.wncassillo.arquitetura.alunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "aluno2") // minha tabela "aluno" estava dando erro, por que o character varying[], 
//como fizemos na aula dava erro por que ele espera receber uma array de strings,
// então criei outra tabela, dessa vez com apenas character varying
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String celular;

    private int idade;

    private String curso;

    private String email;

}

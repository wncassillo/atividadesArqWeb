package br.wncassillo.arquitetura.alunos.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table (name = "curso") //nome da tabela
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O Curso não pode ter um título em branco.")
    @Size(min = 3, max = 120, message = "O título deve ter entre 3 e 120 caracteres.")
    private String titulo;

    //A duracao pode ficar em branco.
    private String duracao;
    
}

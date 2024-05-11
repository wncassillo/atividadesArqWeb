package br.wncassillo.arquitetura.alunos.exceptions;

public class AlunoNaoEncontradoException extends RuntimeException{

    public AlunoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public AlunoNaoEncontradoException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}

package br.ufpe.cin.pokezoo.zelador;

public class ZeladorNaoEncontradoException extends Exception{
    public ZeladorNaoEncontradoException(){
        super("Zelador nao encontrado!");
    }
}

package br.ufpe.cin.pokezoo.viveiros;

public class ViveiroNaoEncontradoException extends Exception {
    public ViveiroNaoEncontradoException() {
        super("Viveiro não encontrado!");
    }
}
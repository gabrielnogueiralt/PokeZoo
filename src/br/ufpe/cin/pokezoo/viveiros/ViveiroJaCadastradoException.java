package br.ufpe.cin.pokezoo.viveiros;

public class ViveiroJaCadastradoException extends Exception {
    public ViveiroJaCadastradoException() {
        super("Viveiro já cadastrado!");
    }
}

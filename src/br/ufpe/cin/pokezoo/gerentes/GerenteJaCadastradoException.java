package br.ufpe.cin.pokezoo.gerentes;

public class GerenteJaCadastradoException extends Exception {

    public GerenteJaCadastradoException() {
        super("Esse gerente ja esta cadastrado no sistema.");
    }
}

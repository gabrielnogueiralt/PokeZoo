package br.ufpe.cin.pokezoo.gerentes;

public class GerenteNaoEncontradoException extends Exception {

    public GerenteNaoEncontradoException() {
        super("Gerente nao encontrado no sistema.");
    }
}

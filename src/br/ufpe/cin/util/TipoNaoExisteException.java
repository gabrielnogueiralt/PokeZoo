package br.ufpe.cin.util;

public class TipoNaoExisteException extends Exception{
    public TipoNaoExisteException(){
        super("Tipo de pokemon invalido!");
    }
}

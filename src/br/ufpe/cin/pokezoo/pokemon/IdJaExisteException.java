package br.ufpe.cin.pokezoo.pokemon;



//execao para quando o id escolhido para um novo pokemon ja esta sendo usado
public class IdJaExisteException extends Exception{
    public IdJaExisteException(){
        super("Id já existe, por favor, escolha outro");
    }
}
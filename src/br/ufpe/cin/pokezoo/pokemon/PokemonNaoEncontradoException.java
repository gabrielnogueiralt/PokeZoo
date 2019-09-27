package br.ufpe.cin.pokezoo.pokemon;


//Execao para quando um certo pokemon nao e encontrado no repositorio
public class PokemonNaoEncontradoException extends Exception{
    public PokemonNaoEncontradoException() {
        super("Pokemon não encontrado!");
    }
}

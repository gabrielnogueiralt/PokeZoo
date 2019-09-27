package br.ufpe.cin.pokezoo.pokemon;

public class PokemonJaCadastradoException extends Exception {
    public PokemonJaCadastradoException(){
        super("Pokemon já cadastrado!");
    }
}

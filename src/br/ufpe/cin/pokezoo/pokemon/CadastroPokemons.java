package br.ufpe.cin.pokezoo.pokemon;

import br.ufpe.cin.util.LimiteAtingidoException;

public class CadastroPokemons {

    private RepositorioPokemons repositorio;

    public CadastroPokemons(RepositorioPokemons repo){
        repositorio = repo;
    }

    public void cadastrar(Pokemon pokemon) throws PokemonJaCadastradoException, LimiteAtingidoException {
        if (!this.repositorio.existe(pokemon.getId())) {
            this.repositorio.inserir(pokemon);
        } else {
            PokemonJaCadastradoException e;
            e = new PokemonJaCadastradoException();
            throw e;
        }
    }

    public void atualizar(Pokemon pokemon) throws PokemonNaoEncontradoException{
        this.repositorio.atualizar(pokemon);
    }

    public void remover(int id) throws PokemonNaoEncontradoException{
        this.repositorio.remover(id);
    }

    public Pokemon procurar(int id) throws PokemonNaoEncontradoException{
        return this.repositorio.procurar(id);
    }

    public boolean existe(int id){
        return this.repositorio.existe(id);
    }

}

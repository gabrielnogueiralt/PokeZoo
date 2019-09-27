package br.ufpe.cin.pokezoo.pokemon;

import br.ufpe.cin.util.LimiteAtingidoException;

public class RepositorioPokemonsArray implements RepositorioPokemons{
    private Pokemon[] arrayPokemons;
    private int index;

    public RepositorioPokemonsArray(){
        this.arrayPokemons = new Pokemon[100];
        this.index = 0;
    }

    private int getIndex(int id) throws PokemonNaoEncontradoException{
        int retorno = -1;
        boolean achou = false;
        for (int i = 0; i < this.index && retorno == -1; i++) {
            if (this.arrayPokemons[i].getId() == id){
                retorno = i;
            }
        }
        if (retorno >= 0){
            return retorno;
        }else{
            PokemonNaoEncontradoException e;
            e = new PokemonNaoEncontradoException();
            throw e;
        }
    }

    @Override
    public void inserir(Pokemon pokemon) throws LimiteAtingidoException{

        if (this.index < this.arrayPokemons.length){
            this.arrayPokemons[this.index] = pokemon;
            this.index = this.index + 1;
        }else{
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    @Override
    public void remover(int id) throws PokemonNaoEncontradoException{
        int i = getIndex(id);
        if (this.arrayPokemons.length - 1 - i >= 0) {
            System.arraycopy(arrayPokemons, i + 1, this.arrayPokemons, i, this.arrayPokemons.length - 1 - i);
        }
        this.arrayPokemons[this.arrayPokemons.length - 1] = null;
        this.index = this.index - 1;
    }

    @Override
    public boolean existe(int id) {
        boolean achou = false;
        for (int i = 0; i < this.index && !achou; i++) {
            if (this.arrayPokemons[i].getId() == id) {
                achou = true;
            }
        }
        return achou;
    }

    @Override
    public Pokemon procurar(int id) throws PokemonNaoEncontradoException{
        Pokemon retorno = null;
        for (int i = 0; i < this.index && retorno == null; i++) {
            if (this.arrayPokemons[i].getId() == id){
                retorno = this.arrayPokemons[i];
            }
        }
        if (retorno != null){
            return  retorno;
        }else{
            PokemonNaoEncontradoException e;
            e = new PokemonNaoEncontradoException();
            throw e;
        }

    }

    @Override
    public void atualizar(Pokemon pokemon) throws PokemonNaoEncontradoException{
        int i = this.getIndex(pokemon.getId());
        arrayPokemons[index] = pokemon;
    }
}

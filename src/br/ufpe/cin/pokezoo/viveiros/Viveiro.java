package br.ufpe.cin.pokezoo.viveiros;

import br.ufpe.cin.pokezoo.pokemon.Pokemon;
import br.ufpe.cin.pokezoo.pokemon.RepositorioPokemons;
import br.ufpe.cin.pokezoo.pokemon.RepositorioPokemonsArray;
import br.ufpe.cin.util.LimiteAtingidoException;
import br.ufpe.cin.util.TipoNaoExisteException;

public class Viveiro {
    private int id;
    private String tipo;
    private int capacidade;
    private int estoqueComida;
    private RepositorioPokemons pokemons;
    private int quantidadePokemons;

    public Viveiro(int id, String tipo, int capacidade, int estoqueComida) throws TipoNaoExisteException{
        if (!tipo.equals("Magico") && !tipo.equals("Floresta") && !tipo.equals("Montanha")) {
            TipoNaoExisteException e;
            e = new TipoNaoExisteException();
            throw e;
        }
        this.id = id;
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.estoqueComida = estoqueComida;
        this.pokemons = new RepositorioPokemonsArray();
        this.quantidadePokemons = 0;
    }  
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public int getEstoqueComida() {
        return estoqueComida;
    }

    public void setEstoqueComida(int estoqueComida) {
        this.estoqueComida = estoqueComida;
    }

    public int getQuantidadePokemons(){
        return quantidadePokemons;
    }

    public void setQuantidadePokemons(int x) {
        this.quantidadePokemons = x;
    }

    public void adcionaPokemon(Pokemon pokemon) throws LimiteAtingidoException {
        pokemons.inserir(pokemon);
    }
}

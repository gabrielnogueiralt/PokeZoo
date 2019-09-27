package br.ufpe.cin.pokezoo.pokemon;

import br.ufpe.cin.util.LimiteAtingidoException;

public interface RepositorioPokemons {


    //Funcao para Inserir um Objeto Pokemon No repositorio
    void inserir(Pokemon pokemon)
            throws LimiteAtingidoException;


    //Funcao para atualizar os dados de um pokemon dentro do repositorio
    void atualizar(Pokemon pokemon)
            throws PokemonNaoEncontradoException;

    //Funcao para remover um pokemon do repositorio
    void remover(int id)
            throws PokemonNaoEncontradoException;

    //Funcao que retorna o objeto pokemon inserido no repositorio
    Pokemon procurar(int id)
            throws PokemonNaoEncontradoException;

    //Funcao booleana para saber da existencia de certo pokemon no repositorio a partir do seu Id
    boolean existe(int id);
}

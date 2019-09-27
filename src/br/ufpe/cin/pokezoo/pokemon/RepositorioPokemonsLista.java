package br.ufpe.cin.pokezoo.pokemon;

public class RepositorioPokemonsLista implements RepositorioPokemons{
    private Pokemon pokemon;
    private RepositorioPokemonsLista proximo;

    //Construtor do repositorio
    public RepositorioPokemonsLista(){
        this.pokemon = null;
        this.proximo = null;
    }

    @Override
    public void inserir(Pokemon pokemon) {
        if (this.proximo == null){
            this.pokemon = pokemon;
            this.proximo = new RepositorioPokemonsLista();
        }else{
            this.proximo.inserir(pokemon);
        }
    }

    @Override
    public void remover(int id) throws PokemonNaoEncontradoException{
        Pokemon achado = this.procurar(id);
        if (this.pokemon != null) {
            if (this.pokemon.getId() == achado.getId()) {
                this.pokemon = this.proximo.pokemon;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(id);
            }
        } else {
            PokemonNaoEncontradoException e;
            e = new PokemonNaoEncontradoException();
            throw e;
        }
    }

    @Override
    public boolean existe(int id) {
        if (this.pokemon != null) {
            if (this.pokemon.getId() == id) {
                return true;
            } else {
                return this.proximo.existe(id);
            }
        } else {
            return false;
        }
    }

    @Override
    public Pokemon procurar(int id) throws PokemonNaoEncontradoException{
        Pokemon retorno;
        retorno = null;
        if (this.pokemon != null) {
            if (this.pokemon.getId() == id) {
                retorno = this.pokemon;
            } else {
                this.proximo.procurar(id);
            }
        } else {
            PokemonNaoEncontradoException e;
            e = new PokemonNaoEncontradoException();
            throw e;
        }
        return retorno;
    }

    @Override
    public void atualizar(Pokemon pokemon) throws PokemonNaoEncontradoException{
        Pokemon pokemonAntigo = procurar(pokemon.getId());
        this.remover(pokemonAntigo.getId());
        this.inserir(pokemon);
    }

    public static class TiposDiferentesException extends Exception {
        public TiposDiferentesException() {
            super("Esse Pokemon nao pode sobreviver nesse viveiro!");
        }
    }
}

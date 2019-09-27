package br.ufpe.cin.pokezoo.fachada;
import br.ufpe.cin.util.LimiteAtingidoException;
import br.ufpe.cin.pokezoo.zelador.*;
import br.ufpe.cin.pokezoo.gerentes.*;
import br.ufpe.cin.pokezoo.viveiros.*;
import br.ufpe.cin.pokezoo.pokemon.*;

public class PokeZoo {

    private CadastroZeladores zeladores;
    private CadastroGerentes gerentes;
    private CadastroPokemons pokemons;
    private CadastroViveiros viveiros;

    public PokeZoo(RepositorioGerentes repoGerentes, RepositorioPokemons repoPokemons, RepositorioViveiros repoViveiros, RepositorioZeladores repoZeladores) {
        this.zeladores = new CadastroZeladores(repoZeladores);
        this.gerentes = new CadastroGerentes(repoGerentes);
        this.pokemons = new CadastroPokemons(repoPokemons);
        this.viveiros = new CadastroViveiros(repoViveiros);
    }

    public void cadastrarZelador(Zelador zelador)
            throws LimiteAtingidoException, ZeladorJaCadastradoException, ZeladorNaoEncontradoException {
        if (this.zeladores.existe(zelador.getCpf())) {
            ZeladorJaCadastradoException e;
            e = new ZeladorJaCadastradoException();
            throw e;
        } else {
            zeladores.cadastrar(zelador);
        }
    }

    public void removerZelador(String cpf)
            throws ZeladorNaoEncontradoException {
        this.zeladores.remover(cpf);
    }

    public void atualizarZelador(Zelador funcionario)
            throws ZeladorNaoEncontradoException {
        if (this.zeladores.existe(funcionario.getCpf())) {
            this.zeladores.atualizar(funcionario);
        } else {
            ZeladorNaoEncontradoException e;
            e = new ZeladorNaoEncontradoException();
            throw e;
        }

    }

    public Zelador procurarZelador(String cpf)
            throws ZeladorNaoEncontradoException {
        return this.zeladores.procurar(cpf);
    }

    public void cadastrarViveiros(Viveiro viveiro) throws LimiteAtingidoException, ViveiroJaCadastradoException {
        if (this.viveiros.existe(viveiro.getId())) {
            ViveiroJaCadastradoException e;
            e = new ViveiroJaCadastradoException();
            throw e;
        } else {
            viveiros.cadastrar(viveiro);
        }
    }

    public void removerViveiro(int id) throws ViveiroNaoEncontradoException {
        this.viveiros.remover(id);
    }

    public void atualizarViveiro(Viveiro viveiro) throws ViveiroNaoEncontradoException {
        if (this.viveiros.existe(viveiro.getId())) {
            this.viveiros.atualizar(viveiro);
        } else {
            ViveiroNaoEncontradoException e;
            e = new ViveiroNaoEncontradoException();
            throw e;
        }

    }

    public Viveiro procurarViveiro(int id) throws ViveiroNaoEncontradoException {
        return this.viveiros.procurar(id);
    }

    public boolean existeViveiro(int id){
        return this.viveiros.existe(id);
    }

    public void cadastrarGerente(Gerentes gerente)
            throws LimiteAtingidoException, GerenteJaCadastradoException, GerenteNaoEncontradoException {
        if (this.gerentes.existe(gerente.getCpf())) {
            GerenteJaCadastradoException e;
            e = new GerenteJaCadastradoException();
            throw e;
        } else {
            gerentes.cadastrar(gerente);
        }
    }

    public void removerGerente(String cpf)
            throws GerenteNaoEncontradoException {
        this.gerentes.remover(cpf);
    }

    public void atualizarGerente(Gerentes funcionario)
            throws GerenteNaoEncontradoException {
        if (this.gerentes.existe(funcionario.getCpf())) {
            this.gerentes.atualizar(funcionario);
        } else {
            GerenteNaoEncontradoException e;
            e = new GerenteNaoEncontradoException();
            throw e;
        }

    }

    public Gerentes procurarGerente(String cpf)
            throws GerenteNaoEncontradoException {
        return this.gerentes.procurar(cpf);
    }

    public void cadastrarPokemon(Pokemon pokemon) throws PokemonJaCadastradoException, LimiteAtingidoException {
        if (this.pokemons.existe(pokemon.getId())) {
            PokemonJaCadastradoException e;
            e = new PokemonJaCadastradoException();
            throw e;
        } else {
            pokemons.cadastrar(pokemon);
        }
    }

    public void removerPokemon(int id) throws PokemonNaoEncontradoException {
        this.pokemons.remover(id);
    }

    public Pokemon procurarPokemon(int id) throws PokemonNaoEncontradoException {
        return this.pokemons.procurar(id);
    }

    public void atualizarPokemon(Pokemon pokemon) throws PokemonNaoEncontradoException {
        if (this.pokemons.existe(pokemon.getId())) {
            this.pokemons.atualizar(pokemon);
        } else {
            PokemonNaoEncontradoException e;
            e = new PokemonNaoEncontradoException();
            throw e;
        }
    }
}

package br.ufpe.cin.pokezoo.gerentes;

import br.ufpe.cin.util.LimiteAtingidoException;


public interface RepositorioGerentes {

    public void inserir(Gerentes gerente)
            throws LimiteAtingidoException;

    public void atualizar(Gerentes gerente)
            throws GerenteNaoEncontradoException;

    public void remover(String cpf)
            throws GerenteNaoEncontradoException;

    public Gerentes procurar(String cpf)
            throws GerenteNaoEncontradoException;

    public boolean existe(String cpf);
}

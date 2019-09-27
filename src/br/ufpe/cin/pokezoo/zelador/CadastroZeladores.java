package br.ufpe.cin.pokezoo.zelador;

import br.ufpe.cin.util.LimiteAtingidoException;

public class CadastroZeladores {

    private RepositorioZeladores repositorio;

    public CadastroZeladores(RepositorioZeladores repo) {
        repositorio = repo;
    }

    public void cadastrar(Zelador zelador) throws ZeladorJaCadastradoException, LimiteAtingidoException {
        if (!this.repositorio.existe(zelador.getCpf())) {
            this.repositorio.inserir(zelador);
        } else {
            ZeladorJaCadastradoException e;
            e = new ZeladorJaCadastradoException();
            throw e;
        }
    }

    public void atualizar(Zelador zelador) throws ZeladorNaoEncontradoException {
        this.repositorio.atualizar(zelador);
    }

    public void remover(String cpf)
            throws ZeladorNaoEncontradoException {
        this.repositorio.remover(cpf);
    }

    public Zelador procurar(String cpf)
            throws ZeladorNaoEncontradoException {
        return this.repositorio.procurar(cpf);
    }

    public boolean existe(String cpf) {

        return this.repositorio.existe(cpf);
    }

}

package br.ufpe.cin.pokezoo.viveiros;

import br.ufpe.cin.util.LimiteAtingidoException;

public class CadastroViveiros {

    private RepositorioViveiros repositorio;

    public CadastroViveiros(RepositorioViveiros repo) {
        repositorio = repo;
    }

    public void cadastrar(Viveiro viveiro) throws ViveiroJaCadastradoException, LimiteAtingidoException{
        if (!this.repositorio.existe(viveiro.getId())) {
            this.repositorio.inserir(viveiro);
        } else {
            ViveiroJaCadastradoException e;
            e = new ViveiroJaCadastradoException();
            throw e;
        }
    }
    
    public void atualizar(Viveiro Viveiro) throws ViveiroNaoEncontradoException {
        this.repositorio.atualizar(Viveiro);
    }

    public void remover(int id) throws ViveiroNaoEncontradoException {
        this.repositorio.remover(id);
    }

    public Viveiro procurar(int id) throws ViveiroNaoEncontradoException {
        return this.repositorio.procurar(id);
    }

    public boolean existe(int id) {
        return this.repositorio.existe(id);
    }
}

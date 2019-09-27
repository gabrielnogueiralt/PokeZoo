package br.ufpe.cin.pokezoo.viveiros;

public class RepositorioViveirosLista implements RepositorioViveiros{
    private Viveiro viveiro;
    private RepositorioViveirosLista proximo;
    
    public void inserir(Viveiro viveiro){
        if (this.viveiro == null) {
            this.viveiro = viveiro;
            this.proximo = new RepositorioViveirosLista();
        } else {
            this.proximo.inserir(viveiro);
        }
    }

    public void atualizar(Viveiro viveiro) throws ViveiroNaoEncontradoException {
        Viveiro viveiroAntigo = procurar(viveiro.getId());
        this.remover(viveiroAntigo.getId());
        this.inserir(viveiro);
    }

    public void remover(int id) throws ViveiroNaoEncontradoException {
        Viveiro achado = this.procurar(id);
        if (this.viveiro != null) {
            if (this.viveiro.equals(achado)) {
                this.viveiro = this.proximo.viveiro;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(id);
            }
        } else {
            ViveiroNaoEncontradoException e;
            e = new ViveiroNaoEncontradoException();
            throw e;
        }
    }

    public Viveiro procurar(int id) throws ViveiroNaoEncontradoException {
        Viveiro retorno;
        retorno = null;
        if (this.viveiro != null) {
            if (this.viveiro.getId() == id) {
                retorno = this.viveiro;
            } else {
                retorno = this.proximo.procurar(id);
            }
        } else {
            ViveiroNaoEncontradoException e;
            e = new ViveiroNaoEncontradoException();
            throw e;
        }
        return retorno;
    }

    public boolean existe(int id) {
        if (this.viveiro != null) {
            if (this.viveiro.getId() == id) {
                return true;
            } else {
                return this.proximo.existe(id);
            }
        } else {
            return false;
        }
    }
    
}

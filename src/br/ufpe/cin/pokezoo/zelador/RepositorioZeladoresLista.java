package br.ufpe.cin.pokezoo.zelador;

public class RepositorioZeladoresLista implements RepositorioZeladores {
    
	private Zelador zelador;
    private RepositorioZeladoresLista proximo;

    public RepositorioZeladoresLista() {
        this.zelador = null;
        this.proximo = null;
    }

    public void inserir(Zelador zelador) {
        if (this.zelador == null) {
            this.zelador = zelador;
            this.proximo = new RepositorioZeladoresLista();
        } else {
            this.proximo.inserir(zelador);
        }
    }

    public void remover(String cpf)
            throws ZeladorNaoEncontradoException {
        Zelador zeladorEncontrado = this.procurar(cpf);
        if (this.zelador != null) {
            if (this.zelador.equals(zeladorEncontrado)) {
                this.zelador = this.proximo.zelador;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(cpf);
            }
        } else {
            ZeladorNaoEncontradoException e;
            e = new ZeladorNaoEncontradoException();
            throw e;
        }
    }

    public Zelador procurar(String cpf)
            throws ZeladorNaoEncontradoException {
    	Zelador retorno;
        retorno = null;
        if (this.zelador != null) {
            if (this.zelador.getCpf().equals(cpf)) {
                retorno = this.zelador;
            } else {
                retorno = this.proximo.procurar(cpf);
            }
        } else {
            ZeladorNaoEncontradoException e;
            e = new ZeladorNaoEncontradoException();
            throw e;
        }
        return retorno;
    }

    public void atualizar(Zelador zelador)
            throws ZeladorNaoEncontradoException {
        Zelador zeladorAntigo = procurar(zelador.getCpf());
        this.remover(zeladorAntigo.getCpf());
        this.inserir(zelador);
    }

    public boolean existe(String cpf) {
        if (this.zelador != null) {
            if (this.zelador.getCpf().equals(cpf)) {
                return true;
            } else {
                return this.proximo.existe(cpf);
            }
        } else {
            return false;
        }
    }
}

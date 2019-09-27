package br.ufpe.cin.pokezoo.gerentes;

public class RepositorioGerentesLista implements RepositorioGerentes {

    private Gerentes gerente;
    private RepositorioGerentesLista proximo;

    public RepositorioGerentesLista() {
        this.gerente = null;
        this.proximo = null;
    }

    public void inserir(Gerentes gerente) {
        if (this.gerente == null) {
            this.gerente = gerente;
            this.proximo = new RepositorioGerentesLista();
        } else {
            this.proximo.inserir(gerente);
        }
    }

    public void remover(String cpf)
            throws GerenteNaoEncontradoException {
        Gerentes gerenteEncontrado = this.procurar(cpf);
        if (this.gerente != null) {
            if (this.gerente.equals(gerenteEncontrado)) {
                this.gerente = this.proximo.gerente;
                this.proximo = this.proximo.proximo;
            } else {
                this.proximo.remover(cpf);
            }
        } else {
            GerenteNaoEncontradoException e;
            e = new GerenteNaoEncontradoException();
            throw e;
        }
    }

    public Gerentes procurar(String cpf)
            throws GerenteNaoEncontradoException {
        Gerentes retorno;
        retorno = null;
        if (this.gerente != null) {
            if (this.gerente.getCpf().equals(cpf)) {
                retorno = this.gerente;
            } else {
                retorno = this.proximo.procurar(cpf);
            }
        } else {
            GerenteNaoEncontradoException e;
            e = new GerenteNaoEncontradoException();
            throw e;
        }
        return retorno;
    }

    public void atualizar(Gerentes gerente)
            throws GerenteNaoEncontradoException {
        Gerentes gerenteAntigo = procurar(gerente.getCpf());
        this.remover(gerenteAntigo.getCpf());
        this.inserir(gerente);
    }

    public boolean existe(String cpf) {
        if (this.gerente != null) {
            if (this.gerente.getCpf().equals(cpf)) {
                return true;
            } else {
                return this.proximo.existe(cpf);
            }
        } else {
            return false;
        }
    }
}

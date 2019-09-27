package br.ufpe.cin.pokezoo.zelador;

import br.ufpe.cin.util.LimiteAtingidoException;

public class RepositorioZeladoresArray implements RepositorioZeladores {

    private Zelador[] arrayZeladores;
    private int indice;

    public RepositorioZeladoresArray() {
        this.arrayZeladores = new Zelador[200];
        this.indice = 0;
    }

    public void inserir(Zelador zelador)
            throws LimiteAtingidoException {

        if (this.indice < this.arrayZeladores.length) {
            this.arrayZeladores[indice] = zelador;
            indice = indice + 1;
        } else {
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    public void remover(String cpf)
            throws ZeladorNaoEncontradoException {
        int index = this.getIndice(cpf);

        if (this.arrayZeladores.length - 1 - index >= 0) {
            System.arraycopy(arrayZeladores, index + 1, this.arrayZeladores, index, this.arrayZeladores.length - 1 - index);
        }
        this.arrayZeladores[this.arrayZeladores.length - 1] = null;
        this.indice = this.indice - 1;
    }

    public Zelador procurar(String cpf)
            throws ZeladorNaoEncontradoException {
        Zelador retorno = null;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayZeladores[i].getCpf().equals(cpf)) {
                retorno = this.arrayZeladores[i];
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            ZeladorNaoEncontradoException e;
            e = new ZeladorNaoEncontradoException();
            throw e;
        }
    }

    public void atualizar(Zelador zelador)
            throws ZeladorNaoEncontradoException {
        int index = this.getIndice(zelador.getCpf());
        arrayZeladores[index] = zelador;
    }

    public boolean existe(String cpf) {
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayZeladores[i].getCpf().equals(cpf)) {
                achou = true;
            }
        }
        return achou;
    }

    private int getIndice(String cpf)
            throws ZeladorNaoEncontradoException {
        int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayZeladores[i].getCpf().equals(cpf)) {
                retorno = i;
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            ZeladorNaoEncontradoException e;
            e = new ZeladorNaoEncontradoException();
            throw e;
        }
    }
}

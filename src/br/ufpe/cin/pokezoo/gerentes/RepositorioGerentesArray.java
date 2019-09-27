package br.ufpe.cin.pokezoo.gerentes;

import br.ufpe.cin.util.LimiteAtingidoException;

public class RepositorioGerentesArray implements RepositorioGerentes {

    private Gerentes[] arrayGerentes;
    private int indice;

    public RepositorioGerentesArray() {
        this.arrayGerentes = new Gerentes[200];
        this.indice = 0;
    }

    // Insere novo gerente no array
    public void inserir(Gerentes gerente)
            throws LimiteAtingidoException {

        // Verifica se ainda h� espa�o no array
        if (this.indice < this.arrayGerentes.length) {
            this.arrayGerentes[indice] = gerente;
            indice = indice + 1;
        } else {
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        }
    }

    // Remove um gerente do array, e reorganiza o array
    public void remover(String cpf)
            throws GerenteNaoEncontradoException {
        int index = this.getIndice(cpf);
        // Reorganiza os gerentes no array
        if (this.arrayGerentes.length - 1 - index >= 0) {
            System.arraycopy(arrayGerentes, index + 1, this.arrayGerentes, index, this.arrayGerentes.length - 1 - index);
        }
        this.arrayGerentes[this.arrayGerentes.length - 1] = null;
        this.indice = this.indice - 1;
    }

    // Procura um gerente no array, caso exista, retorna o gerente
    public Gerentes procurar(String cpf)
            throws GerenteNaoEncontradoException {
        Gerentes retorno = null;
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayGerentes[i].getCpf().equals(cpf)) {
                retorno = this.arrayGerentes[i];
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            GerenteNaoEncontradoException e;
            e = new GerenteNaoEncontradoException();
            throw e;
        }
    }

    // Atualiza um gerente no array, caso o mesmo exista
    public void atualizar(Gerentes gerenteNovo)
            throws GerenteNaoEncontradoException {
        boolean achou = false;
        int i = 0;
        String cpf = gerenteNovo.getCpf();
        for (; i < this.indice && !achou; i++) {
            if (this.arrayGerentes[i].getCpf().equals(cpf)) {
                achou = true;
                this.arrayGerentes[i] = gerenteNovo;
            }
        }
        if (achou) {
            arrayGerentes[i] = gerenteNovo;
        } else {
            GerenteNaoEncontradoException e;
            e = new GerenteNaoEncontradoException();
            throw e;
        }
    }

    // Verifica se existe um gerente no array
    public boolean existe(String cpf) {
        boolean achou = false;
        for (int i = 0; i < this.indice && !achou; i++) {
            if (this.arrayGerentes[i].getCpf().equals(cpf)) {
                achou = true;
            }
        }
        return achou;
    }

    //retorna o indice de um Gerente buscando pelo seu CPF
    public int getIndice(String s)
            throws GerenteNaoEncontradoException {
        for (int i = 0; i < this.indice; i++) {
            if (arrayGerentes[i].getCpf().equals(s)) {
                return i;
            }
        }
        throw new GerenteNaoEncontradoException();
    }
}

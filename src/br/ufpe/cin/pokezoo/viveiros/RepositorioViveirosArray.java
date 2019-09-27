package br.ufpe.cin.pokezoo.viveiros;

import br.ufpe.cin.util.LimiteAtingidoException;

public class RepositorioViveirosArray implements RepositorioViveiros{
    private Viveiro[] arrayViveiro;
    private int index;

    public RepositorioViveirosArray() {
        this.arrayViveiro = new Viveiro[100];
        this.index = 0;
    }
    
    public void inserir(Viveiro viveiro) throws ViveiroJaCadastradoException, LimiteAtingidoException {
        if(this.index < this.arrayViveiro.length) {
            this.arrayViveiro[index] = viveiro;
            index = index + 1;
        }else{  
            LimiteAtingidoException e;
            e = new LimiteAtingidoException();
            throw e;
        } 
    }

    public void atualizar(Viveiro viveiro) throws ViveiroNaoEncontradoException{
        int i = this.getIndex(viveiro.getId());
        arrayViveiro[i] = viveiro;
    }

    public void remover(int id) throws ViveiroNaoEncontradoException{
        int i = this.getIndex(id);
        if (this.arrayViveiro.length - 1 - i >= 0) {
            System.arraycopy(arrayViveiro, i + 1, this.arrayViveiro, i, this.arrayViveiro.length - 1 - i);
        }
        this.arrayViveiro[this.arrayViveiro.length - 1] = null;
        this.index = this.index - 1;
    }

    public Viveiro procurar(int id) throws ViveiroNaoEncontradoException {
        Viveiro retorno = null;
        boolean achou = false;
        for (int i = 0; i < this.index && !achou; i++) {
            if (this.arrayViveiro[i].getId() == id) {
                retorno = this.arrayViveiro[i];
                achou = true;
            }
        }
        if(achou) {
            return retorno;
        }else{
            ViveiroNaoEncontradoException e;
            e = new ViveiroNaoEncontradoException();
            throw e;
        }
    }

    public boolean existe(int id) {
        boolean achou = false;
        for (int i = 0; i < this.index && !achou; i++) {
            if (this.arrayViveiro[i].getId() == id) {
                achou = true;
            }
        }
        return achou;
    }
    
    private int getIndex(int id) throws ViveiroNaoEncontradoException {
        int retorno = 0;
        boolean achou = false;
        for (int i = 0; i < this.index && !achou; i++) {
            if (this.arrayViveiro[i].getId() == id) {
                retorno = i;
                achou = true;
            }
        }
        if (achou) {
            return retorno;
        } else {
            ViveiroNaoEncontradoException e;
            e = new ViveiroNaoEncontradoException();
            throw e;
        }
    }
    
}

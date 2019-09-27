package br.ufpe.cin.pokezoo.viveiros;
import br.ufpe.cin.util.LimiteAtingidoException;

public interface RepositorioViveiros {
    void inserir(Viveiro viveiro)
            throws ViveiroJaCadastradoException, LimiteAtingidoException;
    void atualizar(Viveiro viveiro)
            throws ViveiroNaoEncontradoException;
    void remover(int id)
            throws ViveiroNaoEncontradoException;
    Viveiro procurar(int id)
            throws ViveiroNaoEncontradoException;
    boolean existe(int id);
}

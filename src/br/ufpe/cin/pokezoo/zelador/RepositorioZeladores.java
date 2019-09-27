package br.ufpe.cin.pokezoo.zelador;

import br.ufpe.cin.pokezoo.funcionario.FuncionarioAbstrato;
import br.ufpe.cin.util.LimiteAtingidoException;

public interface RepositorioZeladores {
	
	void inserir(Zelador zelador)throws LimiteAtingidoException;
			
	void atualizar(Zelador zelador)throws ZeladorNaoEncontradoException;
			
	void remover(String cpf)throws ZeladorNaoEncontradoException;
	
	Zelador procurar(String cpf) throws ZeladorNaoEncontradoException;
        
	boolean existe(String cpf);
}

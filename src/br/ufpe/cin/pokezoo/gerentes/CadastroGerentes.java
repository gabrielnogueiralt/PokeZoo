package br.ufpe.cin.pokezoo.gerentes;

import br.ufpe.cin.util.LimiteAtingidoException;

public class CadastroGerentes {

    private RepositorioGerentes repositorio;
    //Se o construtor receber um parametro true, inicializa uma lista, caso contrario inicializa um array

    public CadastroGerentes(RepositorioGerentes repo) {
        this.repositorio = repo;
    }
    //cadastra um gerente no repositorio, caso ainda nao tenha sido cadastrado

    public void cadastrar(Gerentes gerente)
            throws GerenteJaCadastradoException, LimiteAtingidoException {
        if (!this.repositorio.existe(gerente.getCpf())) {
            this.repositorio.inserir(gerente);
        } else {
            GerenteJaCadastradoException e;
            e = new GerenteJaCadastradoException();
            throw e;
        }
    }

    // Recebe um gerente a ser atualizado no reposit�rio
    public void atualizar(Gerentes gerente)
            throws GerenteNaoEncontradoException {
        this.repositorio.atualizar(gerente);
    }

    // Remove um gerente com um determinado identificador
    public void remover(String cpf)
            throws GerenteNaoEncontradoException {
        this.repositorio.remover(cpf);
    }

    // Procura um funcinario com um determinado identificador, e retorna o funcioanrio caso exista
    public Gerentes procurar(String cpf)
            throws GerenteNaoEncontradoException {
        return this.repositorio.procurar(cpf);
    }

    // Verifica se um dado gerente existe
    public boolean existe(String cpf) {

        return this.repositorio.existe(cpf);
    }
}

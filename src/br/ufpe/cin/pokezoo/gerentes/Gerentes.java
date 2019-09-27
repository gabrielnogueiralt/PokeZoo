package br.ufpe.cin.pokezoo.gerentes;

import br.ufpe.cin.pokezoo.funcionario.FuncionarioAbstrato;

public class Gerentes extends FuncionarioAbstrato {

    public Gerentes(String nome, String cpf, String telefone, double salario) {
        super(nome, cpf, telefone, salario);
    }
}

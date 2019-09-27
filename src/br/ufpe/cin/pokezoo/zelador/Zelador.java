package br.ufpe.cin.pokezoo.zelador;

import br.ufpe.cin.pokezoo.funcionario.FuncionarioAbstrato;

public class Zelador extends FuncionarioAbstrato {
    private int qteViveiros;
    private double comissao;

    public Zelador(String nome, String cpf, String telefone, double salario, int qteViveiros) {
        super(nome, cpf, telefone, salario);
        this.comissao = 0;
        this.qteViveiros = qteViveiros;
        this.comissao = qteViveiros*10;
    }
    
    public double getComissao() { return comissao; }
    
    public int getQteViveiros() { return qteViveiros; }

}

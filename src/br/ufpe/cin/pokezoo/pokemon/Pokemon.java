package br.ufpe.cin.pokezoo.pokemon;

import br.ufpe.cin.util.TipoNaoExisteException;

public class Pokemon {
    private int id; //Identificador unico do pokemon
    private int viveiro; //Identificador unico do Viveiro que o pokemon esta
    private String nome; //Nome da especie do pokemon
    private String tipo; //Tipo do pokemon
    private char genero; //Genero do pokemon(Macho/Femea)
    private int peso; //Peso do poquemon(Kg)
    private int altura; //Altura do Pokemon(M)


    //Construtor da classe pokemon
    public Pokemon(int id, String nome,String tipo, char genero, int peso, int altura, int viveiro) throws TipoNaoExisteException{
        //if confere se o tipo inserido e valido
        if (!tipo.equals("Inseto") && !tipo.equals("Dragão") && !tipo.equals("Lutador") && !tipo.equals("Gelo") && !tipo.equals("Fogo") && !tipo.equals("Voador") && !tipo.equals("Planta") && !tipo.equals("Fantasma") && !tipo.equals("Terrestre") && !tipo.equals("Eletrico") && !tipo.equals("Normal") && !tipo.equals("Veneno") && !tipo.equals("Psiquico") && !tipo.equals("Pedra") && !tipo.equals("Agua")) {
            TipoNaoExisteException e;
            e = new TipoNaoExisteException();
            throw e;
        }
        this.id = id;
        this.viveiro = viveiro;
        this.nome = nome;
        this.tipo = tipo;
        this.genero = genero;
        this.peso = peso;
        this.altura = altura;
    }

    public int getId() {
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getTipo(){
        return this.tipo;
    }

    public char getGenero() {
        return this.genero;
    }

    public int getAltura() {
        return this.altura;
    }

    public int getPeso() {
        return this.peso;
    }

    public int getViveiro(){
        return this.viveiro;
    }

}


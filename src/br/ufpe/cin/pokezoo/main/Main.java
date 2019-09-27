package br.ufpe.cin.pokezoo.main;

import br.ufpe.cin.util.LimiteAtingidoException;
import br.ufpe.cin.pokezoo.fachada.PokeZoo;
import br.ufpe.cin.pokezoo.funcionario.*;
import br.ufpe.cin.pokezoo.pokemon.*;
import br.ufpe.cin.pokezoo.zelador.*;
import br.ufpe.cin.pokezoo.gerentes.*;
import br.ufpe.cin.pokezoo.viveiros.*;
import br.ufpe.cin.util.TipoNaoExisteException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws LimiteAtingidoException, br.ufpe.cin.util.TipoNaoExisteException{
        Scanner in = new Scanner(System.in);
        int entrada = 0, repositorio, tipoPessoa = 0;
        Pokemon objetoPokemon;
        Viveiro objetoViveiro;
        Zelador objetoZelador;
        Gerentes objetoGerentes;
        RepositorioViveiros repoViveirosLista = new RepositorioViveirosLista();
        RepositorioViveiros repoViveirosArray = new RepositorioViveirosArray();
        RepositorioPokemons repoPokemonsArray = new RepositorioPokemonsArray();
        RepositorioPokemons repoPokemonsLista = new RepositorioPokemonsLista();
        RepositorioGerentes repoGerentesArray = new RepositorioGerentesArray();
        RepositorioGerentes repoGerentesLista = new RepositorioGerentesLista();
        RepositorioZeladores repoZeladoresArray = new RepositorioZeladoresArray();
        RepositorioZeladores repoZeladoresLista = new RepositorioZeladoresLista();
        PokeZoo pokeZoo = new PokeZoo(repoGerentesArray, repoPokemonsArray, repoViveirosArray, repoZeladoresArray);
        PokeZoo pokeLista = new PokeZoo(repoGerentesLista, repoPokemonsLista, repoViveirosLista, repoZeladoresLista);

        System.out.println("Bem vindo ao PokeZoo");

        while (entrada != 4) { 
            int selecao = 0;
            System.out.println("O que deseja fazer ?");
            System.out.println("(1) - Gerenciar Pokemons");
            System.out.println("(2) - Gerenciar Viveiros");
            System.out.println("(3) - Gerenciar Funcionarios");
            System.out.println("(4) - Sair");
            entrada = Integer.parseInt(in.next());
            switch (entrada) {
                case 1:
                    while (selecao != 5) {
                        System.out.println("Voce esta no gerenciamento de Pokemons");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Cadastrar Pokemon");
                        System.out.println("(2) - Remover Pokemon");
                        System.out.println("(3) - Procurar Pokemon");
                        System.out.println("(4) - Atualizar Pokemon");
                        System.out.println("(5) - Sair");
                        selecao = Integer.parseInt(in.next());
                        switch (selecao) {
                            //Recebe as informacoes
                            case 1:
                                System.out.print("Digite o tipo do pokemon: ");
                                String tipo = in.next();
                                String tipoViveiro;
                                tipoViveiro = tipoDoViveiro(tipo);
                                System.out.print("Digite o identificador unico do pokemon: ");
                                int id = in.nextInt();
                                System.out.print("Digite a especie do pokemon: ");
                                String nome = in.next();
                                System.out.print("Digite o genero do pokemon(M/F): ");
                                char genero = in.next().charAt(0);
                                System.out.print("Digite o peso do pokemon: ");
                                int peso = in.nextInt();
                                System.out.print("Digite a altutra do pokemon: ");
                                int altura = in.nextInt();
                                System.out.print("Digite o ID do viveiro que deseja inserir o pokemon: ");
                                int idViveiro = in.nextInt();
                                try{
                                    if (tipoViveiro.equals(pokeZoo.procurarViveiro(idViveiro).getTipo())){
                                        if (pokeZoo.procurarViveiro(idViveiro).getQuantidadePokemons() < pokeZoo.procurarViveiro(idViveiro).getCapacidade()){
                                            try {
                                                objetoPokemon = new Pokemon(id, nome, tipo, genero, peso, altura, idViveiro);
                                                pokeZoo.cadastrarPokemon(objetoPokemon);
                                                //adicionar pokemon no viveiro;
                                                pokeZoo.procurarViveiro(idViveiro).adcionaPokemon(objetoPokemon);
                                                pokeZoo.procurarViveiro(idViveiro).setQuantidadePokemons(pokeZoo.procurarViveiro(idViveiro).getCapacidade() + 1);
                                                System.out.println("\n\n------ Pokemon cadastrado com sucesso ------\n\n");
                                            } catch (PokemonJaCadastradoException | LimiteAtingidoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");

                                            }
                                        }else{
                                            System.out.println("\n\n----------------- ERRO -----------------");
                                            System.out.println("nao tem espaco \n\n");

                                        }
                                    }else{
                                        System.out.println("\n\n----------------- ERRO -----------------");
                                        System.out.println("tipos diferentes \n\n");
                                    }
                                }catch (ViveiroNaoEncontradoException e){
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }

                                //Inserir no viveiro disponivel:
                                break;

                            case 2:
                                System.out.print("Digite o identificador unico do pokemon: ");
                                int id2 = in.nextInt();
                                int idViveirox;


                                try {
                                    idViveirox = pokeZoo.procurarPokemon(id2).getViveiro();
                                    pokeZoo.procurarViveiro(idViveirox).setQuantidadePokemons(pokeZoo.procurarViveiro(idViveirox).getCapacidade() - 1);
                                    pokeZoo.removerPokemon(id2);
                                    System.out.println("\n\n------ Pokemon removido com sucesso ------\n\n");
                                } catch (PokemonNaoEncontradoException | ViveiroNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            case 3:
                                System.out.print("Digite o identificador unico do pokemon: ");
                                int id3 = in.nextInt();
                                try {
                                    Pokemon pokemonProcurado = pokeZoo.procurarPokemon(id3);
                                    System.out.println(pokemonProcurado.getId());
                                    System.out.println(pokemonProcurado.getNome());
                                    System.out.println(pokemonProcurado.getTipo());
                                    System.out.println(pokemonProcurado.getGenero());
                                    System.out.println(pokemonProcurado.getPeso());
                                    System.out.println(pokemonProcurado.getAltura());
                                } catch (PokemonNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            case 4:
                                System.out.print("Digite o identificador unico do pokemon: ");
                                int id4 = in.nextInt();
                                int idViveiroz;
                                System.out.print("Digite a nova especie do pokemon: ");
                                String nome2 = in.next();
                                System.out.print("Digite o novo tipo do pokemon: ");
                                String tipo2 = in.next();
                                String tipoViveiro2;
                                tipoViveiro2 = tipoDoViveiro(tipo2);
                                System.out.print("Digite o novo genero do pokemon(M/F): ");
                                char genero2 = in.next().charAt(0);
                                System.out.print("Digite o novo peso do pokemon: ");
                                int peso2 = in.nextInt();
                                System.out.print("Digite a nova altura do pokemon: ");
                                int altura2 = in.nextInt();
                                System.out.print("Digite o id do viveiro do pokemon: ");
                                int idViveiro2 = in.nextInt();

                                try {
                                    idViveiroz = pokeZoo.procurarPokemon(id4).getViveiro();
                                    pokeZoo.procurarViveiro(idViveiroz).setQuantidadePokemons(pokeZoo.procurarViveiro(idViveiroz).getCapacidade() - 1);
                                    objetoPokemon = new Pokemon(id4, nome2, tipo2, genero2, peso2, altura2, idViveiro2);

                                    pokeZoo.atualizarPokemon(objetoPokemon);
                                } catch (PokemonNaoEncontradoException | ViveiroNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }

                                try{
                                    if (tipoViveiro2.equals(pokeZoo.procurarViveiro(idViveiro2).getTipo())){
                                        if (pokeZoo.procurarViveiro(idViveiro2).getQuantidadePokemons() < pokeZoo.procurarViveiro(idViveiro2).getCapacidade()){
                                            try {
                                                objetoPokemon = new Pokemon(id4, nome2, tipo2, genero2, peso2, altura2, idViveiro2);
                                                pokeZoo.atualizarPokemon(objetoPokemon);
                                                System.out.println("\n\n------ Pokemon atualizado com sucesso ------\n\n");
                                                //adicionar pokemon no viveiro;
                                                pokeZoo.procurarViveiro(idViveiro2).adcionaPokemon(objetoPokemon);
                                                pokeZoo.procurarViveiro(idViveiro2).setQuantidadePokemons(pokeZoo.procurarViveiro(idViveiro2).getCapacidade() + 1);
                                            } catch ( LimiteAtingidoException | PokemonNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                        }else{
                                            System.out.println("\n\n----------------- ERRO -----------------");
                                            System.out.println("nao tem espaco \n\n");
                                        }
                                    }else{
                                        System.out.println("\n\n----------------- ERRO -----------------");
                                        System.out.println("tipos diferentes \n\n");
                                    }
                                }catch (ViveiroNaoEncontradoException e){
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }

                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcao, eu escolho voce!... Ops, parece que a opcao e invalida, tente novamente.");
                                break;
                        }
                    }
                    break;
                case 2:
                    while (selecao != 5) {
                        System.out.println("Voce esta no gerenciamento de Viveiros");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Cadastrar Viveiro");
                        System.out.println("(2) - Remover Viveiro");
                        System.out.println("(3) - Procurar Viveiro");
                        System.out.println("(4) - Atualizar Viveiro");
                        System.out.println("(5) - Sair");
                        selecao = Integer.parseInt(in.next());
                        switch (selecao) {
                            case 1: {
                                System.out.print("Digite o identificador unico do viveiro: ");
                                int id = in.nextInt();
                                System.out.print("Digite o tipo do viveiro: ");
                                String tipo = in.next();
                                System.out.print("Digite a capacidade do viveiro: ");
                                int capacidade = in.nextInt();
                                System.out.print("Digite o estoque de comida: ");
                                int estoqueComida = in.nextInt();
                                try {
                                    objetoViveiro = new Viveiro(id, tipo, capacidade, estoqueComida);
                                    try {
                                        //pokeLista.cadastrarViveiros(objetoViveiro);
                                        pokeZoo.cadastrarViveiros(objetoViveiro);
                                        System.out.println("\n\n------ Viveiro cadastrado com sucesso ------\n\n");
                                    } catch (ViveiroJaCadastradoException e) {
                                        System.out.println("\n\n----------------- ERRO -----------------");
                                        System.out.println(e.getMessage() + "\n\n");
                                    }
                                } catch (TipoNaoExisteException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                
                                break;
                            }
                            case 2: {
                                System.out.print("Digite o identificador do Viveiro: ");
                                int id = in.nextInt();
                                try {
                                    //pokeLista.removerViveiro(id);
                                    pokeZoo.removerViveiro(id);
                                    System.out.println("\n\n------ Viveiro removido com sucesso ------\n\n");
                                } catch (ViveiroNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 3: {
                                System.out.print("Digite o identificador do Viveiro: ");
                                int id = in.nextInt();                                
                                try {
                                    //Viveiro viveiro1 = pokeLista.procurarViveiro(id);
                                    Viveiro viveiro1 = pokeZoo.procurarViveiro(id);
                                    System.out.println("Id do viveiro: " + viveiro1.getId());
                                    System.out.println("Woow! Cuidado pois os pokemons que aqui habitam sao do tipo " + viveiro1.getTipo());
                                    System.out.println("Pokemons comem bastante, por isso o estoque de comida desse viveiro e de " + viveiro1.getEstoqueComida() + " pokefoods");
                                    System.out.println("A capacidade desse viveiro e de " + viveiro1.getCapacidade() + " Hmmmmm, bem que poderia caber mais...");
                                    System.out.println("\n");
                                } catch (ViveiroNaoEncontradoException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 4: {
                                System.out.print("Digite o identificador unico do viveiro que deseja atualizar: ");
                                int id = in.nextInt();
                                System.out.print("Digite o novo tipo do viveiro: ");
                                String tipo = in.next();
                                System.out.print("Digite a nova capacidade do viveiro: ");
                                int capacidade = in.nextInt();
                                System.out.print("Digite o estoque de comida: ");
                                int estoqueComida = in.nextInt();  
                                try {
                                    objetoViveiro = new Viveiro(id, tipo, capacidade, estoqueComida);
                                    try {
                                        //pokeLista.atualizarViveiro(objetoViveiro);
                                        pokeZoo.atualizarViveiro(objetoViveiro);
                                        System.out.println("\n\n------ Viveiro atualizado com sucesso ------\n\n");
                                    } catch (ViveiroNaoEncontradoException e) {
                                        System.out.println("\n\n----------------- ERRO -----------------");
                                        System.out.println(e.getMessage() + "\n\n");
                                    }
                                } catch (TipoNaoExisteException e) {
                                    System.out.println("\n\n----------------- ERRO -----------------");
                                    System.out.println(e.getMessage() + "\n\n");
                                }
                                break;
                            }
                            case 5:
                                break;
                            default:
                                System.out.println("Opcao, eu escolho voce!... Ops, parece que a opcao e invalida, tente novamente.");
                                break;
                        }
                    }
                    break;
                case 3:
                    while (tipoPessoa != 3) {
                        System.out.println("Voce esta no gerenciamento de Funcionarios");
                        System.out.println("O que deseja fazer ?");
                        System.out.println("(1) - Gerenciar Zeladores");
                        System.out.println("(2) - Gerenciar Gerentes");
                        System.out.println("(3) - Sair");
                        tipoPessoa = Integer.parseInt(in.next());
                        switch (tipoPessoa) {
                            case 1:
                                selecao = 0;
                                while (selecao != 5) {
                                    System.out.println("(1) - Cadastrar zelador");
                                    System.out.println("(2) - Remover zelador");
                                    System.out.println("(3) - Procurar zelador");
                                    System.out.println("(4) - Atualizar zelador");
                                    System.out.println("(5) - Sair");
                                    selecao = Integer.parseInt(in.next());
                                    switch (selecao) {
                                        case 1: {
                                            System.out.print("Digite o nome do zelador:");
                                            String nome = in.next();
                                            System.out.print("Digite o CPF do zelador:");
                                            String cpf = in.next();
                                            System.out.print("Digite o telefone do zelador:");
                                            String telefone = in.next();
                                            System.out.print("Digite o salario do zelador:");
                                            double salario = in.nextDouble();
                                            System.out.print("Digite a quantidade de viveiros que o zelador cuidara:");
                                            int qteViveiros = in.nextInt();
                                            objetoZelador = new Zelador(nome, cpf, telefone, salario, qteViveiros);
                                            try {
                                                //pokeZoo.cadastrarZelador(objetoZelador);
                                                pokeLista.cadastrarZelador(objetoZelador);
                                                
                                                System.out.println("\n\n------ Zelador cadastrado com sucesso ------\n\n");
                                            } catch (LimiteAtingidoException | ZeladorNaoEncontradoException | ZeladorJaCadastradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage());
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                            }
                                            
                                        }break;
                                        case 2: {
                                            System.out.println("Digite o CPF do zelador:");
                                            String cpf = in.next();
                                            try {
                                                //pokeZoo.removerZelador(cpf);
                                                pokeLista.removerZelador(cpf);
                                                System.out.println("\n\n------ Zelador removido com sucesso ------\n\n");
                                            } catch (ZeladorNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage());
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                            }
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Digite o CPF do zelador:");
                                            String cpf = in.next();
                                            try {
                                                //Zelador zeladorEncontrado = pokeZoo.procurarZelador(cpf);
                                                Zelador zeladorEncontrado = pokeLista.procurarZelador(cpf);
                                                System.out.println("Zelador: " + zeladorEncontrado.getNome());
                                                System.out.println("CPF: " + zeladorEncontrado.getCpf());
                                                System.out.println("Telefone: " + zeladorEncontrado.getTelefone());
                                                System.out.println("Salario: " + zeladorEncontrado.getSalario());
                                                System.out.println("Quantidade de viveiros: " + zeladorEncontrado.getQteViveiros());
                                                System.out.println("Comissao: " + zeladorEncontrado.getComissao());
                                                System.out.println("\n");
                                            } catch (ZeladorNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage());
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Digite o nome do zelador:");
                                            String nome = in.next();
                                            System.out.println("Digite o CPF do zelador:");
                                            String cpf = in.next();
                                            System.out.println("Digite o telefone do zelador?");
                                            String telefone = in.next();
                                            System.out.println("Digite o salario do zelador:");
                                            double salario = in.nextDouble();
                                            System.out.print("Digite a quantidade de viveiros que o zelador cuidara:");
                                            int qteViveiros = in.nextInt();
                                            objetoZelador = new Zelador(nome, cpf, telefone, salario, qteViveiros);
                                            try {
                                                //pokeZoo.atualizarZelador(objetoZelador);
                                                pokeLista.atualizarZelador(objetoZelador);
                                                System.out.println("\n\n------ Zelador atualizado com sucesso ------\n\n");
                                            } catch (ZeladorNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage());
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                            }
                                            break;
                                        }
                                        case 5:
                                            break;
                                        default:
                                            System.out.println("Opcao invalida!");
                                            break;
                                    }
                                }
                                break;
                            case 2:
                                selecao = 0;
                                while (selecao != 5) {
                                    System.out.println("(1) - Cadastrar gerente");
                                    System.out.println("(2) - Remover gerente");
                                    System.out.println("(3) - Procurar gerente");
                                    System.out.println("(4) - Atualizar gerente");
                                    System.out.println("(5) - Sair");
                                    selecao = Integer.parseInt(in.next());
//                                    selecao = in.nextInt();
                                    switch (selecao) {
                                        case 1: {
                                            System.out.print("Digite o nome do gerente:");
                                            String nome = in.next();
                                            System.out.print("Digite o CPF do gerente:");
                                            String cpf = in.next();
                                            System.out.print("Digite o telefone do gerente:");
                                            String telefone = in.next();
                                            System.out.print("Digite o salario do gerente:");
                                            double salario = in.nextDouble();
                                            objetoGerentes = new Gerentes(nome, cpf, telefone, salario);
                                            try {
                                                //  pokeZoo.cadastrarGerente(objetoGerentes);
                                                pokeLista.cadastrarGerente(objetoGerentes);
                                                System.out.println("\n\n------ Gerente cadastrado com sucesso ------\n\n");
                                            } catch (LimiteAtingidoException | GerenteNaoEncontradoException | GerenteJaCadastradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                        }break;
                                        case 2: {
                                            System.out.println("Digite o CPF do gerente:");
                                            String cpf = in.next();
                                            try {
                                               //  pokeZoo.removerGerente(cpf);
                                                pokeLista.removerGerente(cpf);
                                                System.out.println("\n\n------ Gerente removido com sucesso ------\n\n");
                                            } catch (GerenteNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 3: {
                                            System.out.println("Digite o CPF do gerente:");
                                            String cpf = in.next();
                                            try {
                                                //  Gerentes gerenteEncontrado = pokeZoo.procurarGerente(cpf);
                                                Gerentes gerenteEncontrado = pokeLista.procurarGerente(cpf);
                                                System.out.println("Gerente: " + gerenteEncontrado.getNome());
                                                System.out.println("CPF: " + gerenteEncontrado.getCpf());
                                                System.out.println("Telefone: " + gerenteEncontrado.getTelefone());
                                                System.out.println("Salario: " + gerenteEncontrado.getSalario());
                                                System.out.println("\n");
                                            } catch (GerenteNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 4: {
                                            System.out.println("Digite o nome do gerente:");
                                            String nome = in.next();
                                            System.out.println("Digite o CPF do gerente:");
                                            String cpf = in.next();
                                            System.out.println("Digite o telefone do gerente?");
                                            String telefone = in.next();
                                            System.out.println("Digite o salario do gerente:");
                                            double salario = in.nextDouble();
                                            objetoGerentes = new Gerentes(nome, cpf, telefone, salario);
                                            try {
                                                pokeZoo.atualizarGerente(objetoGerentes);
                                                System.out.println("\n\n------ Cliente atualizado com sucesso ------\n\n");
                                            } catch (GerenteNaoEncontradoException e) {
                                                System.out.println("\n\n----------------- ERRO -----------------");
                                                System.out.println(e.getMessage() + "\n\n");
                                            }
                                            break;
                                        }
                                        case 5:
                                            break;
                                        default:
                                            System.out.println("Opcao invalida!");
                                            break;
                                    }
                                }
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Opcao invalida");
                                break;
                        }
                    }
                    tipoPessoa = 0;
                    break;

                case 4:
                    break;
                default:
                    System.out.println("Opcao Invalida");
            }
        }
    }

    private static String tipoDoViveiro(String tipoDoPokemon){
        String retorna;
        if (tipoDoPokemon.equals("Agua") || tipoDoPokemon.equals("Planta") || tipoDoPokemon.equals("Inseto") || tipoDoPokemon.equals("Voador") || tipoDoPokemon.equals("Normal")){
            retorna = "Floresta";
        }else if (tipoDoPokemon.equals("Fogo") || tipoDoPokemon.equals("Pedra") || tipoDoPokemon.equals("Gelo") || tipoDoPokemon.equals("Terrestre") || tipoDoPokemon.equals("Lutador")){
            retorna = "Montanha";
        }else{
            retorna = "Magico";
        }
        return retorna;
    }
}

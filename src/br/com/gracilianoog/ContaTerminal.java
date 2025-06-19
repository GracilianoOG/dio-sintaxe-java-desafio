package br.com.gracilianoog;

import br.com.gracilianoog.model.Cliente;
import br.com.gracilianoog.model.Conta;
import br.com.gracilianoog.service.ClienteService;
import br.com.gracilianoog.service.ContaService;

import java.util.Scanner;

public class ContaTerminal {
    private static Scanner scanner = new Scanner(System.in);
    private static ContaService contaService = new ContaService();
    private static ClienteService clienteService = new ClienteService();

    public static void main(String[] args) throws Exception {
        int opcao = -1;

        while(true) {
            System.out.println("=============== Banco Pão ===============");
            System.out.println("1 - Cadastrar nova conta");
            System.out.println("2 - Cadastrar novo cliente");
            System.out.println("3 - Buscar conta");
            System.out.println("4 - Buscar cliente");
            System.out.println("5 - Depositar valor");
            System.out.println("6 - Sacar valor");
            System.out.println("7 - Sair");
            System.out.print("--> ");

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> {
                    cadastrarNovaConta();
                }

                case 2 -> {
                    cadastrarNovoCliente();
                }

                case 3 -> {
                    buscarContaPorNumero();
                }

                case 4 -> {
                    buscarClientePorNome();
                }

                case 5 -> {
                    efetuarDeposito();
                }

                case 6 -> {
                    efetuarSaque();
                }

                case 7 -> {
                    System.exit(0);
                }
            }
        }
    }

    private static void efetuarSaque() {
        System.out.println("Informe o número da conta: ");
        int numero = scanner.nextInt();

        if(contaService.buscarContaPorNumero(numero) == null) {
            System.out.println("A conta informada não existe!");
            return;
        }

        System.out.println("Informe o valor para saque: ");
        double valor = scanner.nextDouble();

        contaService.sacar(numero, valor);
    }

    private static void efetuarDeposito() {
        System.out.println("Informe o número da conta: ");
        int numero = scanner.nextInt();

        if(contaService.buscarContaPorNumero(numero) == null) {
            System.out.println("A conta informada não existe!");
            return;
        }

        System.out.println("Informe o valor a ser depositado");
        double valor = scanner.nextDouble();

        contaService.depositar(numero, valor);
    }

    private static void buscarContaPorNumero() {
        System.out.println("Informe o número da conta: ");
        int numero = scanner.nextInt();

        Conta conta = contaService.buscarContaPorNumero(numero);

        if(conta != null) {
            System.out.println("Conta encontrada!");
            System.out.println("Titular....: " + conta.getCliente().getNome());
            System.out.println("N° da conta: " + conta.getNumero());
            System.out.println("Agência....: " + conta.getAgencia());
            System.out.println("Saldo......: " + conta.getSaldo());
        } else {
            System.out.println("Conta de número " + numero + " não existe!");
        }
    }

    private static void buscarClientePorNome() {
        System.out.println("Informe o nome do cliente: ");
        String nome = scanner.next();

        Cliente cliente = clienteService.buscarClientePorNome(nome);

        if(cliente != null) {
            System.out.println("Cliente encontrado!");
            System.out.println("Nome: " + cliente.getNome());
        } else {
            System.out.println("Cliente " + nome + " não existe!");
        }
    }

    private static void cadastrarNovoCliente() {
        String nome;

        System.out.println("Informe o nome do cliente: ");
        nome = scanner.next();

        clienteService.cadastrarCliente(nome);

        System.out.println("=============== Cliente cadastrado con sucesso! ===============");
        System.out.println("Nome: " + nome);
    }

    public static void cadastrarNovaConta() {
        int numero;
        String agencia;
        double saldo;
        Cliente cliente;
        String nomeCliente;

        System.out.println("Informe o número da conta: ");
        numero = scanner.nextInt();

        System.out.println("Informe a agência: ");
        agencia = scanner.next();

        System.out.println("Informe o saldo: ");
        saldo = scanner.nextDouble();

        System.out.println("Informe o nome do cliente: ");
        nomeCliente = scanner.next();

        cliente = clienteService.buscarClientePorNome(nomeCliente);

        contaService.cadastrarConta(numero, agencia, saldo, cliente);

        System.out.println("=============== Conta cadastrada con sucesso! ===============");
        System.out.println("Nome.......: " + nomeCliente);
        System.out.println("N° da conta: " + numero);
        System.out.println("Agência....: " + agencia);
        System.out.println("Saldo......: " + saldo);
    }
}

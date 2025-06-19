package br.com.gracilianoog.service;

import br.com.gracilianoog.DAO.ContaDAO;
import br.com.gracilianoog.model.Cliente;
import br.com.gracilianoog.model.Conta;

public class ContaService {
    private final ContaDAO contaDAO = new ContaDAO();

    public void cadastrarConta(int numero, String agencia, double saldo, Cliente cliente) {
        Conta conta = new Conta(numero, agencia, saldo, cliente);
        this.contaDAO.salvar(conta);
    }

    public Conta buscarContaPorNumero(int numero) {
        return contaDAO.buscarContaPorNumero(numero);
    }

    public void depositar(int numero, double valorDeposito) {
        Conta conta = contaDAO.buscarContaPorNumero(numero);

        if(conta == null) {
            throw new IllegalArgumentException("A conta com o número " + numero + " não existe!");
        }

        conta.setSaldo(conta.getSaldo() + valorDeposito);
    }

    public void sacar(int numero, double valorSaque) {
        Conta conta = contaDAO.buscarContaPorNumero(numero);

        if(conta == null) {
            throw new IllegalArgumentException("A conta com o número " + numero + " não existe!");
        }

        if(valorSaque > conta.getSaldo()) {
            throw new IllegalArgumentException("O saldo deve ser menor ou igual ao saldo disponível!");
        }

        conta.setSaldo(conta.getSaldo() - valorSaque);
    }
}

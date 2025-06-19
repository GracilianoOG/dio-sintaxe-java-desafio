package br.com.gracilianoog.model;

public class Conta {
    private int numero;
    private String agencia;
    private double saldo;
    private Cliente cliente;

    public Conta(int numero, String agencia, double saldo, Cliente cliente) {
        this.setNumero(numero);
        this.setAgencia(agencia);
        this.setSaldo(saldo);
        this.setCliente(cliente);
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0) {
            throw new IllegalArgumentException("O saldo deve ser um valor positivo!");
        }
        this.saldo = saldo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}

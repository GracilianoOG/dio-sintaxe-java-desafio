package br.com.gracilianoog.DAO;

import br.com.gracilianoog.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ContaDAO {
    private final List<Conta> contas;

    public ContaDAO() {
        this.contas = new ArrayList<>();
    }

    public void salvar(Conta conta) {
        this.contas.add(conta);
    }

    public Conta buscarContaPorNumero(int numero) {
        for(Conta conta : this.contas) {
            if(conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }
}

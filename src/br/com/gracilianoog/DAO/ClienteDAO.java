package br.com.gracilianoog.DAO;

import br.com.gracilianoog.model.Cliente;
import br.com.gracilianoog.model.Conta;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private final List<Cliente> clientes;

    public ClienteDAO() {
        this.clientes = new ArrayList<>();
    }

    public void salvar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public Cliente buscarClientePorNome(String nome) {
        for(Cliente cliente : this.clientes) {
            if(cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }
}

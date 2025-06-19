package br.com.gracilianoog.service;

import br.com.gracilianoog.DAO.ClienteDAO;
import br.com.gracilianoog.model.Cliente;

public class ClienteService {
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente cadastrarCliente(String nome) {
        Cliente cliente = new Cliente(nome);
        clienteDAO.salvar(cliente);
        return cliente;
    }

    public Cliente buscarClientePorNome(String nome) {
        return clienteDAO.buscarClientePorNome(nome);
    }
}

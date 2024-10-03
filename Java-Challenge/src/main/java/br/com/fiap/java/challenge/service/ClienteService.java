package br.com.fiap.java.challenge.service;

import br.com.fiap.java.challenge.dao.ClienteDao;
import br.com.fiap.java.challenge.model.Cliente;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClienteService {


    private ClienteDao clienteDao = new ClienteDao();

    public ClienteService() throws SQLException, IOException {
    }
    public List<Cliente> listar(){
        return clienteDao.listar();
    }
    public Cliente buscar(int codigo) throws SQLException {
        return clienteDao.buscarPorId(codigo);
    }

}

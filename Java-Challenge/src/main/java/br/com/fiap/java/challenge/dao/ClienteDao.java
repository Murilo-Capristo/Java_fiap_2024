package br.com.fiap.java.challenge.dao;

import br.com.fiap.java.challenge.model.Cliente;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private Connection conexao;
    public ClienteDao() throws IOException, SQLException {
        this.conexao = ConnectionFactory.getConnection();
    }
    public Cliente buscarPorId(int codigo) throws SQLException {
        Cliente cliente = new Cliente();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("select * from cliente where id_cliente = ?");
            comandoSql.setInt(1, codigo);
            ResultSet resultado = comandoSql.executeQuery();
            if(resultado.next()){
                cliente.setId(resultado.getInt(1));
                cliente.setCpf(resultado.getString(2));
                cliente.setSenha(resultado.getString(2));
                cliente.setNome(resultado.getString(4));
                cliente.setEmail(resultado.getString(5));
                cliente.setTelefone(resultado.getString(6));
            }
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }
    public List<Cliente> listar(){
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement comandoSql = null;
        try{
            comandoSql = conexao.prepareStatement("SELECT * FROM Cliente");
            ResultSet resultado = comandoSql.executeQuery();
            while(resultado.next()){
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt(1));
                cliente.setCpf(resultado.getString(2));
                cliente.setSenha(resultado.getString(2));
                cliente.setNome(resultado.getString(4));
                cliente.setEmail(resultado.getString(5));
                cliente.setTelefone(resultado.getString(6));
                clientes.add(cliente);
            }
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return clientes;
    }
}

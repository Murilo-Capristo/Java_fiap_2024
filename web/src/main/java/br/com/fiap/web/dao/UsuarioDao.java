package br.com.fiap.web.dao;

import br.com.fiap.web.model.Usuario;
import br.com.fiap.web.senhas.PasswordPBKDF2;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao {
    private Connection conexao;

    public UsuarioDao() {
        try {
            this.conexao = ConnectionFactory.obterConexao();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void cadastrar(Usuario usuario) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = PasswordPBKDF2.generateSalt();
        String senhaHash = PasswordPBKDF2.hashPassword(usuario.getSenha(), salt);
        PreparedStatement comandoSql = null;
        try{
            String sql = "insert into tbl_usuario(nome, login, senha)" +
                    " values(?,?,?)";
            comandoSql = conexao.prepareStatement(sql);
            comandoSql.setString(1, usuario.getNome());
            comandoSql.setString(2, usuario.getLogin());
            comandoSql.setString(3, senhaHash);
            comandoSql.executeUpdate();
            //conexao.close();
            comandoSql.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void verificarLogin(Usuario usuario) {


    }
}

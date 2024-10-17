package br.com.fiap.web.service;

import br.com.fiap.web.dao.UsuarioDao;
import br.com.fiap.web.dto.ProdutoRequestDto;
import br.com.fiap.web.model.Produto;
import br.com.fiap.web.model.Usuario;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class UsuarioService {
    UsuarioDao usuarioDao = new UsuarioDao();
    public void cadastrar(Usuario usuario) throws NoSuchAlgorithmException, InvalidKeySpecException {
        usuarioDao.cadastrar(usuario);
    }
}

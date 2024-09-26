package br.com.fiap.web.service;

import br.com.fiap.web.dao.ProdutoDao;
import br.com.fiap.web.model.Produto;

import java.util.List;

public class ProdutoService {
    private ProdutoDao produtodao = new ProdutoDao();

    public List<Produto> listar() {
        return produtodao.listar();
    }
}

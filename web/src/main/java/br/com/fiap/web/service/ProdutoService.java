package br.com.fiap.web.service;

import br.com.fiap.web.dao.ProdutoDao;
import br.com.fiap.web.model.Produto;

import java.io.IOException;
import java.util.List;

public class ProdutoService {
    private ProdutoDao produtodao = new ProdutoDao();

    public ProdutoService() throws IOException {
    }

    public List<Produto> listar() {
        return produtodao.listar();
    }

    //Retoirnar um unico produto -> buscarPorId

    public Produto buscarPorId(int codigo) {
        return produtodao.buscarPorId(codigo);
    }

    public Produto cadastrar(Produto produto){
        return produtodao.inserir(produto);
    }
}

package br.com.fiap.web.resource;
import br.com.fiap.web.model.Produto;
import br.com.fiap.web.service.ProdutoService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.util.List;

@Path("/produtos")

public class ProdutoResource {
    private ProdutoService service = new ProdutoService();

    public ProdutoResource() throws IOException {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Produto> listar() {
        return service.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Produto buscar(@PathParam("id") int codigo) {
        return service.buscarPorId(codigo);
    }
}

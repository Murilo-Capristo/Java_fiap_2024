package br.com.fiap.web.resource;
import br.com.fiap.web.model.Produto;
import br.com.fiap.web.service.ProdutoService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Produto produto, @Context UriInfo uriInfo){
        service.cadastrar(produto);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        builder.path(Integer.toString(produto.getCodigo()));
        return Response.created(builder.build()).build();
    }
}

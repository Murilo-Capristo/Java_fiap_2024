package br.com.fiap.java.challenge.resource;

import br.com.fiap.java.challenge.model.Cliente;
import br.com.fiap.java.challenge.service.ClienteService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@Path("/clientes")

public class ClienteResource {
    private ClienteService clienteService= new ClienteService();

    public ClienteResource() throws SQLException, IOException {
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> listar(){
        return clienteService.listar();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente buscar(@PathParam("id") int codigo) throws SQLException {
        return clienteService.buscar(codigo);
    }
}

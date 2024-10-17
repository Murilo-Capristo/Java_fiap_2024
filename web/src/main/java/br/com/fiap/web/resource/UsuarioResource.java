package br.com.fiap.web.resource;
import br.com.fiap.web.model.Usuario;

import br.com.fiap.web.service.UsuarioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

@Path("/usuario")
public class UsuarioResource {

    private UsuarioService service = new UsuarioService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrar(Usuario usuario, @Context UriInfo uriInfo) throws NoSuchAlgorithmException, InvalidKeySpecException {
        service.cadastrar(usuario);
        UriBuilder builder = uriInfo.getAbsolutePathBuilder();
        return Response.status(Response.Status.CREATED).entity(builder.build()).build();
    }
}

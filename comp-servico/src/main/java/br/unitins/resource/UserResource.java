package br.unitins.resource;

import br.unitins.dto.UserDTO;
import br.unitins.dto.UserResponseDTO;
import br.unitins.service.UserService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserService userService;

    @POST
    public Response insert(UserDTO userDTO){
        UserResponseDTO retorno = userService.insert(userDTO);
        return Response.status(Status.CREATED).entity(retorno).build();
    }
    
}

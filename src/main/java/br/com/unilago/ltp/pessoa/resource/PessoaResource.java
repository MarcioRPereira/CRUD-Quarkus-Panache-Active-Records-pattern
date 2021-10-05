package br.com.unilago.ltp.pessoa.resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.unilago.ltp.pessoa.entity.Pessoa;

@Path("/pessoa")
public class PessoaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> getAll(){
        return Pessoa.listAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Pessoa getById(@PathParam("id") Long id){
        return Pessoa.findById(id);
    }

    @GET
    @Path("/busca")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Pessoa> buscarPorNome(@QueryParam("nome") String nome){
        if(nome == null){
            throw new BadRequestException("Enviar o parâmetro nome");
        }
        return Pessoa.findByName(nome);
    }


    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Pessoa pessoa){
        pessoa.persist();
        return Response.status(Status.CREATED).entity(pessoa).build();
    }
    
}
package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.EvolucaoController;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Stateless
@Path("evolucao")
public class EvolucaoResource {

    @Inject
    private EvolucaoController controller;

    @GET
    @Path("/anos/{ano1}/{ano2}")
    public Response anos(@PathParam("ano1") int ano1, @PathParam("ano2") int ano2) {
        return Response.ok().entity(controller.anos(ano1, ano2)).build();
    }

}

package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.AreaDeAtuacaoController;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("atuacao")
@Stateless
public class AreaDeAtuacaoResource {

    @Inject
    private AreaDeAtuacaoController controller;

    @GET
    @Path("/todas")
    public Response todasAsAreas() {
        return Response
                .ok()
                .entity(controller.todasAsAreas().toString())
                .build();
    }

    @GET
    @Path("/{area}")
    public Response buscaPorArea(@PathParam("area") String area) {
        return Response
                .ok()
                .entity(controller.buscarPorArea(area))
                .build();
    }
}

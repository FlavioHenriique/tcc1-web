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
    public Response anos2(@PathParam("ano1") int ano1, @PathParam("ano2") int ano2) {
        return Response.ok().entity(controller.anos2(ano1, ano2, "")).build();
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{funcao}")
    public Response anos2(@PathParam("ano1") int ano1, @PathParam("ano2") int ano2,
            @PathParam("funcao") String funcao) {
        return Response.ok().entity(controller.anos2(ano1, ano2, funcao)).build();
    }

    @GET
    @Path("/semestres/{semestre1}/{semestre2}/{funcao}")
    public Response semestres(@PathParam("semestre1") int semestre1, @PathParam("semestre2") int semestre2,
            @PathParam("funcao") String funcao) {
        return Response.ok().entity(controller.semestres2(semestre1, semestre2, funcao)).build();
    }

    @GET
    @Path("/semestres/{semestre1}/{semestre2}/")
    public Response semestres(@PathParam("semestre1") int semestre1, @PathParam("semestre2") int semestre2) {
        return Response.ok().entity(controller.semestres2(semestre1, semestre2, "")).build();
    }

    @GET
    @Path("/a/{a}/{b}/{funcao}")
    public Response mesesComFuncao(@PathParam("a") int mes1, @PathParam("b") int mes2,
            @PathParam("funcao") String funcao) {
        return Response.ok().entity(controller.meses2(mes1, mes2, funcao)).build();
    }

    @GET
    @Path("/a/{a}/{b}/")
    public Response meses(@PathParam("a") int mes1, @PathParam("b") int mes2) {
        return Response.ok().entity(controller.meses2(mes1, mes2, "")).build();
    }
}

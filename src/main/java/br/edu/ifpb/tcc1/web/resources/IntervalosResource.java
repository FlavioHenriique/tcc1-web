package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.IntervaloController;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("intervalo")
@Stateless
public class IntervalosResource {

    @Inject
    private IntervaloController intervalo;

    @GET
    @Path("/anos/{ano1}/{ano2}")
    public Response buscaPorano(@PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2) {
        return Response
                .ok()
                .entity(intervalo.buscaPorAno(ano1, ano2))
                .build();
    }

    @GET
    @Path("semestre/{sem}")
    public Response buscaPorSemestre(@PathParam("sem") int semestre) {
        return Response
                .ok()
                .entity(intervalo.buscaPorSemestre(semestre))
                .build();
    }

    @GET
    @Path("mes/{mes1}/{mes2}")
    public Response buscaPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2) {
        return Response
                .ok()
                .entity(intervalo.buscaPorMes(mes1, mes2))
                .build();
    }

    @GET
    @Path("anos/{funcao}/{ano1}/{ano2}")
    public Response buscaSubfuncaoAno(@PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("funcao") String funcao) {
        return Response
                .ok()
                .entity(intervalo.buscaSubfuncaoPorAno(ano1, ano2, funcao))
                .build();
    }

    @GET
    @Path("semestre/{funcao}/{sem}")
    public Response buscaSubfuncaoAno(@PathParam("sem") int semestre,
            @PathParam("funcao") String funcao) {
        return Response
                .ok()
                .entity(intervalo.buscaSubfuncaoPorSemestre(semestre, funcao))
                .build();
    }

    @GET
    @Path("mes/{funcao}/{mes1}/{mes2}")
    public Response buscaPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao) {
        return Response
                .ok()
                .entity(intervalo.buscSubfuncaoPorMes(mes1, mes2, funcao))
                .build();
    }
}

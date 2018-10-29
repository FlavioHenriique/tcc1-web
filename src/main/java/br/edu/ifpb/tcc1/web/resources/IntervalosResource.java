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
    @Path("/ano/{ano1}/{ano2}")
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
    @Path("ano/{ano1}/{ano2}/{funcao}")
    public Response buscaSubfuncaoAno(@PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("funcao") String funcao) {
        return Response
                .ok()
                .entity(intervalo.buscaSubfuncaoPorAno(ano1, ano2, funcao))
                .build();
    }

    @GET
    @Path("semestre/{sem}/{funcao}")
    public Response buscaSubfuncaoSemestre(@PathParam("sem") int semestre,
            @PathParam("funcao") String funcao) {
        return Response
                .ok()
                .entity(intervalo.buscaSubfuncaoPorSemestre(semestre, funcao))
                .build();
    }

    @GET
    @Path("mes/{mes1}/{mes2}/{funcao}")
    public Response buscaSubfuncaoPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao) {
        return Response
                .ok()
                .entity(intervalo.buscSubfuncaoPorMes(mes1, mes2, funcao))
                .build();
    }

    @GET
    @Path("ano/{ano1}/{ano2}/{funcao}/{subfuncao}")
    public Response programaPorAno(@PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2) {

        return Response
                .ok()
                .entity(intervalo.buscaProgramaPorAno(ano1, ano2, funcao, subfuncao))
                .build();
    }

    @GET
    @Path("semestre/{sem}/{funcao}/{subfuncao}")
    public Response programaPorSemestre(@PathParam("sem") int semestre,
            @PathParam("funcao") String funcao, @PathParam("subfuncao") String subfuncao) {
        return Response
                .ok()
                .entity(intervalo.buscaProgramaPorSemestre(semestre, funcao, subfuncao))
                .build();
    }

    @GET
    @Path("mes/{mes1}/{mes2}/{funcao}/{subfuncao}")
    public Response programaPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao) {
        return Response
                .ok()
                .entity(intervalo.buscaProgramaPorMes(mes1, mes2, funcao, subfuncao))
                .build();
    }

    @GET
    @Path("ano/{ano1}/{ano2}/{funcao}/{subfuncao}/{programa}")
    public Response acaoPorAno(@PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao, @PathParam("programa") String programa,
            @PathParam("ano1") int ano1, @PathParam("ano2") int ano2) {

        return Response
                .ok()
                .entity(intervalo.buscaAcaoPorAno(
                        ano1, ano2, funcao, subfuncao, programa
                ))
                .build();
    }

    @GET
    @Path("semestre/{sem}/{funcao}/{subfuncao}/{programa}")
    public Response acaoPorSemestre(@PathParam("sem") int semestre,
            @PathParam("funcao") String funcao, @PathParam("subfuncao") String subfuncao,
            @PathParam("programa") String programa) {
        return Response
                .ok()
                .entity(intervalo.buscaAcaoPorSemestre(semestre, funcao, subfuncao, programa))
                .build();
    }

    @GET
    @Path("mes/{mes1}/{mes2}/{funcao}/{subfuncao}/{programa}")
    public Response acaoPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao, @PathParam("programa") String programa) {
        return Response
                .ok()
                .entity(intervalo.buscaAcaoPorMes(mes1, mes2, funcao, subfuncao, programa))
                .build();
    }
}

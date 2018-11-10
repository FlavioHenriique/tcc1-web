package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.IntervaloController;
import br.edu.ifpb.tcc1.web.graficos.Grafico;
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
        return verificaConteudo(intervalo.buscaPorAno(ano1, ano2));
    }

    @GET
    @Path("semestre/{sem}")
    public Response buscaPorSemestre(@PathParam("sem") int semestre) {
        return verificaConteudo(intervalo.buscaPorSemestre(semestre));
    }

    @GET
    @Path("mes/{mes1}/{mes2}")
    public Response buscaPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2) {
        return verificaConteudo(intervalo.buscaPorMes(mes1, mes2));
    }

    @GET
    @Path("ano/{ano1}/{ano2}/{funcao}")
    public Response buscaSubfuncaoAno(@PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("funcao") String funcao) {
        return verificaConteudo(intervalo.buscaSubfuncaoPorAno(ano1, ano2, funcao));
    }

    @GET
    @Path("semestre/{sem}/{funcao}")
    public Response buscaSubfuncaoSemestre(@PathParam("sem") int semestre,
            @PathParam("funcao") String funcao) {
        return verificaConteudo(intervalo.buscaSubfuncaoPorSemestre(semestre, funcao));
    }

    @GET
    @Path("mes/{mes1}/{mes2}/{funcao}")
    public Response buscaSubfuncaoPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao) {
        return verificaConteudo(intervalo.buscSubfuncaoPorMes(mes1, mes2, funcao));
    }

    @GET
    @Path("ano/{ano1}/{ano2}/{funcao}/{subfuncao}")
    public Response programaPorAno(@PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2) {
        return verificaConteudo(intervalo.buscaProgramaPorAno(ano1, ano2, funcao, subfuncao));
    }

    @GET
    @Path("semestre/{sem}/{funcao}/{subfuncao}")
    public Response programaPorSemestre(@PathParam("sem") int semestre,
            @PathParam("funcao") String funcao, @PathParam("subfuncao") String subfuncao) {
        return verificaConteudo(intervalo.buscaProgramaPorSemestre(semestre, funcao, subfuncao));
    }

    @GET
    @Path("mes/{mes1}/{mes2}/{funcao}/{subfuncao}")
    public Response programaPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao) {
        return verificaConteudo(intervalo.buscaProgramaPorMes(mes1, mes2, funcao, subfuncao));
    }

    @GET
    @Path("ano/{ano1}/{ano2}/{funcao}/{subfuncao}/{programa}")
    public Response acaoPorAno(@PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao, @PathParam("programa") String programa,
            @PathParam("ano1") int ano1, @PathParam("ano2") int ano2) {
        return verificaConteudo(intervalo.buscaAcaoPorAno(ano1, ano2, funcao, subfuncao, programa));
    }

    @GET
    @Path("semestre/{sem}/{funcao}/{subfuncao}/{programa}")
    public Response acaoPorSemestre(@PathParam("sem") int semestre,
            @PathParam("funcao") String funcao, @PathParam("subfuncao") String subfuncao,
            @PathParam("programa") String programa) {
        return verificaConteudo(intervalo.buscaAcaoPorSemestre(semestre, funcao, subfuncao, programa));

    }

    @GET
    @Path("mes/{mes1}/{mes2}/{funcao}/{subfuncao}/{programa}")
    public Response acaoPorMes(@PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao, @PathParam("programa") String programa) {
        return verificaConteudo(intervalo.buscaAcaoPorMes(mes1, mes2, funcao, subfuncao, programa));

    }

    private Response verificaConteudo(Grafico grafico) {
        return (grafico.getData().isEmpty())
                ? Response.noContent().build()
                : Response.ok().entity(grafico).build();
    }
}

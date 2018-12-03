package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.UnidadesController;
import br.edu.ifpb.tcc1.web.graficos.GraficoIntervalos;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("unidade")
@Stateless
@Produces(MediaType.APPLICATION_JSON)
public class UnidadesResource {

    @Inject
    private UnidadesController controller;

    @GET
    @Path("/ano/{ano1}/{ano2}")
    public Response orgaoSuperiorPorAno(@PathParam("ano1") int ano1, @PathParam("ano2") int ano2) {
        GraficoIntervalos grafico = controller.orgaoSuperiorPorAno(ano1, ano2);
        return response(grafico);
    }

    @GET
    @Path("/ano/{ano1}/{ano2}/{orgaoSuperior}")
    public Response orgaoPorAno(@PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("orgaoSuperior") String orgaoSuperior) {
        GraficoIntervalos grafico = controller.orgaoPorAno(ano1, ano2, orgaoSuperior);
        return response(grafico);
    }

    @GET
    @Path("/ano/{ano1}/{ano2}/{orgaoSuperior}/{orgao}")
    public Response unidadesPorAno(@PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("orgaoSuperior") String orgaoSuperior,
            @PathParam("orgao") String orgao) {
        GraficoIntervalos grafico = controller.unidadesPorAno(ano1, ano2, orgaoSuperior, orgao);
        return response(grafico);
    }

    @GET
    @Path("/semestre/{semestre}")
    public Response orgaoSuperiorPorSemestre(@PathParam("semestre") int semestre) {
        GraficoIntervalos grafico = controller.orgaoSuperiorPorSemestre(semestre);
        return response(grafico);
    }

    @GET
    @Path("/semestre/{semestre}/{orgaoSuperior}")
    public Response orgaoPorSemestre(@PathParam("semestre") int semestre,
            @PathParam("orgaoSuperior") String orgaoSuperior) {
        GraficoIntervalos grafico = controller.orgaoPorSemestre(semestre, orgaoSuperior);
        return response(grafico);
    }

    @GET
    @Path("/semestre/{semestre}/{orgaoSuperior}/{orgao}")
    public Response unidadesPorSemestre(@PathParam("semestre") int semestre,
            @PathParam("orgaoSuperior") String orgaoSuperior,
            @PathParam("orgao") String orgao) {
        GraficoIntervalos grafico = controller.unidadesPorSemestre(semestre, orgaoSuperior, orgao);
        return response(grafico);
    }

    @GET
    @Path("/mes/{mes1}/{mes2}")
    public Response orgaoSuperiorPorMes(@PathParam("mes1") int mes1, @PathParam("mes2") int mes2) {
        GraficoIntervalos grafico = controller.orgaoSuperiorPorMeses(mes1, mes2);
        return response(grafico);
    }

    @GET
    @Path("/mes/{mes1}/{mes2}/{orgaoSuperior}")
    public Response orgaoPorMes(@PathParam("mes1") int mes1, @PathParam("mes2") int mes2,
            @PathParam("orgaoSuperior") String orgaoSuperior) {
        GraficoIntervalos grafico = controller.orgaoPorMes(mes1, mes2, orgaoSuperior);
        return response(grafico);
    }

    @GET
    @Path("/mes/{mes1}/{mes2}/{orgaoSuperior}/{orgao}")
    public Response unidadesPorMes(@PathParam("mes1") int mes1, @PathParam("mes2") int mes2,
            @PathParam("orgaoSuperior") String orgaoSuperior, @PathParam("orgao") String orgao) {
        GraficoIntervalos grafico = controller.unidadesPorMeses(mes1, mes2, orgaoSuperior, orgao);
        return response(grafico);
    }

    private Response response(GraficoIntervalos grafico) {
        return (grafico.getData().isEmpty()) ? Response.noContent().build()
                : Response.ok().entity(grafico).build();
    }
}

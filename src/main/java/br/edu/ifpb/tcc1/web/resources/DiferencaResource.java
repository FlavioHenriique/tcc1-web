package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.DiferencaController;
import br.edu.ifpb.tcc1.web.model.Grafico;
import br.edu.ifpb.tcc1.web.model.GraficoDiferenca;
import br.edu.ifpb.tcc1.web.model.GraficoDiferenca2;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Stateless
@Path("diferenca")
public class DiferencaResource {

    @Inject
    private DiferencaController controller;

    @GET
    @Path("/anos/{ano1}/{ano2}")
    public Response funcoesAnos(@PathParam("ano1") int ano1, @PathParam("ano2") int ano2) {
        return verificaConteudo(controller.funcoesAnos(ano1, ano2));
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{funcao}")
    public Response funcoesAnos(@PathParam("ano1") int ano1, @PathParam("ano2") int ano2,
            @PathParam("funcao") String funcao) {
        return verificaConteudo(controller.funcoesAnos(ano1, ano2, funcao));
    }

    @GET
    @Path("/semestres/{semestre1}/{semestre2}")
    public Response funcoesSemestres(@PathParam("semestre1") int semestre1, @PathParam("semestre2") int semestre2) {
        return verificaConteudo(controller.funcoesSemestres(semestre1, semestre2, ""));
    }

    @GET
    @Path("/semestres/{semestre1}/{semestre2}/{funcao}")
    public Response funcoesSemestres(@PathParam("semestre1") int semestre1, @PathParam("semestre2") int semestre2,
            @PathParam("funcao") String funcao) {
        return verificaConteudo(controller.funcoesSemestres(semestre1, semestre2, funcao));
    }

    @GET
    @Path("/meses/{mes1}/{mes2}")
    public Response funcoesMeses(@PathParam("mes1") int mes1, @PathParam("mes2") int mes2) {
        return verificaConteudo(controller.funcoesMeses(mes1, mes2, ""));
    }

    @GET
    @Path("/meses/{mes1}/{mes2}/{semestre}")
    public Response funcoesMeses(@PathParam("mes1") int mes1, @PathParam("mes2") int mes2,
            @PathParam("semestre") String semestre) {
        return verificaConteudo(controller.funcoesMeses(mes1, mes2, semestre));
    }

    private Response verificaConteudo(GraficoDiferenca grafico) {
        return (grafico.getValoresPrimeiroIntervalo().isEmpty()
                && grafico.getValoresSegundoIntervalo().isEmpty())
                ? Response.noContent().build()
                : Response.ok().entity(grafico).build();
    }
}

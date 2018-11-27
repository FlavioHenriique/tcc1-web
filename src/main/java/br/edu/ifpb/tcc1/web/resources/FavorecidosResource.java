package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.FavorecidoController;
import br.edu.ifpb.tcc1.web.graficos.Grafico;
import br.edu.ifpb.tcc1.web.graficos.ResultadoTabela;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Stateless
@Path("favorecidos")
public class FavorecidosResource {

    @Inject
    private FavorecidoController controller;

    @GET
    @Path("/nome/{nome}")
    public Response favorecidosPorNome(@PathParam("nome") String nome) {

        List<String> lista = controller.favorecidosPorNome(nome);
        if (lista.isEmpty()) {
            return Response.noContent().build();
        } else {
            JSONObject json = new JSONObject();
            json.put("favorecidos", lista);
            json.put("oi", "oi");
            return Response.ok().entity(json.toString()).build();
        }
    }

    @GET
    @Path("/cnpj/{cnpj}")
    public Response favorecidosPorCNPJ(@PathParam("cnpj") String cnpj) {

        //CNPJ para teste: 01724109000134
        List<String> lista = controller.favorecidosPorCNPJ(cnpj);
        if (lista.isEmpty()) {
            return Response.noContent().build();
        } else {
            JSONObject json = new JSONObject();
            json.put("favorecidos", lista);
            json.put("oi", "oi");
            return Response.ok().entity(json.toString()).build();
        }
    }

    // ANOS
    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}")
    public Response funcoesPorAno(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2) {

        ResultadoTabela rt = controller.funcaoFavorecidosAnos(nome, ano1, ano2);
        if (rt.getDados().isEmpty()) {
            return Response.noContent().build();
        } else {
            return Response.ok().entity(rt).build();
        }
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}/{funcao}")
    public Response subfuncoesPorAno(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("funcao") String funcao) {
        Grafico grafico = controller.subfuncaoFavorecidosAnos(nome, ano1, ano2, funcao);
        return response(grafico);
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}/{funcao}/{subfuncao}")
    public Response programasPorAno(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao) {
        Grafico grafico = controller.programaFavorecidosAnos(nome, ano1, ano2, funcao, subfuncao);
        return response(grafico);
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}/{funcao}/{subfuncao}/{programa}")
    public Response acoesPorAno(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("subfuncao") String subfuncao,
            @PathParam("programa") String programa, @PathParam("funcao") String funcao) {

        Grafico grafico = controller.acoesFavorecidosAnos(nome, ano1, ano2, funcao,
                subfuncao, programa);
        return response(grafico);
    }

    // SEMESTRE
    @GET
    @Path("/semestres/{semestre}/{nome}")
    public Response funcoesPorSemestre(@PathParam("nome") String nome,
            @PathParam("semestre") int semestre) {
        Grafico grafico = controller.funcaoFavorecidosSemestre(nome, semestre);
        return response(grafico);
    }

    @GET
    @Path("/semestres/{semestre}/{nome}/{funcao}")
    public Response subfuncoesPorSemestre(@PathParam("nome") String nome,
            @PathParam("semestre") int semestre, @PathParam("funcao") String funcao) {
        Grafico grafico = controller.subfuncaoFavorecidosSemestre(nome, semestre, funcao);
        return response(grafico);
    }

    @GET
    @Path("/semestres/{semestre}/{nome}/{funcao}/{subfuncao}")
    public Response programasPorSemestre(@PathParam("nome") String nome, @PathParam("semestre") int semestre,
            @PathParam("funcao") String funcao, @PathParam("subfuncao") String subfuncao) {
        Grafico grafico = controller.programaFavorecidosSemestre(nome, semestre, funcao, subfuncao);
        return response(grafico);
    }

    @GET
    @Path("/semestres/{semestre}/{nome}/{funcao}/{subfuncao}/{programa}")
    public Response acoesPorSemestre(@PathParam("nome") String nome, @PathParam("semestre") int semestre,
            @PathParam("subfuncao") String subfuncao, @PathParam("programa") String programa,
            @PathParam("funcao") String funcao) {
        Grafico grafico = controller.acoesFavorecidosSemestre(nome, semestre, funcao,
                subfuncao, programa);
        return response(grafico);
    }
// MESES

    @GET
    @Path("/meses/{mes1}/{mes2}/{nome}")
    public Response funcoesPorMeses(@PathParam("nome") String nome, @PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2) {
        Grafico grafico = controller.funcaoFavorecidosMeses(nome, mes1, mes2);
        return response(grafico);
    }

    @GET
    @Path("/meses/{mes1}/{mes2}/{nome}/{funcao}")
    public Response subfuncoesPorMeses(@PathParam("nome") String nome, @PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao) {
        Grafico grafico = controller.subfuncaoFavorecidosMeses(nome, mes1, mes2, funcao);
        return response(grafico);
    }

    @GET
    @Path("/meses/{mes1}/{mes2}/{nome}/{funcao}/{subfuncao}")
    public Response programasPorMeses(@PathParam("nome") String nome, @PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao) {
        Grafico grafico = controller.programaFavorecidosMeses(nome, mes1, mes2, funcao, subfuncao);
        return response(grafico);
    }

    @GET
    @Path("/meses/{mes1}/{mes2}/{nome}/{funcao}/{subfuncao}/{programa}")
    public Response acoesPorMeses(@PathParam("nome") String nome, @PathParam("mes1") int mes1,
            @PathParam("mes2") int mes2, @PathParam("subfuncao") String subfuncao,
            @PathParam("programa") String programa, @PathParam("funcao") String funcao) {

        Grafico grafico = controller
                .acoesFavorecidosMeses(nome, mes1, mes2, funcao, subfuncao, programa);
        return response(grafico);
    }

    public Response response(Grafico grafico) {
        return (grafico.getData().isEmpty())
                ? Response.noContent().build()
                : Response.ok().entity(grafico).build();
    }
}

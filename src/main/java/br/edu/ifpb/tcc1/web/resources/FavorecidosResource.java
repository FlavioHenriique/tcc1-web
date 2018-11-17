package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.FavorecidoController;
import br.edu.ifpb.tcc1.web.graficos.Grafico;
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

    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}")
    public Response funcoesPorNome(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2) {
        Grafico grafico = controller.funcaoFavorecidos(nome, ano1, ano2);
        return response(grafico);
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}/{funcao}")
    public Response subfuncoesPorNome(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("funcao") String funcao) {
        Grafico grafico = controller.subfuncaoFavorecidos(nome, ano1, ano2, funcao);
        return response(grafico);
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}/{funcao}/{subfuncao}")
    public Response programasPorNome(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("funcao") String funcao,
            @PathParam("subfuncao") String subfuncao) {
        Grafico grafico = controller.programaFavorecidos(nome, ano1, ano2, funcao, subfuncao);
        return response(grafico);
    }

    @GET
    @Path("/anos/{ano1}/{ano2}/{nome}/{funcao}/{subfuncao}/{programa}")
    public Response acoesPorNome(@PathParam("nome") String nome, @PathParam("ano1") int ano1,
            @PathParam("ano2") int ano2, @PathParam("subfuncao") String subfuncao,
            @PathParam("programa") String programa, @PathParam("funcao") String funcao) {
        Grafico grafico = controller.acoesFavorecidos(nome, ano1, ano2, funcao,
                subfuncao, programa);
        return response(grafico);
    }

    public Response response(Grafico grafico) {
        return (grafico.getData().isEmpty())
                ? Response.noContent().build()
                : Response.ok().entity(grafico).build();
    }
}

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
    @Path("/{nome}")
    public Response funcoesPorNome(@PathParam("nome") String nome) {
        Grafico grafico = controller.funcaoFavorecidos(nome);
        return response(grafico);
    }

    public Response response(Grafico grafico) {
        return (grafico.getData().isEmpty())
                ? Response.noContent().build()
                : Response.ok().entity(grafico).build();
    }
}

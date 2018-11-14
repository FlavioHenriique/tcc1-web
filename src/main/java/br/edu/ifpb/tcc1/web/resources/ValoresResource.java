package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.ValoresController;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONObject;

@Stateless
@Path("valor")
public class ValoresResource {

    @Inject
    private ValoresController controller;

    @GET
    @Path("/areas")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response areas() {
        JSONObject json = new JSONObject();
        json.put("valores", controller.areas());
        return Response.ok().entity(json.toString()).build();
    }

    @GET
    @Path("/anos")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response anos() {
        JSONObject json = new JSONObject();
        json.put("valores", controller.anos());
        return Response.ok().entity(json.toString()).build();
    }

    @GET
    @Path("/meses")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response meses() {
        JSONObject json = new JSONObject();
        json.put("valores", controller.meses());
        return Response.ok().entity(json.toString()).encoding("UTF-8").build();
    }
}

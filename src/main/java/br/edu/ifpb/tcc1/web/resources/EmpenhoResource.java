package br.edu.ifpb.tcc1.web.resources;

import br.edu.ifpb.tcc1.web.controller.IntervaloController;
import br.edu.ifpb.tcc1.web.dao.QueryEmpenhosJDBC;
import br.edu.ifpb.tcc1.web.dao.QueryEmpenhosJPA;
import br.edu.ifpb.tcc1.web.graficos.GraficoPizza;
import com.google.gson.Gson;
import java.time.Month;
import java.time.YearMonth;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("intervalo")
public class EmpenhoResource {
    
    private QueryEmpenhosJDBC query = new QueryEmpenhosJDBC();
    private IntervaloController intervalo = new IntervaloController();
    
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
}

package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.dao.QueryEmpenhosJDBC;
import br.edu.ifpb.tcc1.web.graficos.GraficoPizza;

public class IntervaloController {

    private QueryEmpenhosJDBC query;

    public IntervaloController() {
        query = new QueryEmpenhosJDBC();
    }

    public GraficoPizza buscaPorMes(int mes1, int mes2) {

        GraficoPizza grafico = new GraficoPizza("busca por meses");
        grafico.setData(query.buscaPorMes(mes1, mes2));
        grafico.setName("mes");

        return grafico;
    }

    public GraficoPizza buscaPorAno(int ano1, int ano2) {
        GraficoPizza grafico = new GraficoPizza("Busca por gastos entre"
                + " " + ano1 + " e " + ano2);
        grafico.setData(query.buscaPorAno(ano1, ano2));
        grafico.setName("teste");

        return grafico;
    }

    public GraficoPizza buscaPorSemestre(int semestre) {
        String sem = "" + semestre;
        String titulo = "Busca por gastos no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());

        GraficoPizza grafico = new GraficoPizza(titulo);
        grafico.setData(query.buscaPorSemestre(semestre));
        grafico.setName("teste");

        return grafico;
    }
}

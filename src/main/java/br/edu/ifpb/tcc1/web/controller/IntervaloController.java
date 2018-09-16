package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.dao.QueryEmpenhosJDBC;
import br.edu.ifpb.tcc1.web.graficos.GraficoPizza;
import java.time.Month;
import java.time.YearMonth;

public class IntervaloController {

    private QueryEmpenhosJDBC query;

    public IntervaloController() {
        query = new QueryEmpenhosJDBC();
    }

    public GraficoPizza buscaPorMes(int mes1, int mes2) {

        String primeiromes = String.valueOf(mes1);
        String segundoomes = String.valueOf(mes2);
        int primeiroano = Integer.parseInt(primeiromes.substring(0, 4));
        int segundoano = Integer.parseInt(segundoomes.substring(0, 4));

        YearMonth ym1 = YearMonth.of(primeiroano, 
                Integer.parseInt(primeiromes.substring(4, 6)));
        YearMonth ym2 = YearMonth.of(primeiroano, 
                Integer.parseInt(primeiromes.substring(4, 6)));
        
        
        GraficoPizza grafico = new GraficoPizza("Busca por gastos entre meses");

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

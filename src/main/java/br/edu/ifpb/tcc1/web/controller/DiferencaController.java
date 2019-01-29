package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.model.GraficoDiferenca;
import br.edu.ifpb.tcc1.web.model.GraficoDiferenca2;
import br.edu.ifpb.tcc1.web.query.QueryDiferenca;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class DiferencaController {

    @Inject
    private QueryDiferenca query;

    public GraficoDiferenca funcoesAnos(int ano1, int ano2, String funcao) {
        GraficoDiferenca grafico = query.funcoesAnos(ano1, ano2, funcao);
        grafico.setTitle("Diferença entre os gastos nos anos " + ano1 + " e " + ano2 + " para a função " + funcao);
        grafico.setType("column");
        grafico.setPrimeiroIntervalo("" + ano1);
        grafico.setSegundoIntervalo("" + ano2);
        grafico.setCategorias(Arrays.asList(new String[]{grafico.getPrimeiroIntervalo(),
             grafico.getSegundoIntervalo()}));
        return grafico;
    }

    public GraficoDiferenca funcoesAnos(int ano1, int ano2) {
        GraficoDiferenca grafico = query.funcoesAnos(ano1, ano2, "");
        grafico.setTitle("Diferença entre os gastos nos anos " + ano1 + " e " + ano2);
        grafico.setType("column");
        grafico.setPrimeiroIntervalo("" + ano1);
        grafico.setSegundoIntervalo("" + ano2);
        grafico.setCategorias(Arrays.asList(new String[]{grafico.getPrimeiroIntervalo()
            , grafico.getSegundoIntervalo()}));
        return grafico;
    }

    public GraficoDiferenca funcoesSemestres(int semestre1, int semestre2, String funcao) {
        GraficoDiferenca grafico = query.funcoesSemestre(semestre1, semestre2, funcao);
        if (funcao.equals("")) {
            grafico.setTitle("Diferença entre os gastos nos semestres selecionados");
        } else {
            grafico.setTitle("Diferença entre os gastos nos semestres selecionados na área de atuação " + funcao);
        }
        grafico.setType("column");
        grafico.setPrimeiroIntervalo("" + semestre1);
        grafico.setSegundoIntervalo("" + semestre2);
        grafico.setCategorias(Arrays.asList(new String[]{grafico.getPrimeiroIntervalo()
            , grafico.getSegundoIntervalo()}));
        return grafico;
    }

    public GraficoDiferenca funcoesMeses(int mes1, int mes2, String funcao) {
        GraficoDiferenca grafico = query.funcoesMeses(mes1, mes2, funcao);
        if (funcao.equals("")) {
            grafico.setTitle("Diferença entre os gastos nos meses selecionados");
        } else {
            grafico.setTitle("Diferença entre os gastos nos meses selecionados na área de atuação " + funcao);
        }
        grafico.setType("column");
        grafico.setPrimeiroIntervalo("" + mes1);
        grafico.setSegundoIntervalo("" + mes2);
        grafico.setCategorias(Arrays.asList(new String[]{grafico.getPrimeiroIntervalo()
            , grafico.getSegundoIntervalo()}));
        return grafico;
    }
}

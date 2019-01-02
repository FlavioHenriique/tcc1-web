package br.edu.ifpb.tcc1.web.query;

import br.edu.ifpb.tcc1.web.model.GraficoDiferenca;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QueryDiferenca {

    private Connection conn;
    @Inject
    private QueryIntervalos intervalos;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public GraficoDiferenca funcoesAnos(int ano1, int ano2) {
        List<Object[]> lista1 = intervalos.buscaPorAno(ano1, ano1);
        List<Object[]> lista2 = intervalos.buscaPorAno(ano2, ano2);
        return preparaValores(new GraficoDiferenca(), lista1, lista2);
    }

    public GraficoDiferenca funcoesSemestre(int semestre1, int semestre2) {
        List<Object[]> lista1 = intervalos.buscaPorSemestre(semestre1);
        List<Object[]> lista2 = intervalos.buscaPorSemestre(semestre2);
        return preparaValores(new GraficoDiferenca(), lista1, lista2);
    }

    public GraficoDiferenca funcoesMeses(int mes1, int mes2) {
        List<Object[]> lista1 = intervalos.buscaPorMes(mes1, mes1);
        List<Object[]> lista2 = intervalos.buscaPorMes(mes2, mes2);
        return preparaValores(new GraficoDiferenca(), lista1, lista2);
    }

    private GraficoDiferenca preparaValores(GraficoDiferenca grafico, List<Object[]> lista1, List<Object[]> lista2) {
        List<BigDecimal> valores1 = new ArrayList<>();
        List<BigDecimal> valores2 = new ArrayList<>();

        lista1.forEach(v -> valores1.add((BigDecimal) v[1]));
        lista2.forEach(v -> valores2.add((BigDecimal) v[1]));

        grafico.setValoresPrimeiroIntervalo(valores1);
        grafico.setValoresSegundoIntervalo(valores2);
        List<String> categorias = new ArrayList<>();
        if (lista1.size() > lista2.size()) {
            lista1.forEach(v -> categorias.add((String) v[0]));
        } else {
            lista2.forEach(v -> categorias.add((String) v[0]));
        }
        grafico.setCategorias(categorias);
        return grafico;
    }
}

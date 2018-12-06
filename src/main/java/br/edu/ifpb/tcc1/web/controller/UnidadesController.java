package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.model.GraficoIntervalos;
import br.edu.ifpb.tcc1.web.model.Tabela;
import br.edu.ifpb.tcc1.web.query.QueryUnidades;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class UnidadesController {

    @Inject
    private QueryUnidades query;

    public GraficoIntervalos orgaoSuperiorPorAno(int ano1, int ano2) {
        String titulo = "Gastos relacionados aos Órgãos Superiores " + " entre " + ano1 + " e " + ano2;
        return preparaResultado(titulo, query.orgaoSuperiorPorAnos(ano1, ano2));
    }

    public GraficoIntervalos orgaoPorAno(int ano1, int ano2, String orgaoSuperior) {
        String titulo = "Órgãos relacionados ao órgão superior "
                + orgaoSuperior + " entre " + ano1 + " e " + ano2;
        return preparaResultado(titulo, query.orgaoPorAnos(ano1, ano2, orgaoSuperior));
    }

    public GraficoIntervalos unidadesPorAno(int ano1, int ano2, String orgaoSuperior, String orgao) {
        String titulo = "Unidades Gestoras relacionadas ao órgão "
                + orgao + " entre " + ano1 + " e " + ano2;
        return preparaResultado(titulo, query.orgaoPorAnos(ano1, ano2, orgaoSuperior));
    }

    public GraficoIntervalos orgaoSuperiorPorSemestre(int semestre) {
        String sem = "" + semestre;
        String titulo = "Gastos relacionados aos Órgãos Superiores no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaResultado(titulo, query.orgaoSuperiorPorSemestre(semestre));
    }

    public GraficoIntervalos orgaoPorSemestre(int semestre, String orgaoSuperior) {
        String sem = "" + semestre;
        String titulo = "Órgãos relacionados ao órgão superior " + orgaoSuperior + " "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaResultado(titulo, query.orgaoPorSemestres(semestre, orgaoSuperior));
    }

    public GraficoIntervalos unidadesPorSemestre(int semestre, String orgaoSuperior, String orgao) {
        String sem = "" + semestre;
        String titulo = "Unidades gestoras relacionadas ao órgão " + orgao + " "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaResultado(titulo, query.unidadePorSemestres(semestre, orgaoSuperior, orgao));
    }

    public GraficoIntervalos orgaoSuperiorPorMeses(int mes1, int mes2) {
        String titulo = "Gastos relacionados aos Órgãos Superiores entre meses";
        return preparaResultado(titulo, query.orgaoSuperiorPorMeses(mes1, mes2));
    }

    public GraficoIntervalos orgaoPorMes(int mes1, int mes2, String orgaoSuperior) {

        String titulo = "Órgãos relacionados ao órgão superior " + orgaoSuperior + " entre meses";

        return preparaResultado(titulo, query.orgaoPorMeses(mes1, mes2, orgaoSuperior));
    }

    public GraficoIntervalos unidadesPorMeses(int mes1, int mes2, String orgaoSuperior, String orgao) {
        String titulo = "Unidades gestoras relacionadas ao órgão " + orgao + " entre meses";
        return preparaResultado(titulo, query.unidadePorMeses(mes1, mes2, orgaoSuperior, orgao));
    }

    private GraficoIntervalos preparaResultado(String titulo, List<Object[]> dados) {
        GraficoIntervalos grafico = new GraficoIntervalos(titulo);
        grafico.setData(dados);
        grafico.setType("pie");
        grafico.setCategorias(categorias(grafico.getData()));
        grafico.setName("Empenhos");
        return grafico;
    }

    private List<String> categorias(List<Object[]> lista) {
        List<String> categorias = new ArrayList<>();
        lista.forEach(d -> categorias.add(d[0].toString()));
        return categorias;
    }
}

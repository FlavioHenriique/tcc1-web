package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.dao.QueryIntervalos;
import br.edu.ifpb.tcc1.web.graficos.Grafico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class IntervaloController {

    @Inject
    private QueryIntervalos query;

    public Grafico buscaPorMes(int mes1, int mes2) {

        Grafico grafico = new Grafico("Busca por gastos entre meses");
        grafico.setType("pie");
        grafico.setData(query.buscaPorMes(mes1, mes2));
        grafico.setName("Empenhos");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public Grafico buscaPorAno(int ano1, int ano2) {
        Grafico grafico = new Grafico("Busca por gastos entre"
                + " " + ano1 + " e " + ano2);
        grafico.setData(query.buscaPorAno(ano1, ano2));
        grafico.setName("Empenhos");
        grafico.setType("pie");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public Grafico buscaPorSemestre(int semestre) {
        String sem = "" + semestre;
        String titulo = "Busca por gastos no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());

        Grafico grafico = new Grafico(titulo);
        grafico.setData(query.buscaPorSemestre(semestre));
        grafico.setName("Empenhos");
        grafico.setType("pie");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public Grafico buscaSubfuncaoPorAno(int ano1, int ano2, String funcao) {

        Grafico grafico = new Grafico("Subfunções da Função " + funcao
                + " entre " + ano1 + " e " + ano2);
        grafico.setName("Empenhos");
        grafico.setType("pie");
        grafico.setData(query.subfuncoesAnos(ano1, ano2, funcao));
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public Grafico buscaSubfuncaoPorSemestre(int semestre, String funcao) {

        String sem = "" + semestre;
        String titulo = "Subfunções da Função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        Grafico grafico = new Grafico(titulo);
        grafico.setData(query.subfuncoesSemestre(semestre, funcao));
        grafico.setType("pie");
        grafico.setName("Empenhos");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public Grafico buscSubfuncaoPorMes(int mes1, int mes2, String funcao) {
        Grafico grafico = new Grafico("Subfunções da Função " + funcao + " entre meses");
        grafico.setType("pie");
        grafico.setData(query.subfuncaoPorMes(mes1, mes2, funcao));
        grafico.setName("Empenhos");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public List<String> categorias(List<Object[]> lista) {
        List<String> categorias = new ArrayList<>();
        lista.forEach(d -> categorias.add(d[0].toString()));
        return categorias;
    }
}

package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.model.GraficoEvolucao;
import br.edu.ifpb.tcc1.web.model.GraficoIntervalos;
import br.edu.ifpb.tcc1.web.query.QueryEvolucao;
import br.edu.ifpb.tcc1.web.query.QueryValores;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EvolucaoController {

    @Inject
    private QueryEvolucao query;
    @Inject
    private QueryValores queryValores;

    public GraficoIntervalos anos2(int ano1, int ano2, String funcao) {

        GraficoIntervalos grafico = new GraficoIntervalos("Evolução dos gastos "
                + "entre os anos " + ano1 + " e " + ano2);
        if (!funcao.equals("")) {
            grafico.setTitle(grafico.getTitle() + " na função " + funcao);
        }
        grafico.setData(query.anos2(ano1, ano2, funcao));
        grafico.setName("Evolução dos gastos");
        grafico.setType("line");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public GraficoIntervalos semestres2(int semestre1, int semestre2, String funcao) {

        GraficoIntervalos grafico = new GraficoIntervalos("Evolução dos gastos "
                + "entre semestres selecionados");
        if (!funcao.equals("")) {
            grafico.setTitle(grafico.getTitle() + " na função " + funcao);
        }
        grafico.setData(query.semestres2(semestre1, semestre2, funcao));
        grafico.setName("Evolução dos gastos");
        grafico.setType("line");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }
    
        public GraficoIntervalos meses2(int mes1, int mes2, String funcao) {

        GraficoIntervalos grafico = new GraficoIntervalos("Evolução dos gastos "
                + "entre os meses selecionados");
        if (!funcao.equals("")) {
            grafico.setTitle(grafico.getTitle() + " na função " + funcao);
        }
        grafico.setData(query.meses2(mes1, mes2, funcao));
        grafico.setName("Evolução dos gastos");
        grafico.setType("line");
        grafico.setCategorias(categorias(grafico.getData()));
        return grafico;
    }

    public GraficoEvolucao anos(int ano1, int ano2) {

        GraficoEvolucao grafico = new GraficoEvolucao("Evolução dos gastos "
                + "entre os anos " + ano1 + " e " + ano2);
        grafico.setSeries(query.anos(ano1, ano2));
        grafico.setName("Evolução dos gastos");
        grafico.setType("line");
        //grafico.setCategorias(categorias());
        return grafico;
    }

    public List<String> categorias(List<Object[]> dados) {

        List<String> categorias = new ArrayList<>();

        dados.forEach(d -> {
            categorias.add((String) d[0]);
        });
        return categorias;
    }

}

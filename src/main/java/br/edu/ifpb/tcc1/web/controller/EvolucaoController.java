package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.model.GraficoEvolucao;
import br.edu.ifpb.tcc1.web.model.GraficoIntervalos;
import br.edu.ifpb.tcc1.web.query.QueryEvolucao;
import br.edu.ifpb.tcc1.web.query.QueryValores;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EvolucaoController {

    @Inject
    private QueryEvolucao query;
    @Inject
    private QueryValores queryValores;

    public GraficoEvolucao anos(int ano1, int ano2) {

        GraficoEvolucao grafico = new GraficoEvolucao("Evolução dos gastos "
                + "entre os anos " + ano1 + " e " + ano2);
        grafico.setSeries(query.anos(ano1, ano2));
        grafico.setName("Evolução dos gastos");
        grafico.setType("line");
        grafico.setCategorias(categorias());
        return grafico;
    }

    public List<String> categorias() {
        return queryValores.todosOsMeses();
    }

}

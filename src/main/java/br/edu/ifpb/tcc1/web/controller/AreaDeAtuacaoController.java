package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.query.QueryAreaDeAtuacao;
import br.edu.ifpb.tcc1.web.graficos.GraficoIntervalos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AreaDeAtuacaoController {

    @Inject
    private QueryAreaDeAtuacao query;

    

    public GraficoIntervalos buscarPorArea(String area) {
        String titulo = "Busca por gastos na área de atuação " + area;
        return montaGraficoIntervalos(titulo, query.buscarAreaDeAtuacao(area));
    }

    public GraficoIntervalos buscaPorPrograma(String area, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " da função " + area;
        return montaGraficoIntervalos(titulo, query.buscaPorPrograma(area, subfuncao));
    }

    public GraficoIntervalos buscaPorAcao(String area, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " da subfunção " + subfuncao;
        return montaGraficoIntervalos(titulo, query.buscaPorAcao(area, subfuncao, programa));
    }

    private GraficoIntervalos montaGraficoIntervalos(String titulo, List<Object[]> dados) {
        GraficoIntervalos grafico = new GraficoIntervalos(titulo);
        grafico.setData(dados);
        grafico.setCategorias(categorias(grafico.getData()));
        grafico.setName("Empenhos");
        grafico.setType("pie");
        return grafico;
    }

    private List<String> categorias(List<Object[]> lista) {
        List<String> categorias = new ArrayList<>();
        lista.forEach(d -> categorias.add(d[0].toString()));
        return categorias;
    }
}

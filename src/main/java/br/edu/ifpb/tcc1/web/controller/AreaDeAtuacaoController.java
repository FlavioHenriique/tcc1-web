package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.dao.QueryAreaDeAtuacao;
import br.edu.ifpb.tcc1.web.graficos.Grafico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class AreaDeAtuacaoController {

    @Inject
    private QueryAreaDeAtuacao query;

    public List<String> todasAsAreas() {
        return query.todasAsAreas();
    }

    public Grafico buscarPorArea(String area) {
        Grafico grafico = new Grafico("Busca por gastos em " + area);
        grafico.setType("pie");
        grafico.setData(query.buscarAreaDeAtuacao(area));
        grafico.setCategorias(categorias(grafico.getData()));
        grafico.setName("Empenhos");
        return grafico;
    }

    public List<String> categorias(List<Object[]> lista) {
        List<String> categorias = new ArrayList<>();
        lista.forEach(d -> categorias.add(d[0].toString()));
        return categorias;
    }
}

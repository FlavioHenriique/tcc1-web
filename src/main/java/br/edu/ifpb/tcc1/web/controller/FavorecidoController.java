package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.graficos.Grafico;
import br.edu.ifpb.tcc1.web.query.QueryFavorecidos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class FavorecidoController {

    @Inject
    private QueryFavorecidos query;

    public List<String> favorecidosPorNome(String nome) {
        return query.favorecidosPorNome(nome);
    }

    public List<String> favorecidosPorCNPJ(String cnpj) {
        return query.favorecidosPorCNPJ(cnpj);
    }

    public Grafico funcaoFavorecidos(String favorecido) {
        String titulo = "Busca por gastos relacionados ao favorecido " + favorecido;
        return preparaGrafico(titulo, query.funcoesFavorecido(favorecido));
    }

    public Grafico preparaGrafico(String titulo, List<Object[]> dados) {
        Grafico grafico = new Grafico(titulo);
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

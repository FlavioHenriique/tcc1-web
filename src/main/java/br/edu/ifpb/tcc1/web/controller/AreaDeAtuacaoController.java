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
        String titulo = "Busca por gastos em " + area;
        return montaGrafico(titulo, query.buscarAreaDeAtuacao(area));
    }

    public Grafico buscaPorPrograma(String area, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " da função " + area;
        return montaGrafico(titulo, query.buscaPorPrograma(area, subfuncao));
    }

    public Grafico buscaPorAcao(String area, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " da subfunção " + subfuncao;
        return montaGrafico(titulo, query.buscaPorAcao(area, subfuncao, programa));
    }

    private Grafico montaGrafico(String titulo, List<Object[]> dados) {
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

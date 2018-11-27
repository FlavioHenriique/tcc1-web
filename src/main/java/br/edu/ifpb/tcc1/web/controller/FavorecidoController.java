package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.graficos.GraficoIntervalos;
import br.edu.ifpb.tcc1.web.graficos.ResultadoTabela;
import br.edu.ifpb.tcc1.web.graficos.Tabela;
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

    public ResultadoTabela funcaoFavorecidosAnos(String favorecido, int ano1, int ano2) {
        String titulo = "Busca por gastos relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.FavorecidoAnos(favorecido, ano1, ano2));
        return rt;
    }

    public GraficoIntervalos subfuncaoFavorecidosAnos(String favorecido, int ano1, int ano2, String funcao) {
        String titulo = "Subfunções da " + funcao + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        return preparaGrafico(titulo, query.subfuncoesFavorecidoAnos(favorecido, ano1, ano2, funcao));
    }

    public GraficoIntervalos programaFavorecidosAnos(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        return preparaGrafico(titulo, query.programasFavorecidoAnos(favorecido,
                ano1, ano2, funcao, subfuncao));
    }

    public GraficoIntervalos acoesFavorecidosAnos(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        return preparaGrafico(titulo, query.acoesFavorecidoAnos(favorecido,
                ano1, ano2, funcao, subfuncao, programa));
    }

    public GraficoIntervalos funcaoFavorecidosSemestre(String favorecido, int semestre) {
        String sem = "" + semestre;
        String titulo = "Áreas de atuação relacionadas ao favorecido " + favorecido + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());

        return preparaGrafico(titulo, query.FavorecidoSemestre(favorecido, semestre));
    }

    public GraficoIntervalos subfuncaoFavorecidosSemestre(String favorecido, int semestre, String funcao) {
        String sem = "" + semestre;
        String titulo = "Subfunções da função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaGrafico(titulo, query.subfuncoesFavorecidoSemestre(favorecido, semestre, funcao));
    }

    public GraficoIntervalos programaFavorecidosSemestre(String favorecido, int semestre,
            String funcao, String subfuncao) {
        String sem = "" + semestre;
        String titulo = "Programas da subfunção " + subfuncao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaGrafico(titulo, query.programasFavorecidoSemestre(
                favorecido, semestre, funcao, subfuncao));
    }

    public GraficoIntervalos acoesFavorecidosSemestre(String favorecido, int semestre,
            String funcao, String subfuncao, String programa) {
        String sem = "" + semestre;
        String titulo = "Ações do programa " + programa + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaGrafico(titulo, query.acoesFavorecidoSemestre(favorecido,
                semestre, funcao, subfuncao, programa));
    }

    public GraficoIntervalos funcaoFavorecidosMeses(String favorecido, int mes1, int mes2) {
        String titulo = "Busca por gastos relacionados ao favorecido "
                + favorecido + " entre meses";
        return preparaGrafico(titulo, query.FavorecidoMeses(favorecido, mes1, mes2));
    }

    public GraficoIntervalos subfuncaoFavorecidosMeses(String favorecido, int mes1, int mes2, String funcao) {
        String titulo = "Subfunções da " + funcao + " relacionados ao favorecido "
                + favorecido + " entre meses";
        return preparaGrafico(titulo, query.subfuncoesFavorecidoMeses(favorecido, mes1, mes2, funcao));
    }

    public GraficoIntervalos programaFavorecidosMeses(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " relacionados ao favorecido "
                + favorecido + " entre meses";
        return preparaGrafico(titulo, query
                .programasFavorecidoMeses(favorecido, ano1, ano2, funcao, subfuncao));
    }

    public GraficoIntervalos acoesFavorecidosMeses(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " relacionados ao favorecido "
                + favorecido + " entre meses";
        return preparaGrafico(titulo, query
                .acoesFavorecidoMeses(favorecido, ano1, ano2, funcao, subfuncao, programa));
    }

    private GraficoIntervalos preparaGrafico(String titulo, List<Object[]> dados) {
        GraficoIntervalos grafico = new GraficoIntervalos(titulo);
        grafico.setData(dados);
        //grafico.setCategorias(categorias(grafico.getData()));
        grafico.setName("Empenhos");
        grafico.setType("pie");
        return grafico;
    }

    /*
    private List<String> categorias(List<Object[]> lista) {
        List<String> categorias = new ArrayList<>();
        lista.forEach(d -> categorias.add(d[0].toString()));
        return categorias;
    }*/
}

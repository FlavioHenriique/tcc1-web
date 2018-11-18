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

    public Grafico funcaoFavorecidosAnos(String favorecido, int ano1, int ano2) {
        String titulo = "Busca por gastos relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        return preparaGrafico(titulo, query.FavorecidoAnos(favorecido, ano1, ano2));
    }

    public Grafico subfuncaoFavorecidosAnos(String favorecido, int ano1, int ano2, String funcao) {
        String titulo = "Subfunções da " + funcao + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        return preparaGrafico(titulo, query.subfuncoesFavorecidoAnos(favorecido, ano1, ano2, funcao));
    }

    public Grafico programaFavorecidosAnos(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        return preparaGrafico(titulo, query.programasFavorecidoAnos(favorecido,
                ano1, ano2, funcao, subfuncao));
    }

    public Grafico acoesFavorecidosAnos(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        return preparaGrafico(titulo, query.acoesFavorecidoAnos(favorecido,
                ano1, ano2, funcao, subfuncao, programa));
    }

    public Grafico funcaoFavorecidosSemestre(String favorecido, int semestre) {
        String sem = "" + semestre;
        String titulo = "Áreas de atuação relacionadas ao favorecido " + favorecido + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());

        return preparaGrafico(titulo, query.FavorecidoSemestre(favorecido, semestre));
    }

    public Grafico subfuncaoFavorecidosSemestre(String favorecido, int semestre, String funcao) {
        String sem = "" + semestre;
        String titulo = "Subfunções da função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaGrafico(titulo, query.subfuncoesFavorecidoSemestre(favorecido, semestre, funcao));
    }

    public Grafico programaFavorecidosSemestre(String favorecido, int semestre,
            String funcao, String subfuncao) {
        String sem = "" + semestre;
        String titulo = "Subfunções da função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaGrafico(titulo, query.programasFavorecidoSemestre(
                favorecido, semestre, funcao, subfuncao));
    }

    public Grafico acoesFavorecidosSemestre(String favorecido, int semestre,
            String funcao, String subfuncao, String programa) {
        String sem = "" + semestre;
        String titulo = "Subfunções da função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return preparaGrafico(titulo, query.acoesFavorecidoSemestre(favorecido, 
                semestre, funcao, subfuncao, programa));
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

package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.graficos.ResultadoTabela;
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

    public ResultadoTabela subfuncaoFavorecidosAnos(String favorecido, int ano1, int ano2, String funcao) {
        System.out.println("subfu");
        String titulo = "Subfunções da " + funcao + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.subfuncoesFavorecidoAnos(favorecido, ano1, ano2, funcao));
        return rt;

    }

    public ResultadoTabela programaFavorecidosAnos(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.programasFavorecidoAnos(favorecido, ano1, ano2, funcao, subfuncao));
        return rt;
    }

    public ResultadoTabela acoesFavorecidosAnos(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " relacionados ao favorecido "
                + favorecido + " de " + ano1 + " a " + ano2;
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.acoesFavorecidoAnos(favorecido, ano1, ano2, funcao, subfuncao, programa));
        return rt;

    }

    public ResultadoTabela funcaoFavorecidosSemestre(String favorecido, int semestre) {
        String sem = "" + semestre;
        String titulo = "Áreas de atuação relacionadas ao favorecido " + favorecido + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.FavorecidoSemestre(favorecido, semestre));
        return rt;

    }

    public ResultadoTabela subfuncaoFavorecidosSemestre(String favorecido, int semestre, String funcao) {
        String sem = "" + semestre;
        String titulo = "Subfunções da função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.subfuncoesFavorecidoSemestre(favorecido, semestre, funcao));
        return rt;

    }

    public ResultadoTabela programaFavorecidosSemestre(String favorecido, int semestre,
            String funcao, String subfuncao) {
        String sem = "" + semestre;
        String titulo = "Programas da subfunção " + subfuncao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.programasFavorecidoSemestre(favorecido, semestre, funcao, subfuncao));
        return rt;
    }

    public ResultadoTabela acoesFavorecidosSemestre(String favorecido, int semestre,
            String funcao, String subfuncao, String programa) {
        String sem = "" + semestre;
        String titulo = "Ações do programa " + programa + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.acoesFavorecidoSemestre(favorecido, semestre, funcao, subfuncao, programa));
        return rt;

    }

    public ResultadoTabela funcaoFavorecidosMeses(String favorecido, int mes1, int mes2) {
        String titulo = "Busca por gastos relacionados ao favorecido "
                + favorecido + " entre meses";
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.FavorecidoMeses(favorecido, mes1, mes2));
        return rt;

    }

    public ResultadoTabela subfuncaoFavorecidosMeses(String favorecido, int mes1, int mes2, String funcao) {
        String titulo = "Subfunções da " + funcao + " relacionados ao favorecido "
                + favorecido + " entre meses";
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.subfuncoesFavorecidoMeses(favorecido, mes1, mes2, funcao));
        return rt;

    }

    public ResultadoTabela programaFavorecidosMeses(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " relacionados ao favorecido "
                + favorecido + " entre meses";
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.programasFavorecidoMeses(favorecido, ano1, ano2, funcao, subfuncao));
        return rt;
    }

    public ResultadoTabela acoesFavorecidosMeses(String favorecido, int ano1, int ano2,
            String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " relacionados ao favorecido "
                + favorecido + " entre meses";
        ResultadoTabela rt = new ResultadoTabela();
        rt.setTitulo(titulo);
        rt.setDados(query.acoesFavorecidoMeses(favorecido, ano1, ano2, funcao, subfuncao, programa));
        return rt;

    }

    /*
    private List<String> categorias(List<Object[]> lista) {
        List<String> categorias = new ArrayList<>();
        lista.forEach(d -> categorias.add(d[0].toString()));
        return categorias;
    }*/
}

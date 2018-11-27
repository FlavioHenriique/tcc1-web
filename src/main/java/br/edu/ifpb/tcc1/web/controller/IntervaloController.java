package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.query.QueryIntervalos;
import br.edu.ifpb.tcc1.web.graficos.GraficoIntervalos;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class IntervaloController {

    @Inject
    private QueryIntervalos query;

    public GraficoIntervalos buscaPorMes(int mes1, int mes2) {
         
        String titulo = "Busca por gastos entre meses";
        return montaGraficoIntervalos(titulo, query.buscaPorMes(mes1, mes2));
    }

    public GraficoIntervalos buscaPorAno(int ano1, int ano2) {
        String titulo = "Busca por gastos entre"
                + " " + ano1 + " e " + ano2;
        return montaGraficoIntervalos(titulo, query.buscaPorAno(ano1, ano2));
    }

    public GraficoIntervalos buscaPorSemestre(int semestre) {
        String sem = "" + semestre;
        String titulo = "Busca por gastos no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGraficoIntervalos(titulo, query.buscaPorSemestre(semestre));
    }

    public GraficoIntervalos buscaSubfuncaoPorAno(int ano1, int ano2, String funcao) {
        String titulo = "Subfunções da Função " + funcao
                + " entre " + ano1 + " e " + ano2;
        return montaGraficoIntervalos(titulo, query.subfuncoesAnos(ano1, ano2, funcao));
    }

    public GraficoIntervalos buscaSubfuncaoPorSemestre(int semestre, String funcao) {
        String sem = "" + semestre;
        String titulo = "Subfunções da Função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGraficoIntervalos(titulo, query.subfuncoesSemestre(semestre, funcao));
    }

    public GraficoIntervalos buscSubfuncaoPorMes(int mes1, int mes2, String funcao) {
        String titulo = "Subfunções da Função " + funcao + " entre meses";
        return montaGraficoIntervalos(titulo, query.subfuncaoPorMes(mes1, mes2, funcao));
    }

    public GraficoIntervalos buscaProgramaPorAno(int ano1, int ano2, String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao
                + " entre " + ano1 + " e " + ano2;
        return montaGraficoIntervalos(titulo, query.
                programaPorAno(ano1, ano2, funcao, subfuncao));
    }

    public GraficoIntervalos buscaProgramaPorSemestre(int semestre, String funcao, String subfuncao) {
        String sem = "" + semestre;
        String titulo = "Programas da subfunção " + subfuncao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGraficoIntervalos(titulo, query
                .programaPorSemestre(semestre, funcao, subfuncao));
    }

    public GraficoIntervalos buscaProgramaPorMes(int mes1, int mes2, String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " entre meses";
        return montaGraficoIntervalos(titulo, query
                .programaPorMes(mes1, mes2, funcao, subfuncao));
    }

    public GraficoIntervalos buscaAcaoPorAno(int ano1, int ano2, String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " entre " + ano1 + " e " + ano2;
        return montaGraficoIntervalos(titulo, query
                .acaoPorAno(ano1, ano2, funcao, subfuncao, programa));
    }

    public GraficoIntervalos buscaAcaoPorSemestre(int semestre, String funcao, String subfuncao, String programa) {
        String sem = "" + semestre;
        String titulo = "Ações do programa " + programa + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGraficoIntervalos(
                titulo,
                query.acaoPorSemestre(semestre, funcao, subfuncao, programa)
        );
    }

    public GraficoIntervalos buscaAcaoPorMes(int mes1, int mes2, String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " entre meses";
        return montaGraficoIntervalos(titulo, query
                .acaoPorMes(mes1, mes2, funcao, subfuncao, programa));
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

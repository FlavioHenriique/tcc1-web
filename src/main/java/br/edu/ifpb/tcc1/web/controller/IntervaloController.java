package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.query.QueryIntervalos;
import br.edu.ifpb.tcc1.web.graficos.Grafico;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class IntervaloController {

    @Inject
    private QueryIntervalos query;

    public Grafico buscaPorMes(int mes1, int mes2) {
         
        String titulo = "Busca por gastos entre meses";
        return montaGrafico(titulo, query.buscaPorMes(mes1, mes2));
    }

    public Grafico buscaPorAno(int ano1, int ano2) {
        String titulo = "Busca por gastos entre"
                + " " + ano1 + " e " + ano2;
        return montaGrafico(titulo, query.buscaPorAno(ano1, ano2));
    }

    public Grafico buscaPorSemestre(int semestre) {
        String sem = "" + semestre;
        String titulo = "Busca por gastos no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGrafico(titulo, query.buscaPorSemestre(semestre));
    }

    public Grafico buscaSubfuncaoPorAno(int ano1, int ano2, String funcao) {
        String titulo = "Subfunções da Função " + funcao
                + " entre " + ano1 + " e " + ano2;
        return montaGrafico(titulo, query.subfuncoesAnos(ano1, ano2, funcao));
    }

    public Grafico buscaSubfuncaoPorSemestre(int semestre, String funcao) {
        String sem = "" + semestre;
        String titulo = "Subfunções da Função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGrafico(titulo, query.subfuncoesSemestre(semestre, funcao));
    }

    public Grafico buscSubfuncaoPorMes(int mes1, int mes2, String funcao) {
        String titulo = "Subfunções da Função " + funcao + " entre meses";
        return montaGrafico(titulo, query.subfuncaoPorMes(mes1, mes2, funcao));
    }

    public Grafico buscaProgramaPorAno(int ano1, int ano2, String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao
                + " entre " + ano1 + " e " + ano2;
        return montaGrafico(titulo, query.
                programaPorAno(ano1, ano2, funcao, subfuncao));
    }

    public Grafico buscaProgramaPorSemestre(int semestre, String funcao, String subfuncao) {
        String sem = "" + semestre;
        String titulo = "Programas da subfunção " + subfuncao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGrafico(titulo, query
                .programaPorSemestre(semestre, funcao, subfuncao));
    }

    public Grafico buscaProgramaPorMes(int mes1, int mes2, String funcao, String subfuncao) {
        String titulo = "Programas da subfunção " + subfuncao + " entre meses";
        return montaGrafico(titulo, query
                .programaPorMes(mes1, mes2, funcao, subfuncao));
    }

    public Grafico buscaAcaoPorAno(int ano1, int ano2, String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " entre " + ano1 + " e " + ano2;
        return montaGrafico(titulo, query
                .acaoPorAno(ano1, ano2, funcao, subfuncao, programa));
    }

    public Grafico buscaAcaoPorSemestre(int semestre, String funcao, String subfuncao, String programa) {
        String sem = "" + semestre;
        String titulo = "Ações do programa " + programa + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        return montaGrafico(
                titulo,
                query.acaoPorSemestre(semestre, funcao, subfuncao, programa)
        );
    }

    public Grafico buscaAcaoPorMes(int mes1, int mes2, String funcao, String subfuncao, String programa) {
        String titulo = "Ações do programa " + programa + " entre meses";
        return montaGrafico(titulo, query
                .acaoPorMes(mes1, mes2, funcao, subfuncao, programa));
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

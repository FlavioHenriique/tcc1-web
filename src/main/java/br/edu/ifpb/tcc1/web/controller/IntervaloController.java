package br.edu.ifpb.tcc1.web.controller;

import br.edu.ifpb.tcc1.web.dao.QueryEmpenhos;
import br.edu.ifpb.tcc1.web.graficos.Grafico;
import java.time.Month;
import java.time.YearMonth;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class IntervaloController {
    
    @Inject
    private QueryEmpenhos query;

    /*
    public IntervaloController() {
        //query = new QueryEmpenhosJDBC();
    }
     */
    public Grafico buscaPorMes(int mes1, int mes2) {
        
        String primeiromes = String.valueOf(mes1);
        String segundoomes = String.valueOf(mes2);
        int primeiroano = Integer.parseInt(primeiromes.substring(0, 4));
        int segundoano = Integer.parseInt(segundoomes.substring(0, 4));
        
        YearMonth ym1 = YearMonth.of(primeiroano,
                Integer.parseInt(primeiromes.substring(4, 6)));
        YearMonth ym2 = YearMonth.of(primeiroano,
                Integer.parseInt(primeiromes.substring(4, 6)));
        
        Grafico grafico = new Grafico("Busca por gastos entre meses");
        grafico.setType("pie");
        grafico.setData(query.buscaPorMes(mes1, mes2));
        grafico.setName("mes");
        
        return grafico;
    }
    
    public Grafico buscaPorAno(int ano1, int ano2) {
        Grafico grafico = new Grafico("Busca por gastos entre"
                + " " + ano1 + " e " + ano2);
        grafico.setData(query.buscaPorAno(ano1, ano2));
        grafico.setName("teste");
        grafico.setType("pie");
        return grafico;
    }
    
    public Grafico buscaPorSemestre(int semestre) {
        String sem = "" + semestre;
        String titulo = "Busca por gastos no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        
        Grafico grafico = new Grafico(titulo);
        grafico.setData(query.buscaPorSemestre(semestre));
        grafico.setName("teste");
        grafico.setType("pie");
        return grafico;
    }
    
    public Grafico buscaSubfuncaoPorAno(int ano1, int ano2, String funcao) {
        
        Grafico grafico = new Grafico("Subfunções da Função " + funcao
                + " entre " + ano1 + " e " + ano2);
        grafico.setName("Subfunções");
        grafico.setType("pie");
        grafico.setData(query.subfuncoesAnos(ano1, ano2, funcao));
        
        return grafico;
    }
    
    public Grafico buscaSubfuncaoPorSemestre(int semestre, String funcao) {
        
        String sem = "" + semestre;
        String titulo = "Subfunções da Função " + funcao + " no "
                + sem.substring(0, 1)
                + "º semestre de "
                + sem.substring(1, sem.length());
        Grafico grafico = new Grafico(titulo);
        grafico.setData(query.subfuncoesSemestre(semestre, funcao));
        grafico.setType("pie");
        grafico.setName("Subfunções");
        
        return grafico;
    }
}

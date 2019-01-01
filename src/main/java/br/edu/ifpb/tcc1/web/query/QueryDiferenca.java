package br.edu.ifpb.tcc1.web.query;

import br.edu.ifpb.tcc1.web.model.GraficoDiferenca;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QueryDiferenca {
    
    private Connection conn;
    @Inject
    private QueryIntervalos intervalos;
    
    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }
    
    public GraficoDiferenca funcoesAnos(int ano1, int ano2) {
        List<Object[]> lista1 = intervalos.buscaPorAno(ano1, ano1);
        List<Object[]> lista2 = intervalos.buscaPorAno(ano2, ano2);
        
        List<BigDecimal> valores1 = new ArrayList<>();
        List<BigDecimal> valores2 = new ArrayList<>();
        
        lista1.forEach(v -> valores1.add((BigDecimal) v[1]));
        lista2.forEach(v -> valores2.add((BigDecimal) v[1]));
        
        GraficoDiferenca diferenca = new GraficoDiferenca();
        diferenca.setValoresPrimeiroIntervalo(valores1);
        diferenca.setValoresSegundoIntervalo(valores2);
        diferenca.setPrimeiroIntervalo("" + ano1);
        diferenca.setSegundoIntervalo("" + ano2);
        
    }
}

package br.edu.ifpb.tcc1.web.model;

import java.math.BigDecimal;
import java.util.List;

public class GraficoDiferenca {
    
    private List<BigDecimal> valoresPrimeiroIntervalo;
    private List<BigDecimal> valoresSegundoIntervalo;
    private String primeiroIntervalo;
    private String segundoIntervalo;
    
    public GraficoDiferenca(){
        
    }

    public List<BigDecimal> getValoresPrimeiroIntervalo() {
        return valoresPrimeiroIntervalo;
    }

    public void setValoresPrimeiroIntervalo(List<BigDecimal> valoresPrimeiroIntervalo) {
        this.valoresPrimeiroIntervalo = valoresPrimeiroIntervalo;
    }

    public List<BigDecimal> getValoresSegundoIntervalo() {
        return valoresSegundoIntervalo;
    }

    public void setValoresSegundoIntervalo(List<BigDecimal> valoresSegundoIntervalo) {
        this.valoresSegundoIntervalo = valoresSegundoIntervalo;
    }

    public String getPrimeiroIntervalo() {
        return primeiroIntervalo;
    }

    public void setPrimeiroIntervalo(String primeiroIntervalo) {
        this.primeiroIntervalo = primeiroIntervalo;
    }

    public String getSegundoIntervalo() {
        return segundoIntervalo;
    }

    public void setSegundoIntervalo(String segundoIntervalo) {
        this.segundoIntervalo = segundoIntervalo;
    }
    
    
}

package br.edu.ifpb.tcc1.web.model;

import java.math.BigDecimal;

public class GraficoDiferenca2 {

    private BigDecimal intervalo1;
    private BigDecimal intervalo2;
    private String nome1;
    private String nome2;
    private String type;
    private String name;
    private String title;

    public BigDecimal getIntervalo1() {
        return intervalo1;
    }

    public void setIntervalo1(BigDecimal intervalo1) {
        this.intervalo1 = intervalo1;
    }

    public BigDecimal getIntervalo2() {
        return intervalo2;
    }

    public void setIntervalo2(BigDecimal intervalo2) {
        this.intervalo2 = intervalo2;
    }

    public String getNome1() {
        return nome1;
    }

    public void setNome1(String nome1) {
        this.nome1 = nome1;
    }

    public String getNome2() {
        return nome2;
    }

    public void setNome2(String nome2) {
        this.nome2 = nome2;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}

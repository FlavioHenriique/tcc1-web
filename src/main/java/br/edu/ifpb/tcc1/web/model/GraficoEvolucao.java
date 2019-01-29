package br.edu.ifpb.tcc1.web.model;

import java.util.List;

public class GraficoEvolucao extends GraficoIntervalos {

    private List<Series> series;

    public GraficoEvolucao(String title) {
        super(title);
    }

    public List<Series> getSeries() {
        return series;
    }

    public void setSeries(List<Series> series) {
        this.series = series;
    }

}

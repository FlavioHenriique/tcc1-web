package br.edu.ifpb.tcc1.web.model;

import java.util.List;

public class GraficoIntervalos extends Grafico {

    private List<String> categorias;

    public GraficoIntervalos(String title) {
        super(title);
    }

    public List<String> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<String> categorias) {
        this.categorias = categorias;
    }

}

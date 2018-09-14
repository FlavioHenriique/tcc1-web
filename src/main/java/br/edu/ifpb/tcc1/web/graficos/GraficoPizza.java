package br.edu.ifpb.tcc1.web.graficos;

import java.util.List;

public class GraficoPizza {

    private final String type = "pie";
    private String name;
    private List<Object[]> data;

    public GraficoPizza() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Object[]> getData() {
        return data;
    }

    public void setData(List<Object[]> data) {
        this.data = data;
    }

}

package br.edu.ifpb.tcc1.web.graficos;

import java.util.List;

public class GraficoPizza {

    private final String type = "pie";
    private String name;
    private List<Object[]> data;
    private String title;

    public GraficoPizza(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

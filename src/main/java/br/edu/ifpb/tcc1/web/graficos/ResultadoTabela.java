package br.edu.ifpb.tcc1.web.graficos;

import java.util.List;

public class ResultadoTabela {

    private List<Tabela> dados;
    private String titulo;

    public ResultadoTabela() {

    }

    public List<Tabela> getDados() {
        return dados;
    }

    public void setDados(List<Tabela> dados) {
        this.dados = dados;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}

package br.edu.ifpb.tcc1.web.model;

import java.math.BigDecimal;
import java.util.List;

public class Series {
    
    private List<BigDecimal> data;
    private String name;

    public Series(){
        
    }
    
    public List<BigDecimal> getData() {
        return data;
    }

    public void setData(List<BigDecimal> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

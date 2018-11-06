package br.edu.ifpb.tcc1.web.query;

import java.sql.Connection;
import javax.annotation.PostConstruct;

public class QueryFavorecidos {

    private Connection conn;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }
    
   
}

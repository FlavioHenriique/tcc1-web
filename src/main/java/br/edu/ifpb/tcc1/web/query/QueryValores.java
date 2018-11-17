package br.edu.ifpb.tcc1.web.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class QueryValores {

    private Connection conn;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public List<String> todasAsAreas() {
        String sql = "SELECT DISTINCT NomeFuncao FROM Acao ORDER BY NomeFuncao";
        return preparaListString("nomefuncao", sql);
    }

    public List<String> todosOsAnos() {
        String sql = "SELECT DISTINCT Ano FROM Data ORDER BY Ano DESC";
        return preparaListString("ano", sql);
    }
    
    public List<String> todosOsMeses(){
        String sql = "SELECT DISTINCT nome_mes,numero_mes FROM data ORDER BY numero_mes";
        return preparaListString("nome_mes", sql);
    }

    public List<String> preparaListString(String campo, String sql) {

        List<String> lista = new ArrayList<>();
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                
                lista.add(rs.getString(campo));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}

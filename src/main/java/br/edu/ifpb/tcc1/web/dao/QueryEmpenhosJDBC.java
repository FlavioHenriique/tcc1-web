package br.edu.ifpb.tcc1.web.dao;

import br.edu.ifpb.tcc1.web.domain.Empenho;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class QueryEmpenhosJDBC {

    private Connection conn;

    public QueryEmpenhosJDBC() {
        conn = Conexao.getConnection();
    }

    public BigDecimal buscaPorAno(int ano1, int ano2) {
        String sql = "Select sum(e.valor) as total "
                + "from empenho e, data d "
                + "where e.coddata = d.codigo AND d.ano BETWEEN ? AND ?;";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return rs.getBigDecimal("total");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new BigDecimal(0);
    }
    
    

}

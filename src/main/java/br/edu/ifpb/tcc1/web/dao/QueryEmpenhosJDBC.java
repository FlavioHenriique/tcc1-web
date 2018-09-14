package br.edu.ifpb.tcc1.web.dao;

import br.edu.ifpb.tcc1.web.domain.Empenho;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public List<Object[]> buscaPorAno(int ano1, int ano2) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "select a.nomefuncao, sum(e.valor) as total "
                + "from acao a, empenho e, data d "
                + "where e.codacao = a.codigoacao "
                + "and e.coddata = d.codigo "
                + "and d.ano between ? and ? "
                + "group by a.nomefuncao";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] array = {rs.getString("nomefuncao"),
                    rs.getBigDecimal("total")};

                lista.add(array);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

}

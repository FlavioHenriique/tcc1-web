
package br.edu.ifpb.tcc1.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class QueryAreaDeAtuacao {

    private Connection conn;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public List<String> todasAsAreas() {

        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT NomeFuncao FROM Acao ORDER BY NomeFuncao";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("NomeFuncao"));
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> buscarAreaDeAtuacao(String area) {

        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT a.nomesubfuncao, sum(e.valor) as total "
                + "FROM acao a, empenho e "
                + "WHERE e.codacao = a.codigoacao "
                + "AND a.nomefuncao = ? "
                + "GROUP BY a.nomesubfuncao "
                + "ORDER BY a.nomesubfuncao";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, area);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Object[]{
                    rs.getString("nomesubfuncao"),
                    rs.getBigDecimal("total")
                });
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;

    }
}

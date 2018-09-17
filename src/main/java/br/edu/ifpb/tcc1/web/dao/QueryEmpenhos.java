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
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class QueryEmpenhos {

    private Connection conn;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public List<Object[]> buscaPorAno(int ano1, int ano2) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT a.nomefuncao, sum(e.valor) as total "
                + "FROM acao a, empenho e, data d "
                + "WHERE e.codacao = a.codigoacao "
                + "AND e.coddata = d.codigo "
                + "AND d.ano between ? AND ? "
                + "GROUP BY a.nomefuncao "
                + "ORDER BY a.nomefuncao";
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

    public List<Object[]> buscaPorSemestre(int semestre) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT a.nomefuncao, sum(e.valor) as total "
                + "FROM acao a, empenho e, data d "
                + "WHERE e.codacao = a.codigoacao "
                + "AND e.coddata = d.codigo "
                + "AND d.semestre = ? "
                + "GROUP BY a.nomefuncao"
                + " ORDER BY a.nomefuncao";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, semestre);

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

    public List<Object[]> buscaPorMes(int mes1, int mes2) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT a.nomefuncao, sum(e.valor) as total "
                + "FROM acao a, empenho e, data d "
                + "WHERE e.codacao = a.codigoacao "
                + "AND e.coddata = d.codigo "
                + "AND d.codigo BETWEEN ? AND ? "
                + "GROUP BY a.nomefuncao "
                + "ORDER BY a.nomefuncao";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mes1);
            stmt.setInt(2, mes2);
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

    public List<Object[]> subfuncoesAnos(int ano1, int ano2, String funcao) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT a.nomesubfuncao, sum(e.valor) as total "
                + "FROM acao a, empenho e, data d "
                + "WHERE e.codacao = a.codigoacao "
                + "AND d.codigo = e.coddata "
                + "AND a.nomefuncao = ? "
                + "AND d.ano between ? AND ? "
                + "GROUP BY a.nomesubfuncao"
                + " ORDER BY a.nomesubfuncao";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcao);
            stmt.setInt(2, ano1);
            stmt.setInt(3, ano2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] array = {rs.getString("nomesubfuncao"),
                    rs.getBigDecimal("total")};

                lista.add(array);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> subfuncoesSemestre(int semestre, String funcao) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT a.nomesubfuncao, sum(e.valor) as total "
                + "FROM acao a, empenho e, data d "
                + "WHERE e.codacao = a.codigoacao "
                + "AND d.codigo = e.coddata "
                + "AND a.nomefuncao = ? "
                + "AND d.semestre = ? "
                + "GROUP BY a.nomesubfuncao"
                + " ORDER BY a.nomesubfuncao";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcao);
            stmt.setInt(2, semestre);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] array = {
                    rs.getString("nomesubfuncao"),
                    rs.getBigDecimal("total")
                };

                lista.add(array);
            }
            return lista;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> subfuncaoPorMes(int mes1, int mes2, String funcao) {

        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT a.nomesubfuncao, sum(e.valor) as total "
                + "FROM acao a, empenho e, data d "
                + "WHERE e.codacao = a.codigoacao "
                + "AND e.coddata = d.codigo "
                + "AND a.nomefuncao = ? "
                + "AND d.codigo BETWEEN ? AND ? "
                + "GROUP BY a.nomesubfuncao "
                + "ORDER BY a.nomesubfuncao";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, funcao);
            stmt.setInt(2, mes1);
            stmt.setInt(3, mes2);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Object[] array = {rs.getString("nomesubfuncao"),
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

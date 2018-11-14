package br.edu.ifpb.tcc1.web.query;

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

    public List<Object[]> buscarAreaDeAtuacao(String area) {

        List<Object[]> lista = new ArrayList<>();
        String campo = "nomesubfuncao";
        String sql = "SELECT a." + campo + ", sum(e.valor) as total "
                + "FROM acao a, empenho e "
                + "WHERE e.codacao = a.codigoacao "
                + "AND a.nomefuncao = ? "
                + "GROUP BY a." + campo + " "
                + "ORDER BY a." + campo;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, area);
            return prepararLista(stmt, campo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> buscaPorPrograma(String area, String subfuncao) {

        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeprograma";
        String sql = "SELECT a." + campo + ", sum(e.valor) as total "
                + "FROM acao a, empenho e "
                + "WHERE e.codacao = a.codigoacao "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + "GROUP BY a." + campo + " "
                + "ORDER BY a." + campo;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, area);
            stmt.setString(2, subfuncao);
            return prepararLista(stmt, campo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> buscaPorAcao(String area, String subfuncao, String programa) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeacao";
        String sql = "SELECT a." + campo + ", sum(e.valor) as total "
                + "FROM acao a, empenho e "
                + "WHERE e.codacao = a.codigoacao "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + "AND a.nomeprograma = ? "
                + "GROUP BY a." + campo + " "
                + "ORDER BY a." + campo;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, area);
            stmt.setString(2, subfuncao);
            stmt.setString(3, programa);
            return prepararLista(stmt, campo);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> prepararLista(PreparedStatement stmt, String campo) {
        List<Object[]> lista = new ArrayList<>();
        ResultSet rs;
        try {
            rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Object[]{
                    rs.getString(campo),
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

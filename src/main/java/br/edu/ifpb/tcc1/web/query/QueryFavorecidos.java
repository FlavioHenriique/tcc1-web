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
public class QueryFavorecidos {

    private Connection conn;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public List<String> favorecidosPorNome(String nome) {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT Nome FROM Favorecido WHERE Nome ilike ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<String> favorecidosPorCNPJ(String cnpj) {
        List<String> lista = new ArrayList<>();
        String sql = "SELECT DISTINCT Nome FROM Favorecido WHERE codigo ilike ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cnpj + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> funcoesFavorecido(String favorecido) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomefuncao";
        String sql = "SELECT SUM(e.valor) as total, a." + campo
                + " FROM Acao a, Empenho e, Favorecido f "
                + "WHERE e.codacao = a.codigoacao "
                + "AND f.nome ilike ? "
                + "GROUP BY a." + campo + " "
                + "ORDER BY sum(e.valor), a." + campo;
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> preparaLista(String campo, PreparedStatement stmt) throws SQLException {
        List<Object[]> lista = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getString(campo),
                rs.getString("total")
            });
        }
        return lista;
    }
}

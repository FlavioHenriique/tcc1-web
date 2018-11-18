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
            stmt.setString(1, cnpj);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("nome"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //ANOS
    public List<Object[]> FavorecidoAnos(String favorecido, int ano1, int ano2) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomefuncao";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, ano1);
            stmt.setInt(3, ano2);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> subfuncoesFavorecidoAnos(String favorecido, int ano1, int ano2, String funcao) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomesubfuncao";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + "AND a.nomefuncao = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, ano1);
            stmt.setInt(3, ano2);
            stmt.setString(4, funcao);
            System.out.println(sql);

            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> programasFavorecidoAnos(String favorecido, int ano1,
            int ano2, String funcao, String subfuncao) {

        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeprograma";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, ano1);
            stmt.setInt(3, ano2);
            stmt.setString(4, funcao);
            stmt.setString(5, subfuncao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> acoesFavorecidoAnos(String favorecido, int ano1,
            int ano2, String funcao, String subfuncao, String programa) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeacao";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + "AND a.nomeprograma = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, ano1);
            stmt.setInt(3, ano2);
            stmt.setString(4, funcao);
            stmt.setString(5, subfuncao);
            stmt.setString(6, programa);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //SEMESTRE
    public List<Object[]> FavorecidoSemestre(String favorecido, int semestre) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomefuncao";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, semestre);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> subfuncoesFavorecidoSemestre(String favorecido, int semestre,
            String funcao) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomesubfuncao";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + "AND a.nomefuncao = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, semestre);
            stmt.setString(3, funcao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> programasFavorecidoSemestre(String favorecido, int semestre,
            String funcao, String subfuncao) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeprograma";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, semestre);
            stmt.setString(3, funcao);
            stmt.setString(4, subfuncao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> acoesFavorecidoSemestre(String favorecido, int semestre,
            String funcao, String subfuncao, String programa) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeacao";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + "AND a.nomeprograma = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, semestre);
            stmt.setString(3, funcao);
            stmt.setString(4, subfuncao);
            stmt.setString(5, programa);

            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    // MESES
    public List<Object[]> FavorecidoMeses(String favorecido, int mes1, int mes2) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomefuncao";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, mes1);
            stmt.setInt(3, mes2);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> subfuncoesFavorecidoMeses(String favorecido, int mes1, int mes2,
            String funcao) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomesubfuncao";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + "AND a.nomefuncao = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, mes1);
            stmt.setInt(3, mes2);
            stmt.setString(4, funcao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> programasFavorecidoMeses(String favorecido, int mes1, int mes2,
            String funcao, String subfuncao) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeprograma";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, mes1);
            stmt.setInt(3, mes2);
            stmt.setString(4, funcao);
            stmt.setString(5, subfuncao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Object[]> acoesFavorecidoMeses(String favorecido, int mes1, int mes2,
            String funcao, String subfuncao, String programa) {
        List<Object[]> lista = new ArrayList<>();
        String campo = "nomeacao";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + "AND a.nomefuncao = ? "
                + "AND a.nomesubfuncao = ? "
                + "AND a.nomeprograma = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, mes1);
            stmt.setInt(3, mes2);
            stmt.setString(4, funcao);
            stmt.setString(5, subfuncao);
            stmt.setString(6, programa);

            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private List<Object[]> preparaLista(String campo, PreparedStatement stmt) throws SQLException {
        List<Object[]> lista = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(new Object[]{
                rs.getString(campo),
                rs.getBigDecimal("total")
            });
        }
        return lista;
    }

    private String inicioSQL(String campo) {
        return "SELECT SUM(e.valor) as total, a." + campo
                + " FROM Acao a, Empenho e, Favorecido f, Data d "
                + "WHERE e.codacao = a.codigoacao "
                + "AND e.coddata = d.codigo "
                + "AND f.codigo = e.codfavorecido "
                + "AND f.nome ilike ? ";
    }

    private String fimSQL(String campo) {
        return "GROUP BY a." + campo + " ORDER BY sum(e.valor), a." + campo;
    }
}

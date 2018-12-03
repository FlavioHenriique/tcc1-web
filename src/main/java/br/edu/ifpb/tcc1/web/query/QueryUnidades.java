package br.edu.ifpb.tcc1.web.query;

import br.edu.ifpb.tcc1.web.graficos.Tabela;
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
public class QueryUnidades {

    private Connection conn;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public List<Object[]> orgaoSuperiorPorAnos(int ano1, int ano2) {
        String campo = "nomeorgaosuperior";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + fimSQL(campo);
        System.out.println(sql);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> orgaoPorAnos(int ano1, int ano2, String orgaoSuperior) {
        String campo = "nomeorgao";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + "AND u.nomeorgaosuperior = ? "
                + fimSQL(campo);
        System.out.println(sql);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            stmt.setString(3, orgaoSuperior);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> unidadePorAnos(int ano1, int ano2, String orgaoSuperior, String orgao) {
        String campo = "nomeunidadegestora";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + "AND u.nomeorgaosuperior = ? "
                + "AND u.nomeorgao = ? "
                + fimSQL(campo);

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            stmt.setString(3, orgaoSuperior);
            stmt.setString(4, orgao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> orgaoSuperiorPorSemestre(int semestre) {
        String campo = "nomeorgaosuperior";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + fimSQL(campo);
        System.out.println(sql);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, semestre);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> orgaoPorSemestres(int semestre, String orgaoSuperior) {
        String campo = "nomeorgao";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + "AND u.nomeorgaosuperior = ? "
                + fimSQL(campo);
        System.out.println(sql);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, semestre);
            stmt.setString(2, orgaoSuperior);

            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> unidadePorSemestres(int semestre, String orgaoSuperior, String orgao) {
        String campo = "nomeunidadegestora";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + "AND u.nomeorgaosuperior = ? "
                + "AND u.nomeorgao = ? "
                + fimSQL(campo);

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, semestre);
            stmt.setString(2, orgaoSuperior);
            stmt.setString(3, orgao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> orgaoSuperiorPorMeses(int mes1, int mes2) {
        String campo = "nomeorgaosuperior";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + fimSQL(campo);
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mes1);
            stmt.setInt(2, mes2);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> orgaoPorMeses(int mes1, int mes2, String orgaoSuperior) {
        String campo = "nomeorgao";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + "AND u.nomeorgaosuperior = ? "
                + fimSQL(campo);

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mes1);
            stmt.setInt(2, mes2);
            stmt.setString(3, orgaoSuperior);

            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Object[]> unidadePorMeses(int mes1, int mes2, String orgaoSuperior, String orgao) {
        String campo = "nomeunidadegestora";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + "AND u.nomeorgaosuperior = ? "
                + "AND u.nomeorgao = ? "
                + fimSQL(campo);

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, mes1);
            stmt.setInt(2, mes2);
            stmt.setString(3, orgaoSuperior);
            stmt.setString(4, orgao);
            return preparaLista(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public String inicioSQL(String campo) {
        return "SELECT   sum(e.valor) as total, u." + campo + " "
                + "FROM unidadegestora u, empenho e, data d  "
                + "WHERE e.codunidadegestora = u.codigounidadegestora "
                + "AND d.codigo = e.coddata ";
    }

    public String fimSQL(String campo) {
        return "GROUP BY u. " + campo
                + " ORDER BY  sum(e.valor) desc";
    }

    private List<Object[]> preparaLista(String campo, PreparedStatement stmt) throws SQLException {
        List<Object[]> lista = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lista.add(new Object[]{rs.getString(campo), rs.getBigDecimal("total")});
        }
        return lista;
    }

}

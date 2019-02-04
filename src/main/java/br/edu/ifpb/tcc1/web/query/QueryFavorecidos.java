package br.edu.ifpb.tcc1.web.query;

import br.edu.ifpb.tcc1.web.model.Tabela;
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
        String sql = "SELECT DISTINCT Nome FROM Favorecido WHERE Nome ilike ? ORDER BY nome";
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
        String sql = "SELECT DISTINCT Nome FROM Favorecido WHERE codigo ilike ? ORDER BY nome";
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
    public List<Tabela> FavorecidoAnos(String favorecido, int ano1, int ano2) {
        Tabela tabela = new Tabela();
        String campo = "nomefuncao";
        String sql = inicioSQL(campo)
                + "AND d.ano BETWEEN ? AND ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, ano1);
            stmt.setInt(3, ano2);
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Tabela> subfuncoesFavorecidoAnos(String favorecido, int ano1, int ano2, String funcao) {
        System.out.println("subfuncoes");
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

            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Tabela> programasFavorecidoAnos(String favorecido, int ano1,
            int ano2, String funcao, String subfuncao) {

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
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return new ArrayList<>();
    }

    public List<Tabela> acoesFavorecidoAnos(String favorecido, int ano1,
            int ano2, String funcao, String subfuncao, String programa) {
        List<Tabela> lista = new ArrayList<>();
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
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    //SEMESTRE
    public List<Tabela> FavorecidoSemestre(String favorecido, int semestre) {
        List<Tabela> lista = new ArrayList<>();
        String campo = "nomefuncao";
        String sql = inicioSQL(campo)
                + "AND d.semestre = ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, semestre);
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Tabela> subfuncoesFavorecidoSemestre(String favorecido, int semestre,
            String funcao) {
        List<Tabela> lista = new ArrayList<>();
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
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Tabela> programasFavorecidoSemestre(String favorecido, int semestre,
            String funcao, String subfuncao) {
        List<Tabela> lista = new ArrayList<>();
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
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Tabela> acoesFavorecidoSemestre(String favorecido, int semestre,
            String funcao, String subfuncao, String programa) {
        List<Tabela> lista = new ArrayList<>();
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

            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    // MESES
    public List<Tabela> FavorecidoMeses(String favorecido, int mes1, int mes2) {
        List<Tabela> lista = new ArrayList<>();
        String campo = "nomefuncao";
        String sql = inicioSQL(campo)
                + "AND d.codigo BETWEEN ? AND ? "
                + fimSQL(campo);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, favorecido);
            stmt.setInt(2, mes1);
            stmt.setInt(3, mes2);
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Tabela> subfuncoesFavorecidoMeses(String favorecido, int mes1, int mes2,
            String funcao) {
        List<Tabela> lista = new ArrayList<>();
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
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Tabela> programasFavorecidoMeses(String favorecido, int mes1, int mes2,
            String funcao, String subfuncao) {
        List<Tabela> lista = new ArrayList<>();
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
            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public List<Tabela> acoesFavorecidoMeses(String favorecido, int mes1, int mes2,
            String funcao, String subfuncao, String programa) {
        List<Tabela> lista = new ArrayList<>();
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

            return preparaTabela(campo, stmt);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    private String inicioSQL(String campo) {
        return "select  CAST(CAST(sum(e.valor) AS NUMERIC(20,2)) AS varchar(20)) as total,"
                + " d.ano, d.nome_mes, u.nomeunidadegestora, a." + campo
                + " FROM Acao a, Empenho e, Favorecido f, Data d, unidadegestora u "
                + "WHERE e.codacao = a.codigoacao "
                + "AND e.coddata = d.codigo "
                + "and u.codigounidadegestora = e.codunidadegestora "
                + "AND f.codigo = e.codfavorecido "
                + "AND f.nome ilike ? ";
    }

    private String fimSQL(String campo) {
        return "GROUP BY d.ano, d.nome_mes, u.nomeunidadegestora, d.numero_Mes, "
                + "a." + campo + " ORDER BY d.ano desc, d.numero_mes desc, sum(e.valor), a." + campo + " desc";
    }

    private List<Tabela> preparaTabela(String campo, PreparedStatement stmt) throws SQLException {
        List<Tabela> lista = new ArrayList<>();
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Tabela t = new Tabela();
            t.setAno(rs.getInt("ano"));
            t.setDetalhamento(rs.getString(campo));
            t.setMes(rs.getString("nome_mes"));
            t.setTotal(rs.getString("total").replace(".", ","));
            t.setUnidadeGestora(rs.getString("nomeunidadegestora"));
            lista.add(t);
        }
        return lista;
    }
}

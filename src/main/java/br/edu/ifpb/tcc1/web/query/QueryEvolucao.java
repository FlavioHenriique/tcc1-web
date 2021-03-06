package br.edu.ifpb.tcc1.web.query;

import br.edu.ifpb.tcc1.web.model.Series;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

@Stateless
public class QueryEvolucao {
    
    private Connection conn;
    
    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }
    
    public List<Series> anos(int ano1, int ano2, String funcao) {
        
        String sql = "select d.ano, d.nome_mes,  sum(e.valor) as total\n"
                + "from empenho e join acao a on a.codigoacao = e.codacao\n"
                + "join data d on e.coddata = d.codigo \n"
                + "where d.ano between ? and ? \n";
        if (!funcao.equals("")) {
            sql += "and a.nomefuncao = ? \n";
        }
        sql += "group by d.ano, d.nome_mes, d.numero_mes\n"
                + "order by d.ano, d.numero_mes \n";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            if (!funcao.equals("")) {
                stmt.setString(3, funcao);
            }
            ResultSet rs = stmt.executeQuery();
            return dados(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Series> semestres(int semestre1, int semestre2, String funcao) {
        
        StringBuilder sql = new StringBuilder();
        sql.append("select d.ano, d.nome_mes,  sum(e.valor) as total\n"
                + "from empenho e join acao a on a.codigoacao = e.codacao\n"
                + "join data d on e.coddata = d.codigo \n"
                + "where d.semestre in (?, ?)  \n");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? \n");
        }
        sql.append("group by d.ano, d.nome_mes, d.numero_mes\n"
                + "order by d.ano, d.numero_mes \n");
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, semestre1);
            stmt.setInt(2, semestre2);
            if (!funcao.equals("")) {
                stmt.setString(3, funcao);
            }
            ResultSet rs = stmt.executeQuery();
            return dados(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Object[]> anos2(int ano1, int ano2, String funcao) {
        
        String sql = "select d.ano, d.nome_mes,  sum(e.valor) as total\n"
                + "from empenho e join acao a on a.codigoacao = e.codacao\n"
                + "join data d on e.coddata = d.codigo \n"
                + "where d.ano between ? and ? \n";
        if (!funcao.equals("")) {
            sql += "and a.nomefuncao = ? \n";
        }
        sql += "group by d.ano, d.nome_mes, d.numero_mes\n"
                + "order by d.ano, d.numero_mes \n";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            if (!funcao.equals("")) {
                stmt.setString(3, funcao);
            }
            ResultSet rs = stmt.executeQuery();
            return dados2(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Object[]> semestres2(int semestre1, int semestre2, String funcao) {
        
        StringBuilder sql = new StringBuilder();
        sql.append("select d.ano, d.nome_mes,  sum(e.valor) as total\n"
                + "from empenho e join acao a on a.codigoacao = e.codacao\n"
                + "join data d on e.coddata = d.codigo \n"
                + "where d.semestre in " + sqlSemestres(semestre1, semestre2) + "  \n");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? \n");
        }
        sql.append("group by d.ano, d.nome_mes, d.numero_mes\n"
                + "order by d.ano, d.numero_mes \n");
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            if (!funcao.equals("")) {
                stmt.setString(1, funcao);
            }
            ResultSet rs = stmt.executeQuery();
            return dados2(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Object[]> meses2(int mes1, int mes2, String funcao) {
        
        StringBuilder sql = new StringBuilder();
        sql.append("select d.ano, d.nome_mes,  sum(e.valor) as total\n"
                + "from empenho e join acao a on a.codigoacao = e.codacao\n"
                + "join data d on e.coddata = d.codigo \n"
                + "where d.codigo between ? and ? \n");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? \n");
        }
        sql.append("group by d.ano, d.nome_mes, d.numero_mes\n"
                + "order by d.ano, d.numero_mes \n");
        
        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, mes1);
            stmt.setInt(2, mes2);
            if (!funcao.equals("")) {
                stmt.setString(3, funcao);
            }
            ResultSet rs = stmt.executeQuery();
            return dados2(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    public List<Series> dados(ResultSet rs) throws SQLException {
        List<Series> lista = new ArrayList<>();
        List<BigDecimal> valores = new ArrayList<>();
        List<Integer> anos = new ArrayList<>();
        
        while (rs.next()) {
            
            int anoAtual = rs.getInt("ano");
            
            if (anos.isEmpty()) {
                anos.add(anoAtual);
            }
            if (!anos.contains(anoAtual)) {
                Series series = new Series();
                series.setName(anos.get(anos.size() - 1) + "");
                series.setData(valores);
                lista.add(series);
                anos.add(anoAtual);
                valores = new ArrayList<>();
            }
            valores.add(rs.getBigDecimal("total"));
        }
        Series series = new Series();
        series.setName(anos.get(anos.size() - 1) + "");
        series.setData(valores);
        lista.add(series);
        valores = new ArrayList<>();
        return lista;
    }
    
    private List<Object[]> dados2(ResultSet rs) throws SQLException {
        
        List<Object[]> valores = new ArrayList<>();
        
        while (rs.next()) {
            valores.add(new Object[]{rs.getString("nome_mes") + " "
                + rs.getString("ano"), rs.getBigDecimal("total"),});
        }
        return valores;
    }
    
    private String sqlSemestres(int semestre1, int semestre2) {
        
        StringBuilder sql = new StringBuilder();
        
        List<Integer> anos = new ArrayList<>();
        String ano1 = semestre1 + "";
        String ano2 = semestre2 + "";
        String sem1 = ano1.charAt(0) + "";
        String sem2 = ano2.charAt(0) + "";
        
        ano1 = ano1.substring(1, ano1.length());
        ano2 = ano2.substring(1, ano2.length());
        
        int anoAtual = Integer.parseInt(ano1);
        boolean limite = false;
        while (!limite) {
            anos.add(++anoAtual);
            limite = (anoAtual == Integer.parseInt(ano2));
        }
        sql.append("(").append(semestre1);
        
        if (sem1.equals("1")) {
            sql.append(",2" + ano1);
        }
        
        for (int a : anos) {
            if (a == Integer.parseInt(ano2)) {
                if (sem2.equals("2")) {
                    sql.append(",1").append(ano2);
                }
                sql.append(",").append(semestre2);
            } else {
                sql.append(",1").append(a);
                sql.append(",2").append(a);
            }
        }
        sql.append(")");
        return sql.toString();
    }
    
}

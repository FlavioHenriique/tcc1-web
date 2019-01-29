package br.edu.ifpb.tcc1.web.query;

import br.edu.ifpb.tcc1.web.model.Series;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class QueryEvolucao {

    private Connection conn;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public List<Series> anos(int ano1, int ano2) {

        String sql = "select d.ano, d.nome_mes,  sum(e.valor) as total\n"
                + "from empenho e join acao a on a.codigoacao = e.codacao\n"
                + "join data d on e.coddata = d.codigo\n"
                + "where d.ano between ? and ? \n"
                + "group by d.ano, d.nome_mes, d.numero_mes\n"
                + "order by d.ano, d.numero_mes \n";
        System.out.println(sql);
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, ano1);
            stmt.setInt(2, ano2);
            ResultSet rs = stmt.executeQuery();
            return dados(rs);
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
}

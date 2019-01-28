package br.edu.ifpb.tcc1.web.query;

import br.edu.ifpb.tcc1.web.model.GraficoDiferenca;
import br.edu.ifpb.tcc1.web.model.GraficoDiferenca2;
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
public class QueryDiferenca {

    private Connection conn;
    @Inject
    private QueryIntervalos intervalos;

    @PostConstruct
    public void init() {
        conn = Conexao.getConnection();
    }

    public GraficoDiferenca funcoesAnos(int ano1, int ano2, String funcao) {
        StringBuilder sql = new StringBuilder();
        sql.append("select d.ano, sum(e.valor) as total");
        if (!funcao.equals("")) {
            sql.append(", a.nomefuncao ");
        }
        sql.append(" from  empenho e join data d on e.coddata = d.codigo "
                + "join acao a on a.codigoacao = e.codacao where d.ano = ? ");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? ");
        }
        sql.append("group by d.ano ");
        if (!funcao.equals("")) {
            sql.append(" ,a.nomefuncao ");
        }
        sql.append(" union all ");
        sql.append("select d.ano, sum(e.valor) as total");
        if (!funcao.equals("")) {
            sql.append(", a.nomefuncao ");
        }
        sql.append(" from  empenho e join data d on e.coddata = d.codigo "
                + "join acao a on a.codigoacao = e.codacao where d.ano = ? ");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? ");
        }
        sql.append("group by d.ano ");
        if (!funcao.equals("")) {
            sql.append(" ,a.nomefuncao ");
        }

        try {
            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, ano1);
            if (!funcao.equals("")) {
                stmt.setInt(3, ano2);
                stmt.setString(2, funcao);
                stmt.setString(4, funcao);
            } else {
                stmt.setInt(2, ano2);
            }
            ResultSet rs = stmt.executeQuery();
            List<BigDecimal> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getBigDecimal("total"));
            }
            return teste(valores);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public GraficoDiferenca funcoesSemestre(int semestre1, int semestre2, String funcao) {
        StringBuilder sql = new StringBuilder();
        sql.append("select d.ano, sum(e.valor) as total");
        if (!funcao.equals("")) {
            sql.append(", a.nomefuncao ");
        }
        sql.append(" from  empenho e join data d on e.coddata = d.codigo "
                + "join acao a on a.codigoacao = e.codacao where d.semestre = ? ");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? ");
        }
        sql.append("group by d.ano ");
        if (!funcao.equals("")) {
            sql.append(" ,a.nomefuncao ");
        }
        sql.append(" union all ");
        sql.append("select d.ano, sum(e.valor) as total");
        if (!funcao.equals("")) {
            sql.append(", a.nomefuncao ");
        }
        sql.append(" from  empenho e join data d on e.coddata = d.codigo "
                + "join acao a on a.codigoacao = e.codacao where d.semestre = ? ");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? ");
        }
        sql.append("group by d.ano ");
        if (!funcao.equals("")) {
            sql.append(" ,a.nomefuncao ");
        }

        try {

            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, semestre1);
            if (!funcao.equals("")) {
                stmt.setInt(3, semestre2);
                stmt.setString(2, funcao);
                stmt.setString(4, funcao);
            } else {
                stmt.setInt(2, semestre2);
            }
            ResultSet rs = stmt.executeQuery();
            List<BigDecimal> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getBigDecimal("total"));
            }
            return teste(valores);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public GraficoDiferenca funcoesMeses(int mes1, int mes2, String funcao) {
           StringBuilder sql = new StringBuilder();
        sql.append("select d.ano, sum(e.valor) as total");
        if (!funcao.equals("")) {
            sql.append(", a.nomefuncao ");
        }
        sql.append(" from  empenho e join data d on e.coddata = d.codigo "
                + "join acao a on a.codigoacao = e.codacao where d.codigo = ? ");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? ");
        }
        sql.append("group by d.ano ");
        if (!funcao.equals("")) {
            sql.append(" ,a.nomefuncao ");
        }
        sql.append(" union all ");
        sql.append("select d.ano, sum(e.valor) as total");
        if (!funcao.equals("")) {
            sql.append(", a.nomefuncao ");
        }
        sql.append(" from  empenho e join data d on e.coddata = d.codigo "
                + "join acao a on a.codigoacao = e.codacao where d.codigo = ? ");
        if (!funcao.equals("")) {
            sql.append("and a.nomefuncao = ? ");
        }
        sql.append("group by d.ano ");
        if (!funcao.equals("")) {
            sql.append(" ,a.nomefuncao ");
        }

        try {

            PreparedStatement stmt = conn.prepareStatement(sql.toString());
            stmt.setInt(1, mes1);
            if (!funcao.equals("")) {
                stmt.setInt(3, mes2);
                stmt.setString(2, funcao);
                stmt.setString(4, funcao);
            } else {
                stmt.setInt(2, mes2);
            }
            ResultSet rs = stmt.executeQuery();
            List<BigDecimal> valores = new ArrayList<>();
            while (rs.next()) {
                valores.add(rs.getBigDecimal("total"));
            }
            return teste(valores);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private GraficoDiferenca preparaValores(GraficoDiferenca grafico, List<Object[]> lista1, List<Object[]> lista2) {
        List<BigDecimal> valores1 = new ArrayList<>();
        List<BigDecimal> valores2 = new ArrayList<>();

        lista1.forEach(v -> valores1.add((BigDecimal) v[1]));
        lista2.forEach(v -> valores2.add((BigDecimal) v[1]));

        grafico.setValoresPrimeiroIntervalo(valores1);
        grafico.setValoresSegundoIntervalo(valores2);
        List<String> categorias = new ArrayList<>();
        if (lista1.size() > lista2.size()) {
            lista1.forEach(v -> categorias.add((String) v[0]));
        } else {
            lista2.forEach(v -> categorias.add((String) v[0]));
        }
        grafico.setCategorias(categorias);
        return grafico;
    }

    private GraficoDiferenca teste(List<BigDecimal> valores) {
        GraficoDiferenca grafico = new GraficoDiferenca();
        List<BigDecimal> lista1 = new ArrayList<>();
        List<BigDecimal> lista2 = new ArrayList<>();
        lista1.add(valores.get(0));
        lista2.add(valores.get(1));
        grafico.setValoresPrimeiroIntervalo(lista1);
        grafico.setValoresSegundoIntervalo(lista2);

        return grafico;
    }
}

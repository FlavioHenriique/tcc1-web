package br.edu.ifpb.tcc1.web.query;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        System.out.println(sqlSemestres(22014, 12018));
    }

    private static String sqlSemestres(int semestre1, int semestre2) {

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

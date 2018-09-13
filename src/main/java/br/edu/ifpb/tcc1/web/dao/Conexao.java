package br.edu.ifpb.tcc1.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static final String url = "jdbc:postgresql://localhost:5432/tcc";
    private static final String user = "postgres";
    private static final String password = "flavio22";

    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return  DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

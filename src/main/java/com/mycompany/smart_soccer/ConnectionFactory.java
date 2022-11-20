package com.mycompany.smart_soccer;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private String usuario ="zgogwwkb";
    private String senha = "VcQUP5Zkf57C0IcCZYkTeNTeX0zF3FHT";
    private String host = "amendoim.db.elephantsql.com";
    private String porta = "5432";
    private String db = "zgogwwkb";

    public static Connection obterConexao() throws Exception {
    String url = String.format(
            "jdbc:postgresql://%s:%s/%s";
            host,
            porta,
            db
    );
    return DriverManager.getConnection(url, usuario, senha);
    }
}



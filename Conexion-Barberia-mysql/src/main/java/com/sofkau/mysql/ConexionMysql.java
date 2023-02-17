package com.sofkau.mysql;

import java.sql.Connection;

public class ConexionMysql {
    private static String url = "jdbc:mysql://localhost:3306/barberia";
    private static String username = "root";
    private static String password = "sasa";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = java.sql.DriverManager.getConnection(url, username, password);
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return connection;
    }
}
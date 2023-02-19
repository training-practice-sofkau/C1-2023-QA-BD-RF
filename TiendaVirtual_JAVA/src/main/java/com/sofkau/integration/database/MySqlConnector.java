package com.sofkau.integration.database;

import java.sql.*;

public class MySqlConnector {
    private String connectionString;
    private String dbName = "";
    private String dbUser = "";
    private String dbPassword = "";

    Connection connection;

    public MySqlConnector (String dbName, String dbUser, String dbPassword){
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    public void connect(){
        try{
            if(this.connection == null){
                Class.forName("com.mysql.cj.jdbc.Driver");
                System.out.println("Conectándose a mysql");
                this.connectionString = "jdbc:mysql://localhost:3306/" + this.dbName;
                this.connection = DriverManager.getConnection(
                        this.connectionString,
                        this.dbUser,
                        this.dbPassword
                );
                if (this.connection == null){
                    System.out.println("Error de conexión");
                } else {
                    System.out.println("Conexión exitosa");
                }
            }
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void closeConnection (){
        try {
            if(this.connection != null){
                this.connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public PreparedStatement getStatement(String sql){
        try{
            return this.connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }


    public CallableStatement getCallable (String sql){
        try{
            return this.connection.prepareCall(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean insert(PreparedStatement statement){
        try{
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(CallableStatement procedure){
        try{
            int rowsInserted = procedure.executeUpdate();
            return rowsInserted > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public Connection getConnector(){
        return this.connection;
    }
}

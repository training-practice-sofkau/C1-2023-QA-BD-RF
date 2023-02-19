package com.sofkau.integration.database;
import java.sql.*;

/**
 * Esta clase permite gestionar la conexión de BD con MySql, utilizando MySQl Driver.
 */
public class MySqlConnector {
    /**
     * Atributos
     */
    private String connectionString;
    private String dbName = "";
    private String dbUser = "";
    private String dbPassword = "";
    Connection connection;

    /**
     * Constructor
     * @param dbName
     * @param dbUser
     * @param dbPassword
     */
    public MySqlConnector (String dbName, String dbUser, String dbPassword){
        this.dbName = dbName;
        this.dbUser = dbUser;
        this.dbPassword = dbPassword;
    }

    /**
     * Este método abre la conexión a la BD
     */
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

    /**
     * Este método cierra la conexión a la BD
     * Nota: Es importante cerrar la conexión para liberar recursos de memoria.
     */
    public void closeConnection (){
        try {
            if(this.connection != null){
                this.connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    /**
     * Permite crear consultas SELECT, INSERT, UPDATE, DELETE
     * @param sql
     * @return
     */
    public PreparedStatement getStatement(String sql){
        try{
            return this.connection.prepareStatement(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Permite hacer llamadas a procedimientos almacenados
     * @param sql
     * @return
     */
    public CallableStatement getCallable (String sql){
        try{
            return this.connection.prepareCall(sql);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Permite ejecutar un insert utilizando un statement (INSERT INTO, UPDATE, DELETE)
     * @param statement
     * @return
     */
    public boolean insert(PreparedStatement statement){
        try{
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Permite ejecutar un insert llamando un procedimiento almacenado
     * @param procedure
     * @return
     */
    public boolean insert(CallableStatement procedure){
        try{
            int rowsInserted = procedure.executeUpdate();
            return rowsInserted > 0;
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}

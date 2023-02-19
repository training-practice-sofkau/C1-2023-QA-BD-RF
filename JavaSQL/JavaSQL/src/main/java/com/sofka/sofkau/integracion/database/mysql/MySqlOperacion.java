package com.sofka.sofkau.integracion.database.mysql;

import com.sofka.sofkau.integracion.database.IDataBase;

import java.sql.*;

public class MySqlOperacion implements IDataBase {
    private Connection conexion = null;

    private Statement instruccion = null;

    private ResultSet resultado = null;
    private String instruccionSql;

    private String servidor;

    private String nombreBaseDatos;

    private String usuario;

    private String contrasena;
    public String getInstruccionSql() {
        return instruccionSql;
    }
    public void setInstruccionSql(String instruccionSql) {
        this.instruccionSql = instruccionSql;
    }
    public String getServidor() {
        return servidor;
    }
    public void setServidor(String servidor) {
        this.servidor = servidor;
    }
    public String getNombreBaseDatos() {
        return nombreBaseDatos;
    }
    public void setNombreBaseDatos(String nombreBaseDatos) {
        this.nombreBaseDatos = nombreBaseDatos;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    @Override
    public void configuracionConexionBD() {
        try {
            Class.forName(MySqlConstantes.MY_SQL_JDBC_DRIVER);
            conexion= DriverManager.getConnection(
                    String.format(MySqlConstantes.STRING_CONEXION,
                            this.servidor,
                            this.nombreBaseDatos,
                            this.usuario,
                            this.contrasena)
            );
            instruccion=conexion.createStatement();
        }catch (Exception e){
            cerrar();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void ejecutarInstruccionSQL() {
        try {
            configuracionConexionBD();
            resultado = instruccion.executeQuery(instruccionSql);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ResultSet obtenerResultado() {
        return resultado;
    }

    @Override
    public void cerrar() {
        try {
            if (resultado != null) {
                resultado.close();
            }
            if (instruccion != null) {
                instruccion.close();
            }
            if (conexion != null) {
                conexion.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void imprimirResultados() throws SQLException {
        ResultSetMetaData resultSetMetaData = resultado.getMetaData();
        int totalColumnNumber = resultSetMetaData.getColumnCount();
        while (resultado.next()){
            for (int columnNumber = 1; columnNumber <= totalColumnNumber; columnNumber++){
                if (columnNumber > 1) {
                    System.out.print(",\t");
                }
                String columnValue = resultado.getString(columnNumber);
                System.out.print(resultSetMetaData.getColumnName(columnNumber)+ ": " + columnValue);
            }
            System.out.print("");
        }
    }

    @Override
    public void ejecutarInstruccionSqlVoid() {
        try {
            configuracionConexionBD();
            instruccion.execute(instruccionSql);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

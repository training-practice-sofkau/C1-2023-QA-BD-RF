package com.sofka.sofkau.integracion.database;
import java.sql.ResultSet;
import java.sql.SQLException;
public interface IDataBase {
    void configuracionConexionBD();
    void ejecutarInstruccionSQL();
    ResultSet obtenerResultado();
    void cerrar();
    void imprimirResultados() throws SQLException;
    void ejecutarInstruccionSqlVoid();
}

package com.sofka.sofkau.integracion.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDataBase {
    void configuracionconexionBD();
    void ejecutarInstruccionSQL();
    ResultSet obtenerResultado();
    void close();
    void imprimirResultados() throws SQLException;
}

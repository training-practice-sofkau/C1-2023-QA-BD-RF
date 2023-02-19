package org.sofka.integration.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {

    public void configureDatabaseconetion();
    public void executeSqlStatement();
    public void executeSqlStatementVoid();
    public ResultSet  getResultset();
    public void close();
    public void printResultset() throws SQLException;

}

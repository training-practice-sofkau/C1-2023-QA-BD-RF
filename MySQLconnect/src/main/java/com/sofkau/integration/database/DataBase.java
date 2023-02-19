package com.sofkau.integration.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {

    public void configurateDataBaseConnection();
    public void executeSqlStatement();
    public ResultSet getResulset();
    public void close();
    public void printResulset()throws SQLException;

    public void executeSqlStatementVoid();

}

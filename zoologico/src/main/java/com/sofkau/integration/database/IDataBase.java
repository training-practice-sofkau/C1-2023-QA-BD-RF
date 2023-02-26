package com.sofkau.integration.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDataBase {
    public void configureDataBaseConnection();

    public void executeSqlStatement();

    public void executeInsertStatement();

    public ResultSet getResultset();

    public void close();

    public void printResultset() throws SQLException;
}

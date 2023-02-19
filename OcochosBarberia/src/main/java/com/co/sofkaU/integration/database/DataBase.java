package com.co.sofkaU.integration.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {

    void configureDBConnection();

    void executeSQLStatement();

    ResultSet getResultSet();

    void closeConnection();

    void printResultSet() throws SQLException;
}

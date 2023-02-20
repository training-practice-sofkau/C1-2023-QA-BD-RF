package com.co.sofkaU.integration.database;

import java.sql.SQLException;

public interface DataBase {

    void configureDBConnection();

    void executeSelectStatement();

    void executeInsertStatement();

    void closeConnection();

    void printResultSet() throws SQLException;
}

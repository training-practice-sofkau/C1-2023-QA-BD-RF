package com.sofkau;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {

    public void configureDataBaseConnection();

    public void executeSqlStatement();
    public void executeSqlStatementVoid();


    public ResultSet getResultset();

    public void close();

    public void printResultset() throws SQLException;



}

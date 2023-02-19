package com.sofkau.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DataBase {

    public void configureDataBaseConnection();
    public void executeSqlStatement();
    public ResultSet  getResulset();
    public void close();
    public  void printResulset() throws SQLException;
}

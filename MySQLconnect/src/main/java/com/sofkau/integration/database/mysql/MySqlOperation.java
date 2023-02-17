package com.sofkau.integration.database.mysql;

import com.sofkau.integration.database.DataBase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlOperation implements DataBase {

    private Connection connection = null;

    private Statement statement = null;

    private ResultSet resultSet = null;

    @Override
    public void configurateDataBaseConnection() {

    }

    @Override
    public void executeSqlStatement() {

    }

    @Override
    public ResultSet getResulset() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void printResulset() throws SQLException {

    }
}

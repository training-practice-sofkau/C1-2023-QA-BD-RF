package com.co.sofkaU.integration.database.mysql;

import com.co.sofkaU.integration.database.DataBase;
import lombok.Data;

import java.sql.*;

import static com.co.sofkaU.integration.database.mysql.MySQLConstant.CONNECTION_STRING;
import static com.co.sofkaU.integration.database.mysql.MySQLConstant.MY_SQL_JDBC_DRIVER;

@Data
public class MySQLOperation implements DataBase {

    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String sqlStatement;
    private String socket;
    private String dbName;
    private String user;
    private String password;

    @Override
    public void configureDBConnection() {
        try {
            Class.forName(MY_SQL_JDBC_DRIVER);
            connection = DriverManager.getConnection(String.format(CONNECTION_STRING, socket, dbName, user, password));
            statement = connection.createStatement();
        } catch (Exception e) {
            closeConnection();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void executeSQLStatement() {
        try {
            configureDBConnection();
            resultSet = statement.executeQuery(sqlStatement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ResultSet getResultSet() {
        return resultSet;
    }

    @Override
    public void closeConnection() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printResultSet() throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int totalColNum = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            for (int colNum = 1; colNum <= totalColNum; colNum++) {
                if (colNum > 1) {
                    System.out.print(",\t");
                }
                String colValue = resultSet.getString(colNum);
                System.out.print(resultSetMetaData.getColumnName(colNum) + ": " + colValue);
            }
            System.out.println();
        }
    }
}

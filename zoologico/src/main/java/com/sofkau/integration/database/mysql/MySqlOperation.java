package com.sofkau.integration.database.mysql;

import com.sofkau.integration.database.IDataBase;

import java.sql.*;

import static com.sofkau.integration.database.mysql.MySqlConstant.CONNECTION_STRING;
import static com.sofkau.integration.database.mysql.MySqlConstant.MY_SQL_JDBC_DRIVER;

public class MySqlOperation implements IDataBase {


    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private String sqlStatement;
    private String server;
    private String dataBaseName;
    private String user;
    private String password;
    @Override
    public void configureDataBaseConnection() {
        try {
            Class.forName(MY_SQL_JDBC_DRIVER);
            connection = DriverManager.getConnection(
                    String.format(CONNECTION_STRING,
                            this.server,
                            this.dataBaseName,
                            this.user,
                            this.password)
            );
            statement = connection.createStatement();


        } catch (Exception e) {
            close();
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void executeSqlStatement() {
        try {
            configureDataBaseConnection();
            resultSet = statement.executeQuery(sqlStatement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void executeInsertStatement() {
        try {
            configureDataBaseConnection();
            statement.execute(sqlStatement);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public ResultSet getResultset() {
        return resultSet;
    }

    @Override
    public void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null){
                connection.close();
            }

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void printResultset() throws SQLException {
        ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
        int totalColumnNumber = resultSetMetaData.getColumnCount();
        while (resultSet.next()) {
            for (int columnNumber = 1; columnNumber <= totalColumnNumber; columnNumber++) {
                if (columnNumber > 1) {
                    System.out.print(",\t");
                }
                String columnValue = resultSet.getString(columnNumber);
                System.out.print(resultSetMetaData.getColumnName(columnNumber) + ": " + columnValue);

            }
            System.out.println("");
        }

    }

    public String getSqlStatement() {
        return this.sqlStatement;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public String getServer() {
        return this.server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDataBaseName() {
        return this.dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

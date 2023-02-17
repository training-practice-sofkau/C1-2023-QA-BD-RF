package com.sofkau.integration.mysql;

import java.sql.*;

import static com.sofkau.integration.mysql.MySqlConstants.CONNECTION_STRING;
import static com.sofkau.integration.mysql.MySqlConstants.MY_SQL_JDBC_DRIVER;

public class MySqlOperation implements DataBase{

    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;
    private String sqlStatement;
    private String server;
    private String dataBaseName;
    private String user;

    public String getSqlStatement() {
        return sqlStatement;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDataBaseName() {
        return dataBaseName;
    }

    public void setDataBaseName(String dataBaseName) {
        this.dataBaseName = dataBaseName;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
    @Override
    public void configureDataBaseConnection() {
        try{
            Class.forName(MY_SQL_JDBC_DRIVER);
            connection= DriverManager.getConnection(
                    String.format(CONNECTION_STRING,
                            this.server,
                            this.dataBaseName,
                            this.user,
                            this.password));
            statement=connection.createStatement();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void executeSqlStatement() {
        try {
            configureDataBaseConnection();
            resultSet = statement.executeQuery(sqlStatement);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ResultSet getResultSet() {
        return resultSet;
    }

    @Override
    public void close() {
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void printResultSet() throws SQLException {
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        int totalColumNumber=resultSetMetaData.getColumnCount();
        while(resultSet.next()){
            for(int columNumber=1;columNumber<=totalColumNumber;columNumber++){
                String columnValue=resultSet.getString(columNumber);
                System.out.print(resultSetMetaData.getColumnName(columNumber)+": "+columnValue+", ");
            }
            System.out.println();
        }
    }

    @Override
    public void executeSqlStatementVoid() {
        try{
            configureDataBaseConnection();
            statement.execute(sqlStatement);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}

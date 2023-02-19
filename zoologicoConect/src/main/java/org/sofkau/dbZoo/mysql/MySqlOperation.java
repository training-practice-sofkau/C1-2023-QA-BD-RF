package org.sofkau.dbZoo.mysql;

import org.sofkau.dbZoo.DBzoo;

import java.sql.*;

import static org.sofkau.dbZoo.mysql.MySqlConstans.CONNECTION_STRING;
import static org.sofkau.dbZoo.mysql.MySqlConstans.MY_SQL_JDBC_DRIVER;

public class MySqlOperation implements DBzoo {

    private Connection connection=null;
    private Statement statement=null;
    private ResultSet resultSet=null;
    private String sqlStatement;
    private String server;
    private String dataBaseName;
    private String user;
    private String password;
    private  PreparedStatement preparedStatement;


    public void setSqlPreparedStatement(String sql) throws SQLException{
        configureDataBaseConnection();
        preparedStatement=connection.prepareStatement(sql);
    }
    public PreparedStatement getPreparedStatement(){
        return preparedStatement;
    }

    public void executeSqlPreparedStatement() throws SQLException{
        preparedStatement.execute();

    }
    public ResultSet executeQuery() throws SQLException{
        return preparedStatement.executeQuery();
    }


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

    @Override
    public void configureDataBaseConnection() {
        try {
            Class.forName(MY_SQL_JDBC_DRIVER);
            connection= DriverManager.getConnection(
                    String.format(CONNECTION_STRING,
                            this.server,
                            this.dataBaseName,
                            this.user,
                            this.password)
            );
            statement=connection.createStatement();
        }catch (Exception e){
            close();
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


    public void executeSqlStatementVoid() {
        try {
            configureDataBaseConnection();
            statement.execute(sqlStatement);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    @Override
    public ResultSet getResulset() {
        return resultSet;
    }

    @Override
    public void close() {
        try{
            if (resultSet != null){
                resultSet.close();
            }
            if (statement != null){
                statement.close();
            }
            if (connection != null){
                connection.close();
            }
            if (preparedStatement != null){
                preparedStatement.close();
            }

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void printResulset() throws SQLException {
        ResultSetMetaData resultSetMetaData =resultSet.getMetaData();
        int totalColumnNumber = resultSetMetaData.getColumnCount();
        while (resultSet.next()){
            for (int columnNumber = 1;columnNumber <=totalColumnNumber; columnNumber++){
                if (columnNumber >1){
                    System.out.print(",\t");
                }
                String columnValue = resultSet.getString(columnNumber);
                System.out.print(resultSetMetaData.getColumnName(columnNumber) + ": "+ columnValue    );
            }
            System.out.println(" ");
        }


    }

}


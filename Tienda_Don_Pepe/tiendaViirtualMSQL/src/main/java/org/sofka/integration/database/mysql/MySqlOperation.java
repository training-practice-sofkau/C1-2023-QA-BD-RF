package org.sofka.integration.database.mysql;

import org.sofka.integration.database.DataBase;

import java.sql.*;

import static org.sofka.integration.database.mysql.MySqlConstans.*;


public class MySqlOperation implements DataBase {

    private Connection connection=null;
    private Statement statement = null;
    private ResultSet resultSet = null;

    private String sqlStatement ;
    private String server;
    private String dataBaseName;
    private String user;
    private String password;

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
    public void configureDatabaseconetion() {
        try {
            Class.forName(MY_SQL_JDBC_DRIVER);

            connection=DriverManager.getConnection(
                    String.format(CONNECTION_STRING,
                            this.server,
                            this.dataBaseName,
                            this.user,
                            this.password ));
            statement =connection.createStatement();
        }
        catch (Exception e){
            close();
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void executeSqlStatement() {
        try {
            configureDatabaseconetion();
            resultSet = statement.executeQuery(sqlStatement);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void executeSqlStatementVoid() {
        try {
            configureDatabaseconetion();
            statement.execute(sqlStatement);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ResultSet getResultset() {
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
    public void printResultset() throws SQLException {
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
        int totalColumnNumber= resultSetMetaData.getColumnCount();
        while (resultSet.next()){
                for(int c=1 ;c<= totalColumnNumber;c++){
                    if(c > 1){
                        System.out.println(",\t");
                    }
                    String columnValue = resultSet.getString(c);
                    System.out.print(resultSetMetaData.getColumnName(c)+ ": "+columnValue);
                }
            System.out.println(" ");
        }
    }

    public  void  myOpenConnection(){
        this.setServer(SERVER);
        this.setDataBaseName(DATA_BASE_NAME);
        this.setUser(USER);
        this.setPassword(PASSWORD);
    }

    public   void  myExecuteQuery(String sql){
        myOpenConnection();
        this.setSqlStatement(sql);
        this.executeSqlStatement();
    };

    public   void  myExecuteInsertUpdate(String sql){
        myOpenConnection();
        setSqlStatement(sql);
        executeSqlStatementVoid();
        myCloseConnection();
    };
    public   void  myCloseConnection(){
        this.close();
    };


}

package com.co.sofkaU;

import com.co.sofkaU.integration.database.mysql.MySQLOperation;

import java.sql.SQLException;

public class Main {

    private static final String SOCKET = "localhost:3306";
    private static final String DBNAME = "ocochosBarberia";
    private static final String USER = "ococho";
    private static final String PASSWORD = "hola123";

    private static final String SELECT = "select * from cliente";
    private static final MySQLOperation mySQLOp = new MySQLOperation();

    public static void main(String[] args) throws SQLException {
        openConnection();
        select();
        closeConnection();
    }

    public static void openConnection() {
        mySQLOp.setSocket(SOCKET);
        mySQLOp.setDbName(DBNAME);
        mySQLOp.setUser(USER);
        mySQLOp.setPassword(PASSWORD);
    }

    public static void select() throws SQLException {
        mySQLOp.setSqlStatement(SELECT);
        mySQLOp.executeSQLStatement();
        mySQLOp.printResultSet();
    }

    public static void closeConnection() {
        mySQLOp.closeConnection();
    }
}

package com.co.sofkaU.integration.database.mysql;

import java.sql.SQLException;

public class MySQLQuery {
    private static final String SOCKET = "localhost:3306";
    private static final String DBNAME = "ocochosBarberia";
    private static final String USER = "ococho";
    private static final String PASSWORD = "hola123";
    private static final MySQLOperation mySQLOp = new MySQLOperation();

    public static final String SELECT = "select * from cliente";

    public static void openConnection() {
        mySQLOp.setSocket(SOCKET);
        mySQLOp.setDbName(DBNAME);
        mySQLOp.setUser(USER);
        mySQLOp.setPassword(PASSWORD);
    }

    public static void select(String select) throws SQLException {
        mySQLOp.setSqlStatement(select);
        mySQLOp.executeSelectStatement();
        mySQLOp.printResultSet();
    }

    public static void insert(String insert) {
        mySQLOp.setSqlStatement(insert);
        mySQLOp.executeInsertStatement();
    }

    public static void closeConnection() {
        mySQLOp.closeConnection();
    }

}

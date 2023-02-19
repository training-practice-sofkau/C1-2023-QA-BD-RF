package com.co.sofkaU;

import java.sql.SQLException;

import static com.co.sofkaU.integration.database.mysql.MySQLQuery.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        openConnection();
        select(SELECT);
        closeConnection();
    }
}

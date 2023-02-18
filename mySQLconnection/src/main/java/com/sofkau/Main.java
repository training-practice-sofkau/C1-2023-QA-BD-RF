package com.sofkau;

import com.sofkau.database.mysql.MySqlOperation;

import java.sql.SQLException;

public class Main {

    public static final String SERVER="localhost";
    private static final String DATA_BASE_NAME="tiendadonpepe";
    private static final String USER="root";
    private static final String PASSWORD="2805";
    private static final String SELECT_ALL_FROM_CATEGORIA=String.format("select * from %s.categoria",DATA_BASE_NAME);
    private static final String INSERT_CATEGORIA= null;

    private static final MySqlOperation mysqlOperation= new MySqlOperation();

    public static void main(String[] args) throws SQLException {
        openConnection();
        insertCategoria("12","lala","ndsfkns","se agrega");
        //closeConnection();
        for (int i=0;i<=5;i++){

        }
    }

    public static void openConnection(){
        mysqlOperation.setServer(SERVER);
        mysqlOperation.setDataBaseName(DATA_BASE_NAME);
        mysqlOperation.setUser(USER);
        mysqlOperation.setPassword(PASSWORD);
    }
    public static void selectAllFromCategoria() throws SQLException {
        mysqlOperation.setSqlStatement(SELECT_ALL_FROM_CATEGORIA);
        mysqlOperation.executeSqlStatement();
        mysqlOperation.printResulset();

    }
    public static void insertCategoria(String id_categoria,String nombre,String almacenamiento,String observadiones) throws SQLException{
        String INSERT_CATEGORIA= String.format("insert into categoria (id_categoria,nombre,almacenamiento,observaciones) values ("+id_categoria+","+nombre+","+almacenamiento+","+observadiones+")",DATA_BASE_NAME);
        mysqlOperation.setSqlStatement(INSERT_CATEGORIA);
        mysqlOperation.executeSqlStatementVoid();

    }
    public static void closeConnection(){
        mysqlOperation.close();
    }
}
//=String.format("insert into categoria values ('15','despensa','calor','bladbajdba')",DATA_BASE_NAME);
//INSERT INTO `tiendadonpepe`.`categoria` (`id_categoria`, `nombre`, `almacenamiento`, `observaciones`) VALUES ('12', 'aseo', 'seco', 'almacenar aparte');
package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;

import java.sql.SQLException;

public class Main {


    private static final String SERVER="localhost";
    private static final String DATA_BASE_NAME="zoo_santafe";
    private static final String USER="root";
    private static final String PASSWORD="Elvelo0820";

    private static final String SELECT_ALL_FROM_ANIMALES=String.format("select * from %s.animal",DATA_BASE_NAME);
    private static final MySqlOperation mySqlOperation= new MySqlOperation();

    public static void main(String[] args) throws SQLException{
        /*
        openConnection();
        inserIntoAnimal();
        setSelectAllFromAnimales();
        closeConnection();

         */
        Faker faker = new Faker();
        System.out.println(faker.animal().name());
    }


    private static void inserIntoAnimal() {
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_ANIMALES);
        mySqlOperation.executeSqlStatementVoid();
    }
    public static void openConnection(){
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void setSelectAllFromAnimales()throws SQLException{
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_ANIMALES);
        mySqlOperation.executeSqlStatement();
        mySqlOperation.printResulset();
    }

    public static void closeConnection(){
        mySqlOperation.close();

    }



}
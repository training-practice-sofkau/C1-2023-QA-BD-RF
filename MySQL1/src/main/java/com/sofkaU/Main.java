package com.sofkaU;

import com.github.javafaker.Faker;
import com.sofkaU.integration.database.models.Proveedor;
import com.sofkaU.integration.database.mysql.MySqlOperation;

public class Main {
    /**
     * Credenciales para ingresar a la base de datos.
     */
    private static final String SERVER="localhost:3307";
    private static final String DATA_BASE_NAME="barberia";
    private static final String USER="root";
    private static final String PASSWORD="admi";

    private static final MySqlOperation mySqlOperation= new MySqlOperation();
    private static Faker faker = new Faker();

    public static void main(String[] args) {
        openConnection();
        insertarProveedor();

    }
    public static void openConnection(){
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void closeConnection(){
        mySqlOperation.close();

    }

    private static void insertarProveedor(){

        for (int i = 1; i < 5; i++) {
            Proveedor prov = new Proveedor();
            prov.setNit(faker.number().numberBetween(300,400));
            prov.setNombre(faker.name().fullName());
            prov.setDireccion(faker.address().streetAddress());
            mySqlOperation.setSqlStatement("insert into barberia.proveedor values('"+prov.getNit()+"','"+prov.getNombre()+"'," +
                    "'"+prov.getDireccion()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

}
package com.sofkaU;

import com.github.javafaker.Faker;
import com.sofkaU.integration.database.models.Producto;
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
        insertarProducto();

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

    /**
     * Método para insertar datos en tabla Proveedor.
     */
    private static void insertarProveedor(){

        for (int i = 1; i < 51; i++) {

            Proveedor prov = new Proveedor();
            prov.setNit(i);
            prov.setNombre(faker.name().fullName());
            prov.setDireccion(faker.address().streetAddress());
            mySqlOperation.setSqlStatement("insert into proveedor values("+prov.getNit()+",'"+prov.getNombre()+"'," +
                    "'"+prov.getDireccion()+"');");
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    /**
     * Método para insertar datos en tabla Proveedor.
     */
    private static void insertarProducto(){

        for (int i = 1; i < 51; i++) {

            Producto prod = new Producto();
            prod.setREF(i);
            prod.setNombre(faker.funnyName().name());
            prod.setCantidad(faker.random().nextInt(12,90));
            prod.setPrecioCompra(faker.number().randomDouble(1,12900,180000));
            prod.setPrecioVenta(faker.number().randomDouble(1,180000,200000));
            prod.setNITproveedor(i);

            mySqlOperation.setSqlStatement("insert into producto values("+prod.getREF()+",'"+prod.getNombre()+"'," +
                    " "+prod.getCantidad()+","+prod.getPrecioCompra()+","+prod.getPrecioVenta()+","+prod.getNITproveedor()+");");
            mySqlOperation.executeSqlStatementVoid();
        }
    }

}
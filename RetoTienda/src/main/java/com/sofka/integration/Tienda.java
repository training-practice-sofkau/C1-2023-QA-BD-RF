package com.sofka.integration;

import com.github.javafaker.Faker;
import com.sofka.integration.database.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;


public class Tienda {
    MySqlConnector mySqlConnector;

    public Tienda(MySqlConnector mySqlConnector) {
        this.mySqlConnector = mySqlConnector;
    }

    public void insertarCliente() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO cliente(cedula, nombre_cliente, direccion_cliente, zona_cliente, email, password_cliente)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int cc = 1999999;
            for(int i = 0; i < 50; i++){
                statement.setString(1, (cc + i) + "");
                statement.setString(2, faker.name().firstName());
                statement.setString(3, faker.address().streetAddressNumber());
                statement.setString(4, faker.options().option("Zona 1", "Zona 2", "Zona 3", "Zona 4"));;
                statement.setString(5, faker.internet().emailAddress());
                statement.setString(6,faker.internet().password());
                statement.execute();
            }
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarTelefonoCliente() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO telefono_cliente (cedula_cliente, numero_cliente)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int cc = 1999999;
            for (int i = 0; i < 50; i++) {
                statement.setString(1, (cc + i) + "");
                statement.setString(2,faker.phoneNumber().cellPhone());
                statement.execute();
            }
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarProveedor() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO proveedor (id_proveedor, nombre_proveedor)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            for (int i = 0; i < 50; i++) {
                statement.setString(1,"prov"+i);
                statement.setString(2,faker.company().name());
                statement.execute();
            }
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarTelefonoProveedor() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO telefono_proveedor (id_proveedor_telefono, numero_proveedor)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            for (int i = 0; i < 50; i++) {
                statement.setString(1,"prov"+i);
                statement.setString(2,faker.phoneNumber().cellPhone());
                statement.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarCategoria() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO categoria (id_categoria, nombre_categoria, condiciones_almacenaimiento, observaciones)" +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            for (int i = 0; i < 50; i++) {
                statement.setString(1, "cat" + i);
                statement.setString(2, faker.commerce().department());
                statement.setString(3, faker.options().option("Frio", "Seco", "Humedo", "Caliente"));
                statement.setString(4, "observaciones" + i);
                statement.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarProducto() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO producto (id_producto, nombre_producto, marca, origen, contenido, fotografia, stock, " +
                    "id_categoria_producto, id_proveedor_producto)" +  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            for (int i = 0; i < 50; i++) {
                statement.setString(1, "prod"+i);
                statement.setString(2, faker.commerce().productName());
                statement.setString(3, faker.company().name());
                statement.setString(4, faker.country().name());
                statement.setString(5, faker.options().option("1 kg","500 gr", "350 ml", "1 lt"));
                statement.setString(6, "fotografia"+i);
                statement.setString(7, String.valueOf(faker.number().numberBetween(20, 60)));
                statement.setString(8, "cat" + i);
                statement.setString(9,"prov"+i);
                statement.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarDomiciliario() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO domiciliario (id_domiciliario, nombre_domiciliario, numero_matricula, zona_domiciliario)" +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            for (int i = 0; i < 50; i++) {
                statement.setString(1, "dom"+i);
                statement.setString(2,faker.name().firstName());
                statement.setString(3, faker.regexify("[A-Z0-9]{6}"));
                statement.setString(4, faker.options().option("Zona 1", "Zona 2", "Zona 3", "Zona 4"));
                statement.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarPedido() {
        try {
            Faker faker = new Faker();
            LocalDate fechaActual = LocalDate.now();
            String query = "INSERT INTO pedidos (id_pedido, direccion_pedido, fecha_pedido, numero_tarjeta, fecha_caducidad_tarjeta, " +
                    "total_valor, cedula_cliente, id_domiciliario_pedido)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int cc = 1999999;
            for (int i = 0; i < 50; i++) {
                statement.setString(1, "ped" + i);
                statement.setString(2, faker.address().streetAddressNumber());
                statement.setString(3, String.valueOf(fechaActual));
                statement.setString(4, "1000000" + i);
                statement.setString(5, "05/22");
                statement.setString(6,String.valueOf(faker.number().numberBetween(10000, 100000)));
                statement.setString(7, (cc + i) + "");
                statement.setString(8, "dom"+i);
                statement.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void insertarProductoPedido() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO producto_pedido(id_producto_pedido, id_pedido_producto, Cantidad)" +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            for (int i = 0; i < 50; i++) {
                statement.setString(1, "prod"+i);
                statement.setString(2, "ped" + i);
                statement.setString(3, String.valueOf(faker.number().numberBetween(1, 15)));
                statement.execute();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}

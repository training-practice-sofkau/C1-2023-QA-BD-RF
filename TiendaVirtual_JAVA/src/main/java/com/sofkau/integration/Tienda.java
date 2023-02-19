package com.sofkau.integration;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.MySqlConnector;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Tienda {
    MySqlConnector mySqlConnector;

    public Tienda(MySqlConnector mySqlConnector) {
        this.mySqlConnector = mySqlConnector;
    }
    public void insertarZona() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO zona (CodigoPostal)" +
                    "VALUES (?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int CodigoPostal = 1050;
            for (int i = 0; i <= 50; i++) {
                statement.setString(1, (CodigoPostal + i) + "");
                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarDomiciliario() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO domiciliario (ID, Nombre, NumeroMatriculaFurgoneta, Zona_CodigoPostal)" +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int ID= 10;
            String matricula="ARX";
            int CodigoPostal = 1050;
            for (int i = 0; i <= 50; i++) {
                statement.setString(1, (ID + i) + "");
                statement.setString(2, faker.name().firstName());
                statement.setString(3, (matricula+ i));
                statement.setString(4, (CodigoPostal + i) + "");

                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insertarCliente() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO cliente(Cedula, Nombre, Direccion, Email, Contrasena,Zona_CodigoPostal)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int cc = 50000000;
            int CodigoPostal = 1050;
            for (int i = 0; i < 50; i++) {
                statement.setString(1, (cc + i) + "");
                statement.setString(2, faker.name().firstName());
                statement.setString(3, faker.address().streetAddressNumber());
                statement.setString(4, faker.internet().emailAddress());
                statement.setString(5, faker.internet().password());
                statement.setString(6, (CodigoPostal + i) + "" );

                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarCategoria() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO categoria ( Nombre, CondicionesAlmacenamiento, Observaciones)" +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            String name="Categoria";
            for (int i = 0; i <= 50; i++) {

                statement.setString(1,name+i );
                statement.setString(2, faker.weather().temperatureCelsius());
                statement.setString(3, faker.weather().description());

                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarProveedor() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO proveedor ( Nombre, Direccion, Telefono,Email)" +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            String p= "Proveedor-";
            for (int i = 0; i <= 50; i++) {

                statement.setString(1, p+i);
                statement.setString(2, faker.address().city());
                statement.setString(3, faker.phoneNumber().cellPhone());
                statement.setString(4, faker.internet().emailAddress());

                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarPedidoProducto() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO pedido_producto ( Pedido_CodigoPedido, Producto_ID,Cantidad )" +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int c= 1000;
            int ID= 1;
            for (int i = 0; i <= 50; i++) {

                statement.setString(1, (c+i)+ "");
                statement.setString(2, (ID + i) + "");
                statement.setString(3, faker.number().digits(2));


                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarCarcomprasPedido() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO carritocompras_pedido ( CarritoCompras_ID, CodigoPedido_FK,Cantidad )" +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int car=100;
            int c= 1000;
            for (int i = 0; i <= 50; i++) {

                statement.setString(1, (car+i)+ "");
                statement.setString(2, (c + i) + "");
                statement.setString(3, faker.number().digits(2));


                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertarCarritoCompras() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO carritocompras ( ID, FechaCreacion,Cliente_Cedula )" +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            String c= "P#";
            int car=100;
            int cc = 50000000;
            for (int i = 0; i <= 50; i++) {

                statement.setString(1, (car+i)+ "");
                statement.setString(2, (String.valueOf(faker.date().between(Date.from(LocalDate.of(2022, 4, 5).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date()))));
                statement.setString(3, (cc + i) + "");


                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarPedido() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO pedido ( CodigoPedido, FechaPedido, Cliente_Cedula, Domiciliario_ID,DireccionEntrega,ImporteTotal,NumeroTarjeta,FechaCaducidad)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int c= 1000;
            int cc = 50000000;
            int ID= 10;
            for (int i = 0; i <= 50; i++) {

                statement.setString(1, (c+i)+ "");
                statement.setString(2, (String.valueOf(faker.date().between(Date.from(LocalDate.of(2022, 5, 14).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date()))));
                statement.setString(3, (cc + i) + "");
                statement.setString(4, (ID+i)+ "");
                statement.setString(5, faker.address().streetPrefix());
                statement.setString(6, faker.number().digits(6));
                statement.setString(7, faker.business().creditCardNumber());
                statement.setString(8, (String.valueOf(faker.date().between(Date.from(LocalDate.of(2023, 1, 10).atStartOfDay(ZoneId.systemDefault()).toInstant()), new Date()))));


                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarProducto() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO producto (ID, Nombre, Marca, Origen ,Volumen,Peso, Fotografia,Categoria_Nombre,UnidadesDisponibles,Proveedor_Nombre)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int ID= 1;
            String p= "Proveedor-";
            String name="Categoria";
            for (int i = 0; i <= 50; i++) {

                statement.setString(1, (ID + i) + "");
                statement.setString(2, faker.food().dish());
                statement.setString(3, faker.company().name());
                statement.setString(4, faker.address().country());
                statement.setString(5, faker.number().digits(2));
                statement.setString(6, faker.number().digits(2));
                statement.setString(7, String.valueOf(faker.artist()));
                statement.setString(8, name+i);
                statement.setString(9, faker.number().digits(3));
                statement.setString(10, p+i);

                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




    public void insertarTelefonoCliente() {
        try {
            Faker faker = new Faker();
            String query = "INSERT INTO telefono_cliente (Cedula_FK, Telefono_FK)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = this.mySqlConnector.getStatement(query);
            int cc = 50000000;
            for (int i = 0; i <= 50; i++){
                statement.setString(1,(cc + i) + "");
                statement.setString(2,faker.phoneNumber().cellPhone());
                statement.execute();
            }
            statement.close();

        }catch (SQLException e){
            e.printStackTrace();
        }

    }



}

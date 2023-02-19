package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.MySqlConnector;
import org.apache.commons.lang3.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

/**
 * Esta clase contiene todos los métodos que permiten poblar la BD de barbería.
 */
public class Barberia {

    /**
     * Atributos
     */
    MySqlConnector conn;
    private int totalRecords = 50;

    /**
     * Constructor
     * @param conn
     * @param totalRecords
     */
    public Barberia(MySqlConnector conn, int totalRecords){
        this.conn = conn;
        this.totalRecords = totalRecords;
    }

    /**
     * Métodos que permiten poblar cada una de las tablas de la BD de barbería.
     * Nota: Algunos se realizan con un statement y otros con un procedimiento almacenado.
     */
    public void llenarServicios (){
        try{
            Faker faker = new Faker();
            String query = "INSERT INTO tb_servicio (id_servicio, nombre_servicio, descripcion, valor)" +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement statement = this.conn.getStatement(query);

            for(int i = 0; i < this.totalRecords; i ++){
                statement.setString(1, i + "");
                statement.setString(2,faker.job().title());
                statement.setString(3, faker.lorem().fixedString(100));
                long price = faker.number().numberBetween(1000, 50000);
                statement.setInt(4, (int)price);
                statement.executeUpdate();
            }
            statement.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarTelefonoProveedor(){
        try{
            Faker faker = new Faker();

            String query = "INSERT INTO tb_telefono_proveedor (id_telefono_proveedor, telefono)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = this.conn.getStatement(query);
            int cc = 1000000;
            for (int i = 0; i < this.totalRecords; i ++){
                statement.setString(1, (cc + i) + "");
                statement.setString(2, faker.phoneNumber().cellPhone());
                this.conn.insert(statement);
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarTelefonoCliente(){
        try{
            Faker faker = new Faker();

            String query = "INSERT INTO tb_telefono_cliente (id_telefono_cliente, telefono)" +
                    "VALUES (?, ?);";
            PreparedStatement statement = this.conn.getStatement(query);
            int cc = 1000000;
            for (int i = 0; i < this.totalRecords; i ++){
                statement.setString(1, (cc + i) + "");
                statement.setString(2, faker.phoneNumber().cellPhone());
                this.conn.insert(statement);
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarCompra(){
        try{
            Faker faker = new Faker();

            String query = "INSERT INTO tb_compra (id_compra, valor, fecha)" +
                    "VALUES (?, ?, ?);";
            PreparedStatement statement = this.conn.getStatement(query);
            int idCompra = 1000000;
            int idProducto = 1;
            for (int i = 0; i < this.totalRecords; i ++){

                statement.setString(1, (idCompra + i) + "");
                long price = faker.number().numberBetween(1000, 50000);
                statement.setInt(2, (int)price);
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = dateFormat.format(faker.date().birthday());
                statement.setString(3, date);

                this.conn.insert(statement);

                /**
                 * Tabla detalle compra
                 */

                String queryProducto = "INSERT INTO dll_compra_producto()" +
                        "VALUES (?, ?, ?, ?, ?);";
                PreparedStatement statement1 = this.conn.getStatement(queryProducto);

                statement1.setString(1, (idCompra + i+2) + "");
                statement1.setString(2, (idCompra + i) + "");

                statement1.setString(3, StringUtils.leftPad(
                        idProducto + "",
                        10,
                        "0"
                ));
                long unidades = faker.number().numberBetween(1, 100);
                statement1.setInt(4, (int)unidades);
                statement1.setInt(5, (int)faker.number().numberBetween(1000, 50000));
                this.conn.insert(statement1);
                idProducto ++;
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarCita(){
        try{
            Faker faker = new Faker();

            String query = "INSERT INTO tb_cita (id_cita, fecha, hora, estado, id_cliente, id_empleado)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.conn.getStatement(query);
            int id = 1000000;
            for (int i = 0; i < this.totalRecords; i ++){

                statement.setString(1, (id + i) + "");
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = dateFormat.format(faker.date().birthday());
                statement.setString(2, date);
                statement.setString(3, faker.number().numberBetween(0,23) + "");
                statement.setString(4, "Disponible");
                statement.setString(5, (id + i) + "");
                statement.setString(6, (id + i) + "");

                this.conn.insert(statement);
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarHistorialServicio(){
        try{
            Faker faker = new Faker();

            String query = "INSERT INTO tb_historial_servicio (id_historial_servicio, producto_consumido, duracion, fecha, id_empleado, id_servicio)" +
                    "VALUES (?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = this.conn.getStatement(query);
            int id = 1000000;
            for (int i = 0; i < this.totalRecords; i ++){

                statement.setString(1, (id + i) + "");
                statement.setString(2, faker.commerce().productName());
                statement.setString(3, faker.number().numberBetween(1, 5) + "");
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = dateFormat.format(faker.date().birthday());
                statement.setString(4, date);
                statement.setString(5, (id + i) + "");
                statement.setString(6, i + "");

                this.conn.insert(statement);
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarVenta(){
        try{
            Faker faker = new Faker();

            String query = "INSERT INTO tb_registro_venta (id_registro_venta, valor, fecha, id_cliente)" +
                    "VALUES (?, ?, ?, ?);";
            PreparedStatement statement = this.conn.getStatement(query);
            int id = 1000000;
            int idProducto = 1;
            for (int i = 0; i < this.totalRecords; i ++){

                statement.setString(1, (id + i) + "");
                long price = faker.number().numberBetween(1000, 50000);
                statement.setInt(2, (int)price);
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String date = dateFormat.format(faker.date().birthday());
                statement.setString(3, date);
                statement.setString(4, (id + i) + "");

                this.conn.insert(statement);

                /**
                 * Tabla detalle venta
                 */

                String queryProducto = "INSERT INTO dll_venta_producto()" +
                        "VALUES (?, ?, ?, ?, ?);";
                PreparedStatement statement1 = this.conn.getStatement(queryProducto);

                statement1.setString(1, (id + i+2) + "");
                statement1.setString(2, (id + i) + "");

                statement1.setString(3, StringUtils.leftPad(
                        idProducto + "",
                        10,
                        "0"
                ));
                long unidades = faker.number().numberBetween(1, 100);
                statement1.setInt(4, (int)unidades);
                statement1.setInt(5, (int)faker.number().numberBetween(1000, 50000));
                this.conn.insert(statement1);
                idProducto ++;
            }
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarProveedores (){
        try{
            Faker faker = new Faker();

            String query = "{call registrar_proveedor(?, ?, ?)}";
            CallableStatement procedure = this.conn.getCallable(query);
            int cc = 1000000;
            for (int i = 0; i < this.totalRecords; i ++){
                procedure.setString(1, (cc + i) + "");
                procedure.setString(2, faker.name().firstName());
                procedure.setString(3, faker.address().city());
                this.conn.insert(procedure);
            }
            procedure.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarProductos(){
        try{
            Faker faker = new Faker();
            String query = "{call registrar_producto(?, ?, ?, ?, ?)}";
            CallableStatement procedure = this.conn.getCallable(query);
            int cc = 1000000;
            int idProducto = 1;
            for (int i = 0; i < this.totalRecords; i ++){
                for(int j = 0; j < 2; j ++){
                    procedure.setString(1, StringUtils.leftPad(
                            idProducto + "",
                            10,
                            "0"
                    ));
                    procedure.setString(2, faker.commerce().productName());
                    procedure.setInt(3, faker.number().numberBetween(1,28));
                    long price = faker.number().numberBetween(1000, 50000);
                    procedure.setInt(4, (int)price);
                    procedure.setString(5, (cc + i) + "");
                    this.conn.insert(procedure);
                    idProducto ++;
                }
            }
            procedure.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarClientes (){
        try{
            Faker faker = new Faker();

            String query = "{call registrar_cliente(?, ?, ?, ?, ?, ?)}";
            CallableStatement procedure = this.conn.getCallable(query);
            int cc = 1000000;

            for (int i = 0; i < this.totalRecords; i ++){
                procedure.setString(1, (cc + i) + "");
                procedure.setString(2, faker.name().firstName());
                procedure.setString(3, faker.name().lastName());
                SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
                String birthdate = dateFormat.format(faker.date().birthday());
                procedure.setString(4, birthdate);
                procedure.setString(5, faker.internet().emailAddress());
                procedure.setString(6, faker.address().city());
                this.conn.insert(procedure);
            }
            procedure.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void llenarEmpleados (){
        try{
            Faker faker = new Faker();

            String query = "{call registrar_empleado(?, ?, ?, ?, ?)}";
            CallableStatement procedure = this.conn.getCallable(query);
            int cc = 1000000;

            for (int i = 0; i < this.totalRecords; i ++){
                procedure.setString(1, (cc + i) + "");
                procedure.setString(2, faker.name().firstName());
                procedure.setString(3, faker.name().lastName());
                procedure.setString(4, faker.job().title());
                procedure.setString(5, i + "");

                this.conn.insert(procedure);
            }
            procedure.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}

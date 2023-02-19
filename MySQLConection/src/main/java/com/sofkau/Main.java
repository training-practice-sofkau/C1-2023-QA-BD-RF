package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;

import java.sql.SQLException;
import java.util.Locale;


public class Main {
    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "TiendaDonPepe";
    private static final String USER = "root";
    private static final String PASSWORD = "Revolution1";
    private static final String INSERT_CLIENTE = String.format("INSERT INTO %s.Cliente VALUES (%s, %s, %s, %s, %s, %s, %s)", DATA_BASE_NAME, "'C%d'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'");
    private static final String INSERT_CONTACTO_CLIENTE = String.format("INSERT INTO %s.Contacto_Cliente VALUES (%s, %s)", DATA_BASE_NAME, "'C%d'", "'%s'");
    private static final String INSERT_DOMICLIARIO = String.format("INSERT INTO %s.Domiciliario VALUES (%s, %s, %s, %s)", DATA_BASE_NAME, "'D%d'", "'%s'", "'%s'", "'%s'");
    private static final String INSERT_CONTACTO_DOMICLIARIO = String.format("INSERT INTO %s.Contacto_Domiciliario VALUES (%s, %s)", DATA_BASE_NAME, "'D%d'", "'%s'");
    private static final String INSERT_PROVEEDOR = String.format("INSERT INTO %s.Proveedor VALUES (%s, %s, %s, %s)", DATA_BASE_NAME, "'P%d'", "'%s'", "'%s'", "'%s'");
    private static final String INSERT_CONTACTO_PROOVEDOR = String.format("INSERT INTO %s.Contacto_Proveedor VALUES (%s, %s)", DATA_BASE_NAME, "'P%d'", "'%s'");
    private static final String INSERT_COND_ALMACENAMIENTO = String.format("INSERT INTO %s.Condiciones_Almacenamiento VALUES (%s, %s)", DATA_BASE_NAME, "'Cond%d'", "'%s'");
    private static final String INSERT_PRODUCTO = String.format("INSERT INTO %s.Producto VALUES (%s, %s, %s, %s, %s ,%s ,%s ,%s,%s)", DATA_BASE_NAME, "'Prod%d'", "'Cat%s'", "'P%s'","'%s'","'%s'","'%s'","'%s'","'%s'","'%s'");
    private static final String INSERT_PEDIDO = String.format("INSERT INTO %s.Pedido VALUES (%s, %s, %s, %s, %s, %s ,%s ,%s ,%s,%s,%s,%s)", DATA_BASE_NAME, "'Ped%d'", "'C%s'", "'D%s'", "'%s'","'%s'","'%s'","'%s'","'%s'","'%s'","'%s'","'%s'","'%s'");
    private static final String INSERT_CATEGORIA = String.format("INSERT INTO %s.Categoria_Producto VALUES (%s, %s, %s)", DATA_BASE_NAME, "'Cat%d'", "'%s'", "'Cond%s'");
    private static final String INSERT_PROD_PEDIDO = String.format("INSERT INTO %s.Producto_Pedido VALUES (%s, %s)", DATA_BASE_NAME, "'Prod%d'", "'Ped%s'");

    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public static void main(String[] args) throws SQLException {


        openConnection();
        insertClientes();
        insertContactoCliente();
        insertDomiciliario();
        insertContactoDomiciliario();
        insertProveedor();
        insertContactoProveedor();
        insertCondicionalmacenamiento();
        insertCategoriaProd();
        insertProducto();
        insertPedido();
        insertproductoPedido();
        mySqlOperation.close();
    }

    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }
    public static void insertClientes() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String nombre = faker.name().fullName();
            String cedula = faker.idNumber().valid();
            String direccion = faker.address().fullAddress();
            String password = faker.internet().password();
            String codigoPostal = faker.address().zipCode();
            String email = faker.internet().emailAddress();
            String query = String.format(INSERT_CLIENTE, id, nombre, cedula, password, email, direccion, codigoPostal);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertContactoCliente() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            int telefono = (int) faker.number().randomNumber();
            String query = String.format(INSERT_CONTACTO_CLIENTE, id, telefono);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }

    }
    public static void insertDomiciliario() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String nombre = faker.name().fullName();
            String placa = faker.regexify("[A-Z]{3}-[0-9]{3}");
            String codigoPostal = faker.address().zipCode();
            String query = String.format(INSERT_DOMICLIARIO, id, placa, nombre, codigoPostal);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertContactoDomiciliario() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            int telefono = (int) faker.number().randomNumber();
            String query = String.format(INSERT_CONTACTO_DOMICLIARIO, id, telefono);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertProveedor() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String nombre = faker.company().name();
            String direccion = faker.address().fullAddress();
            String email = faker.internet().emailAddress();
            String query = String.format(INSERT_PROVEEDOR, id, nombre, direccion, email);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertContactoProveedor() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            int telefono = (int) faker.number().randomNumber();
            String query = String.format(INSERT_CONTACTO_PROOVEDOR, id, telefono);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertCondicionalmacenamiento() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String almacenamiento = faker.options().option("Frio", "Seco", "Congelado");
            String query = String.format(INSERT_COND_ALMACENAMIENTO, id, almacenamiento);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertProducto() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String foto = faker.internet().image();
            int unidadesProducto= faker.number().numberBetween(1000, 10000);
            String volumen= faker.regexify("\\d{1,2}(\\.\\d{1,2})? [a-zA-Z]{2,3}\\b");
            String peso = faker.regexify("\\d{1,2}(\\.\\d{1,2})? [a-zA-Z]{2,3}\\b");
            String nombre= faker.food().ingredient();
            String precio= faker.commerce().price();
            String query = String.format(INSERT_PRODUCTO, id, id, id, foto, unidadesProducto, volumen, peso, nombre,precio);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertPedido() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String fechaPedido = faker.date().toString();
            int unidadesPedidas = faker.number().numberBetween(1, 50);
            String valorPedido = faker.number().numberBetween(50, 500) + "." + faker.number().numberBetween(0, 99);
            String tarjetaPago = faker.business().creditCardNumber();
            String caducidadTarjeta = faker.business().creditCardExpiry();
            String direccionEntrega = faker.address().streetAddress();
            String codPostalCliente = faker.address().zipCode();
            String codPostalDomiciliario = faker.address().zipCode();
            String verificacionZona = faker.bool().bool() ? "Si" : "No";
            String query = String.format(INSERT_PEDIDO, id, id, id, fechaPedido, unidadesPedidas, valorPedido, tarjetaPago, caducidadTarjeta, direccionEntrega, codPostalCliente, codPostalDomiciliario, verificacionZona);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertCategoriaProd() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String observaciones = faker.options().option("Alimento perecedero", "Bebida", "Alimento no perecedero", "Producto de aseo");
            String tipoALmacenamiento = String.valueOf(faker.number().numberBetween(1, 50));
            String query = String.format(INSERT_CATEGORIA, id, observaciones, tipoALmacenamiento);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
    public static void insertproductoPedido() {
        for (int i = 1; i <= 50; i++) {
            int id = i;
            String query = String.format(INSERT_PROD_PEDIDO, id, id);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
}

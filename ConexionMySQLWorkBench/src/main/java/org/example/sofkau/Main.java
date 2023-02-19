package org.example.sofkau;

import com.github.javafaker.Faker;
import org.example.sofkau.integration.database.mysql.MySqlOperation;

import java.sql.SQLException;
import java.util.Locale;



public class Main {
    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "TiendaDonPepeSanty";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";
    private static final String INSERT_CLIENTE = String.format("INSERT INTO %s.Cliente VALUES (%s, %s, %s, %s, %s, %s, %s, %s)", DATA_BASE_NAME, "'Cliente%d'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'");
    private static final String INSERT_CONTACTO_CLIENTE = String.format("INSERT INTO %s.TelefonoCliente VALUES (%s, %s,%s)", DATA_BASE_NAME, "'%s'", "'Cliente%d'", "'%s'");
    private static final String INSERT_DOMICLIARIO = String.format("INSERT INTO %s.Domiciliario VALUES (%s, %s, %s, %s)", DATA_BASE_NAME, "'Domiciliario%d'", "'%s'", "'%s'", "'%s'");
    private static final String INSERT_PROVEEDOR = String.format("INSERT INTO %s.Proveedor VALUES (%s, %s, %s)", DATA_BASE_NAME, "'Proveedor%d'", "'%s'", "'%s'");
    private static final String INSERT_TIPO_ALMACENAMIENTO = String.format("INSERT INTO %s.TipoAlmacenamiento VALUES (%s, %s)", DATA_BASE_NAME, "'Tipo%d'", "'%s'");
    private static final String INSERT_CATEGORIA = String.format("INSERT INTO %s.CategoriaProducto VALUES (%s, %s, %s)", DATA_BASE_NAME, "'Categoria%d'", "'Tipo%s'", "'%s'");
    private static final String INSERT_PRODUCTO = String.format("INSERT INTO %s.Producto VALUES (%s, %s, %s, %s, %s, %s ,%s ,%s ,%s,%s)", DATA_BASE_NAME, "'Producto%d'", "'Categoria%s'", "'Proveedor%s'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'", "'%s'");

    private static final String INSERT_PEDIDO = String.format("INSERT INTO %s.Pedido VALUES (%s, %s, %s, %s, %s, %s ,%s ,%s ,%s,%s,%s,%s)", DATA_BASE_NAME, "'Pedido%d'", "'Cliente%s'", "'Domiciliario%s'", "'%s'","'%s'","'%s'","'%s'","'%s'","'%s'","'%s'","'%s'","'%s'");

    private static final String INSERT_CONTENER = String.format("INSERT INTO %s.Contener VALUES (%s, %s)", DATA_BASE_NAME,  "'Pedido%s'","'Producto%d'");

    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public static void main(String[] args) throws SQLException {


        openConnection();
        insertClientes();
        insertTelefonoCliente();
        insertDomiciliario();
        insertProveedor();
        insertCondicionalmacenamiento();
        insertCategoriaProducto();
        insertProducto();
        insertPedido();
        insertContener();
        mySqlOperation.close();
    }

    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }




    public static void insertTelefonoCliente() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int IdTelefononoCliente = i;
            int FKIdCliente = i;

            int NumeroTelefono = (int) faker.number().randomNumber();
            String query = String.format(INSERT_CONTACTO_CLIENTE, IdTelefononoCliente, FKIdCliente, NumeroTelefono);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    public static void insertDomiciliario() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int IdDomiciliario = i;
            String NumeroMatricula = faker.regexify("[A-Z]{3}-[0-9]{3}");
            String NombreDomiciliario = faker.name().fullName();
            String ApellidoDomiciliario = faker.name().lastName();
            String query = String.format(INSERT_DOMICLIARIO, IdDomiciliario, NumeroMatricula, NombreDomiciliario, ApellidoDomiciliario);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    public static void insertProveedor() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int IdProveedor = i;
            String NombreProveedor = faker.company().name();
            int TelefonoProveedor = (int) faker.number().randomNumber();
            String query = String.format(INSERT_PROVEEDOR, IdProveedor, NombreProveedor, TelefonoProveedor);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    public static void insertCondicionalmacenamiento() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int IdTipoAlmacenamiento = i;
            String TipoDeAlmacenaminento = faker.options().option("Seco", "Humedo", " Congelado");
            String query = String.format(INSERT_TIPO_ALMACENAMIENTO, IdTipoAlmacenamiento, TipoDeAlmacenaminento);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    public static void insertCategoriaProducto() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int IdCategoriaProducto = i;
            String FKIdTipoAlmacenamiento = String.valueOf(faker.number().numberBetween(1, 50));
            String Recomendaciones = faker.lorem().sentence();
            String query = String.format(INSERT_CATEGORIA, IdCategoriaProducto, FKIdTipoAlmacenamiento, Recomendaciones);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    public static void insertProducto() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int IdProducto = i;

            String Fotografia = faker.internet().image();
            int UnidadesDisponibles = faker.number().numberBetween(1000, 10000);
            String Observaciones = faker.lorem().sentence();
            String Volumen = faker.regexify("\\d{1,2}(\\.\\d{1,2})? [a-zA-Z]{2,3}\\b");
            String Peso = faker.regexify("\\d{1,2}(\\.\\d{1,2})? [a-zA-Z]{2,3}\\b");
            String Nombre = faker.food().ingredient();
            String PrecioProductoUnidad = faker.commerce().price();
            String query = String.format(INSERT_PRODUCTO, IdProducto, IdProducto, IdProducto, Fotografia, UnidadesDisponibles, Observaciones, Volumen, Peso, Nombre, PrecioProductoUnidad);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }


    public static void insertPedido() {
        Faker faker = new Faker(new Locale("es"));
        for (int i = 1; i <= 50; i++) {
            int IdPedido = i;
            String FechaPedido = faker.date().toString();
            String ImporteTotalPedido = faker.number().numberBetween(50, 500) + "." + faker.number().numberBetween(0, 99);
            String VerificacionRealizacionPedido = faker.bool().bool() ? "Aceptado" : "Rechazado";
            String CodigoPostalCliente = faker.address().zipCode();
            String CodigoPostalDomiciliario = faker.address().zipCode();
            String TajetaCredito = faker.business().creditCardNumber();
            String FechaCaducidadTarjeta = faker.business().creditCardExpiry();
            String DireccionPedido = faker.address().streetAddress();
            int UnidadesPedidas = faker.number().numberBetween(1, 50);

            String query = String.format(INSERT_PEDIDO, IdPedido, IdPedido, IdPedido, FechaPedido, ImporteTotalPedido, VerificacionRealizacionPedido, CodigoPostalCliente, CodigoPostalDomiciliario, TajetaCredito, FechaCaducidadTarjeta, DireccionPedido, UnidadesPedidas);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }



   public static void insertContener() {
        for (int i = 1; i <= 50; i++) {
            int FKIdContenerPedidoProducto = i;
            int FKIdContenerProductoPedido = i;
            String query = String.format(INSERT_CONTENER,FKIdContenerPedidoProducto,FKIdContenerProductoPedido);
            mySqlOperation.setSqlStatement(query);
            System.out.println(query);
            mySqlOperation.executeSqlStatementVoid();
        }
    }
}

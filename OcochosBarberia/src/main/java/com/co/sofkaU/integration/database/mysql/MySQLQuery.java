package com.co.sofkaU.integration.database.mysql;

import com.co.sofkaU.integration.model.Insumo;
import com.co.sofkaU.integration.model.Producto;
import com.co.sofkaU.integration.model.Proveedor;
import com.github.javafaker.Faker;

import java.sql.SQLException;

public class MySQLQuery {
    private static final String SOCKET = "localhost:3306";
    private static final String DBNAME = "ocochosBarberia";
    private static final String USER = "ococho";
    private static final String PASSWORD = "hola123";
    private static final MySQLOperation mySQLOp = new MySQLOperation();
    private static final Faker faker = new Faker();

    public static final String INSERT_PROVEEDOR =
            "INSERT INTO proveedor (nombreProveedor, telefonoProveedor) VALUES ('%s', '%s');";
    public static final String INSERT_PRODUCTO =
            "INSERT INTO producto (nombreProducto, cantidadProducto, precioProducto) VALUES ('%s', '%d', '%f');";
    public static final String INSERT_INSUMO =
            "INSERT INTO insumo (nombreInsumo, cantidadInsumo) VALUES ('%s', '%d');";
    public static final String INSERT_PROVEEDORP =
            "INSERT INTO proveerp (idProveedorP, REFProductoP) VALUES ('%d', '%d');";
    public static final String INSERT_PROVEEDORI =
            "INSERT INTO proveeri (idProveedorI, REFInsumoI) VALUES ('%d', '%d');";


    public static final String SELECT = "select * from cliente";

    public static void openConnection() {
        mySQLOp.setSocket(SOCKET);
        mySQLOp.setDbName(DBNAME);
        mySQLOp.setUser(USER);
        mySQLOp.setPassword(PASSWORD);
    }

    public static void select(String select) throws SQLException {
        mySQLOp.setSqlStatement(select);
        mySQLOp.executeSelectStatement();
        mySQLOp.printResultSet();
    }

    public static void insert(String insert) {
        mySQLOp.setSqlStatement(insert);
        mySQLOp.executeInsertStatement();
    }

    public static void insertProveedor(String insert) {
        for (int i = 1; i <= 50 ; i++) {
            Proveedor proveedor =
                    new Proveedor(faker.name().firstName(), "321" + faker.number().digits(7));
            insert(String.format(insert, proveedor.getNombreProveedor(), proveedor.getTelefonoProveedor()));
        }

    }

    public static void insertProducto(String insertProducto, String insertProveedor) {
        for (int i = 1; i <= 50 ; i++) {
            Producto producto =
                    new Producto(faker.number().numberBetween(1, 20),
                                 faker.number().randomDouble(2, 0, 100000),
                                 faker.harryPotter().character());
            insert(String.format(insertProducto, producto.getNombreProducto(),
                                         producto.getCantidadProducto(),
                                         producto.getPrecioProducto()));
            insert(String.format(insertProveedor, faker.number().numberBetween(1,50), i));
        }

    }

    public static void insertInsumo(String insertInsumo, String insertProveedor) {
        for (int i = 1; i <= 50 ; i++) {
            Insumo insumo =
                    new Insumo(faker.number().numberBetween(1, 15), faker.animal().name());
            insert(String.format(insertInsumo, insumo.getNombreInsumo(), insumo.getCantidadInsumo()));
            insert(String.format(insertProveedor, faker.number().numberBetween(1,50), i));
        }

    }

    public static void closeConnection() {
        mySQLOp.closeConnection();
    }

}

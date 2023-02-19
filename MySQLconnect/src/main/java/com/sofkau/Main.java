package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integration.database.mysql.MySqlOperation;
import com.sofkau.integration.models.*;

import java.sql.SQLException;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final String SERVER = "localhost";
    private static final String DATA_BASE_NAME = "barber";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public static List<Integer> id_cliente = new ArrayList<>();

    public static List<Integer> id_empleado = new ArrayList<>();

    public static List<Integer> id_clienteTelefono = new ArrayList<>();

    public static List<Integer> id_Cita = new ArrayList<>();

    public static List<Integer> id_Reserva = new ArrayList<>();

    public static List<Integer> id_Proveedor = new ArrayList<>();

    public static List<Integer> id_Insumo = new ArrayList<>();

    public static List<String> refs = new ArrayList<>();

    public static List<Integer> id_Factura = new ArrayList<>();

    public static List<Integer> id_Historial = new ArrayList<>();

    public static List<Integer> id_ProductoFactura = new ArrayList<>();


    private static Faker faker = new Faker();


    public static void main(String[] args) throws SQLException {


        openConnection();

        List<Integer> ids_generadosClientes = addCliente();

        List<Integer> ids_generadosTelefonoCliente = addTelefonoCliente();

        List<Integer> ids_generadosEmpleado = addEmpleado();

        List<Integer> ids_generadosReserva = addReserva();

        List<Integer> ids_generadosCita = addCita();

        List<Integer> ids_generadosProveedor = addProveedor();

        List<Integer> ids_generadosInsumo = addInsumo();

        List<String> ids_generadosProducto = addProducto();

        List<Integer> ids_generadosFactura = addFactura();

        List<Integer> ids_generadosHistorial = addHistorial();

        addProductoFactura(ids_generadosProducto, ids_generadosFactura);

        addCompra(ids_generadosClientes, ids_generadosProducto);


        closeConnection();


    }

    private static void addProductoFactura(List<String> ids_generadosProducto, List<Integer> ids_generadosFactura) {
        for (String ref_producto : ids_generadosProducto) {
            for (Integer id : ids_generadosFactura) {
                ProductoFactura productoFactura = new ProductoFactura();
                productoFactura.setRef(String.valueOf(ref_producto));
                productoFactura.setIdFactura(id);

                String insertProductoFactura = "INSERT INTO producto_factura (REF, id_factura) " +
                        "VALUES ('%s', %d)";
                insertProductoFactura = String.format(insertProductoFactura, productoFactura.getRef(), productoFactura.getIdFactura());

                insertIntoProductoFactura(insertProductoFactura);
            }
        }
    }


    //ya me traigo los id de los arreglos correspondientes
    private static void addCompra(List<Integer> ids_generadosClientes, List<String> ids_generadosProducto) {
        for (Integer id_cliente : ids_generadosClientes) {
            for (String ref_producto : ids_generadosProducto) {
                Compra compra = new Compra();
                compra.setIdCliente(id_cliente);
                compra.setRef(String.valueOf(ref_producto));

                String insertCompra = "INSERT INTO compra (REF, id_cliente) VALUES ('%s', %d)";
                insertCompra = String.format(insertCompra, compra.getRef(), compra.getIdCliente());


                insertIntoCompra(insertCompra);
            }
        }
    }


    private static List<Integer> addCliente() {

        String insertCliente = "";

        for (int i = 1; i <= 10; i++) {

            Cliente cliente = new Cliente();

            Faker faker = new Faker();

            cliente.setIdCliente(i);
            cliente.setNombreCliente(faker.name().fullName());
            cliente.setCedulaCliente(faker.number().digits(10));
            cliente.setProfesion(faker.job().title());
            cliente.setCorreo(faker.internet().emailAddress());
            cliente.setEdad(faker.number().numberBetween(10, 100));
            cliente.setDireccion(faker.address().streetAddress(false));

            insertCliente = "INSERT INTO cliente (id_cliente, nombre_cliente, cedula_cliente, profesion, correo, edad, direccion)" +
                    " VALUES(%s,'%s','%s','%s', '%s', %s, '%s' );";
            insertCliente = String.format(insertCliente,
                    cliente.getIdCliente(),
                    cliente.getNombreCliente(),
                    cliente.getCedulaCliente(),
                    cliente.getProfesion(),
                    cliente.getCorreo(),
                    cliente.getEdad(),
                    cliente.getDireccion());

            inserIntoCliente(insertCliente);
            id_cliente.add(cliente.getIdCliente());
        }
        return id_cliente;
    }


    private static List<Integer> addReserva() {

        String insertReserva = "";
        Faker faker = new Faker();
        for (int i = 1; i <= 10; i++) {
            Reserva reserva = new Reserva();
            reserva.setId_reserva(i);
            reserva.setId_cliente(i);
            reserva.setEstado(faker.options().option("Pendiente", "Confirmada", "Cancelada"));
            java.sql.Date fechaReserva = new java.sql.Date(faker.date().past(1, TimeUnit.DAYS).getTime());
            reserva.setFecha_reserva(fechaReserva);
            reserva.setDescripcion(faker.lorem().sentence(5));

            insertReserva = "INSERT INTO reserva (id_reserva, id_cliente, estado, fecha_reserva, descripcion)" +
                    " VALUES(%s, %s, '%s', '%s', '%s' );";
            insertReserva = String.format(insertReserva,
                    reserva.getId_reserva(),
                    reserva.getId_cliente(),
                    reserva.getEstado(),
                    reserva.getFecha_reserva(),
                    reserva.getDescripcion());

            inserIntoReserva(insertReserva);
        }
        return id_Reserva;
    }

    private static List<Integer> addCita() {

        String insertCita = "";

        for (int i = 1; i <= 10; i++) {

            Cita cita = new Cita();

            Faker faker = new Faker();

            cita.setIdCita(i);
            cita.getIdReserva(Integer.parseInt(String.valueOf(i)));
            java.sql.Date fecha = new java.sql.Date(faker.date().past(1, TimeUnit.DAYS).getTime());
            cita.setFecha(fecha);
            cita.setHora(Time.valueOf(faker.date().past(1, TimeUnit.DAYS).toInstant().atZone
                    (ZoneId.systemDefault()).toLocalTime()));
            cita.setDescripcion(faker.lorem().paragraph(5));
            insertCita = "INSERT INTO cita (id_cita, id_reserva, fecha, hora, descripcion)" +
                    " VALUES(%s,%s,'%s','%s', '%s' );";
            insertCita = String.format(insertCita,
                    cita.getIdCita(),
                    cita.getIdReserva(Integer.parseInt(String.valueOf(i))),
                    cita.getFecha(),
                    cita.getHora(),
                    cita.getDescripcion());
            inserIntoCita(insertCita);
            id_Cita.add(cita.getIdCita());
        }
        return id_Cita;
    }


    private static List<Integer> addTelefonoCliente() {

        String insertTelefonoCliente = "";

        for (int i = 1; i <= 10; i++) {

            TelefonoCliente telefonoCliente = new TelefonoCliente();

            telefonoCliente.setIdCliente(i);
            telefonoCliente.setNumero(faker.number().digits(7));

            insertTelefonoCliente = "INSERT INTO telefono_cliente (id_cliente, numero)" + " VALUES(%s,'%s');";
            insertTelefonoCliente = String.format(insertTelefonoCliente,
                    telefonoCliente.getIdCliente(), telefonoCliente.getNumero());

            inserIntoTelefonoCliente(insertTelefonoCliente);
            id_clienteTelefono.add(telefonoCliente.getIdCliente());
        }
        return id_clienteTelefono;
    }


    private static List<Integer> addEmpleado() {

        String insertEmpleado = "";

        for (int i = 1; i <= 10; i++) {

            Empleado empleado = new Empleado();
            Faker faker = new Faker();

            empleado.setIdEmpleado(Integer.parseInt(String.valueOf(i)));
            empleado.setCedula(faker.idNumber().valid());
            empleado.setNombreEmpleado(faker.name().fullName());
            empleado.setEspecialidad(faker.job().title());

            insertEmpleado = "INSERT INTO empleado (id_empleado, cedula, nombre_empleado, especialidad)" +
                    " VALUES(%s,'%s','%s','%s');";
            insertEmpleado = String.format(insertEmpleado,
                    empleado.getIdEmpleado(),
                    empleado.getCedula(),
                    empleado.getNombreEmpleado(),
                    empleado.getEspecialidad());
            inserIntoEmpleado(insertEmpleado);
            id_empleado.add(empleado.getIdEmpleado());
        }
        return id_empleado;
    }


    private static List<Integer> addInsumo() {

        String insertInsumo = "";
        List<Integer> id_insumo = new ArrayList<>();

        for (int i = 1; i <= 50; i++) {

            Insumo insumo = new Insumo();
            Faker faker = new Faker();

            insumo.setIdInsumo(i);
            insumo.setNombreInsumo(faker.commerce().productName());
            insumo.setDescripcion(faker.lorem().sentence(10));
            insumo.setCantidad(faker.number().numberBetween(1, 100));

            insertInsumo = "INSERT INTO insumo (id_insumo, nombre_insumo, descripcion, cantidad)" +
                    " VALUES(%s,'%s','%s',%s);";
            insertInsumo = String.format(insertInsumo,
                    insumo.getIdInsumo(),
                    insumo.getNombreInsumo(),
                    insumo.getDescripcion(),
                    insumo.getCantidad());
            inserIntoInsumo(insertInsumo);
            id_insumo.add(insumo.getIdInsumo());
        }
        return id_insumo;
    }


    private static List<Integer> addProveedor() {

        String insertProveedor = "";
        List<Integer> id_proveedor = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {

            Proveedor proveedor = new Proveedor();
            Faker faker = new Faker();

            proveedor.setIdProveedor(i);
            proveedor.setNombreProveedor(faker.company().name());
            proveedor.setDireccion(faker.address().streetAddress());
            proveedor.setCorreo(faker.internet().emailAddress());

            insertProveedor = "INSERT INTO proveedor (id_proveedor, nombre_proveedor, direccion, correo)" +
                    " VALUES(%s,'%s','%s','%s');";
            insertProveedor = String.format(insertProveedor,
                    proveedor.getIdProveedor(),
                    proveedor.getNombreProveedor(),
                    proveedor.getDireccion(),
                    proveedor.getCorreo());
            inserIntoProveedor(insertProveedor);
            id_proveedor.add(proveedor.getIdProveedor());
        }
        return id_proveedor;
    }


    private static List<String> addProducto() {
        String insertProducto = "";
        List<String> refs = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Producto producto = new Producto();
            Faker faker = new Faker();
            producto.setRef(String.valueOf(i));
            producto.setPrecio(Double.parseDouble(faker.number().digits(7)));
            producto.setCantidad(faker.number().numberBetween(10, 100));
            producto.setNombre_producto(faker.commerce().productName());
            producto.setId_proveedor(i);

            insertProducto = "INSERT INTO producto (REF, precio, cantidad, nombre_producto, id_proveedor) " +
                    "VALUES ('%s', %f, %d, '%s', %d)";
            insertProducto = String.format(insertProducto, producto.getRef(), producto.getPrecio(),
                    producto.getCantidad(), producto.getNombre_producto(), producto.getId_proveedor());
            insertIntoProducto(insertProducto);
            refs.add(producto.getRef());
        }

        return refs;
    }

    private static List<Integer> addFactura() {
        String insertFactura = "";
        List<Integer> id_factura = new ArrayList<Integer>();
        Random rand = new Random();

        for (int i = 1; i <= 10; i++) {
            Factura factura = new Factura();
            factura.setIdFactura(i);
            factura.setIdEmpleado(i);
            factura.setValor(rand.nextDouble() * 1000);
            //factura.setFechaFactura();

            java.sql.Date fechaFactura = new java.sql.Date(faker.date().past(1, TimeUnit.DAYS).getTime());
            factura.setFechaFactura(fechaFactura);

            insertFactura = "INSERT INTO factura (id_factura, id_empleado, valor, fecha_factura) " +
                    "VALUES (%s, %s, %s, '%s')";
            insertFactura = String.format(insertFactura,
                    factura.getIdFactura(),
                    factura.getIdEmpleado(),
                    factura.getValor(),
                    factura.getFechaFactura());
            insertIntoFactura(insertFactura);
            id_factura.add(factura.getIdFactura());
        }

        return id_factura;
    }


    private static List<Integer> addHistorial() {

        String insertHistorial = "";

        // Crea algunas instancias de Historial usando Java Faker
        Faker faker = new Faker();
        List<Historial> historiales = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Historial historial = new Historial();
            historial.setIdEmpleado(faker.number().numberBetween(1, 10));
            historial.setIdServicio(faker.number().numberBetween(1, 10));
            historial.setProductosConsumidos(faker.food().ingredient() + ", " + faker.food().ingredient());
            historial.setDuracionProcedimiento(faker.number().numberBetween(10, 60));
            java.sql.Date fechaServicio = new java.sql.Date(faker.date().past(1, TimeUnit.DAYS).getTime());
            historial.setFechaServicio(fechaServicio);
            historiales.add(historial);
        }

        // Inserta los datos de las instancias de Historial en la tabla 'historial'
        for (Historial historial : historiales) {
            insertHistorial = "INSERT INTO historial (id_empleado, id_servicio, productos_consumidos, duracion_procedimiento, fecha_servicio)" +
                    " VALUES (%d, %d, '%s', %d, '%s');";
            insertHistorial = String.format(insertHistorial,
                    historial.getIdEmpleado(),
                    historial.getIdServicio(),
                    historial.getProductosConsumidos(),
                    historial.getDuracionProcedimiento(),
                    historial.getFechaServicio().toString()
            );
            insertIntoHistorial(insertHistorial);
        }
        return null;
    }


    public static void openConnection() {
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }


    public static void closeConnection() {
        mySqlOperation.close();

    }

    private static void inserIntoCliente(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void inserIntoEmpleado(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void inserIntoTelefonoCliente(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void inserIntoCita(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void inserIntoReserva(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void inserIntoProveedor(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }


    private static void inserIntoInsumo(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void insertIntoProducto(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void insertIntoFactura(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void insertIntoHistorial(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }


    private static void insertIntoProductoFactura(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }

    private static void insertIntoCompra(String sentencia) {
        mySqlOperation.setSqlStatement(sentencia);
        mySqlOperation.executeSqlStatementVoid();
    }
}
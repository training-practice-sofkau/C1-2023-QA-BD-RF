package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.integracion.database.modelos.*;
import com.sofkau.integracion.database.mysql.MySqlOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final String SERVER= "localhost";
    private static final String DATA_BASE_NAME="tiendadonpepe";
    private static final String USER="root";
    private static final String PASSWORD="Colombia.2022";
    private static final String SELECT_ALL_FROM_CLIENTE= String.format("select * from %s.cliente", DATA_BASE_NAME);
    private static final String INSERT_CLIENTE= "INSERT INTO `tiendadonpepe`.`cliente` (`CedulaCliente`, `NombreCliente`, `Direccion`, `Email`, `Password`, `IdZona`) VALUES ('123', 'Andres', 'calle 10', 'andres@gmail.com', '12345', '001');";
    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public static void main(String[] args) throws SQLException{
        openConnection();
        closeConnection();
        insertCliente();
        SelectAllFromClientes();
        create50ZonasBD();
        insertarClientes();
        insertarDomiciliarios();
        insertarCestaCompras();
        insertarPedidos();
        insertarCategorias();
        insertarProductos();
        insertarProductosCestas();
        insertarTelefonosCliente();
    }
    public static void openConnection(){
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDataBaseName(DATA_BASE_NAME);
        mySqlOperation.setUser(USER);
        mySqlOperation.setPassword(PASSWORD);
    }
    public static void SelectAllFromClientes()throws SQLException{
        mySqlOperation.setSqlStatement(SELECT_ALL_FROM_CLIENTE);
        mySqlOperation.executeSqlStatement();
        mySqlOperation.printResultset();
    }

    public static void insertCliente()throws SQLException{
        mySqlOperation.setSqlStatement(INSERT_CLIENTE);
        mySqlOperation.executeSqlStatementvoid();
    }

    public static void closeConnection(){
        mySqlOperation.close();
    }

    public static void create50ZonasBD(){
        Faker faker = new Faker();
        List<Zona> zonas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String idZona = faker.regexify("[A-Z]{2}\\d{3}");
            String codigoPostal = faker.address().zipCode();
            Zona zona = new Zona(idZona, codigoPostal);
            zonas.add(zona);
        }
        for (Zona zona : zonas) {
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`zona` (`IdZona`, `codigoPostal`)" +
                    " VALUES ('%s', '%s');",zona.getIdZona(),zona.getCodigoPostal()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarClientes() throws SQLException{
        Faker faker =new Faker();
        List<String> zonaIds = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT IdZona FROM tiendadonpepe.zona;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet = mySqlOperation.getResulset();
        while (resultSet.next()) {
            zonaIds.add(resultSet.getString("IdZona"));
        }
        String[] zonaIdsArray = zonaIds.toArray(new String[0]);

        List<Cliente> clientes = new ArrayList<>();
        for (int i = 0; i< 52 ; i++){
            String cedula = faker.regexify("\\d{9}");
            String nombre = faker.name().fullName();
            String direccion = faker.address().fullAddress();
            String email = faker.internet().emailAddress();
            String password = faker.internet().password();
            String idZona = zonaIdsArray[i];
            Cliente cliente = new Cliente(cedula, nombre, direccion, email, password, idZona);
            clientes.add(cliente);
        }
        for(Cliente cliente: clientes){
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`cliente`" +
                    " (`CedulaCliente`, `NombreCliente`, `Direccion`, `Email`, `Password`, `IdZona`)" +
                    " VALUES ('%s', '%s', '%s', '%s', '%s', '%s')", cliente.getCedulaCliente(),
                    cliente.getNombreCliente(), cliente.getDireccion(), cliente.getEmail(),
                    cliente.getPassword(), cliente.getIdZona()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarDomiciliarios() throws SQLException{
        Faker faker =new Faker();
        List<String> zonaIds = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT IdZona FROM tiendadonpepe.zona;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet = mySqlOperation.getResulset();
        while (resultSet.next()) {
            zonaIds.add(resultSet.getString("IdZona"));
        }
        String[] zonaIdsArray = zonaIds.toArray(new String[0]);

        List<Domiciliario> domiciliarios = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            String idDomiciliario = faker.regexify("[A-Z]{2}\\d{3}");
            String nombreDomiciliario = faker.name().fullName();
            String numeroMatricula = faker.regexify("\\d{6}");
            String idZona = zonaIdsArray[i];
            Domiciliario domiciliario = new Domiciliario(idDomiciliario, nombreDomiciliario, numeroMatricula, idZona);
            domiciliarios.add(domiciliario);
        }
        for (Domiciliario domiciliario : domiciliarios) {
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`domiciliario` (`idDomiciliario`, `NombreDomiciliario`, `NumeroMatricula`, `idZona`) VALUES ('%s', '%s', '%s', '%s')", domiciliario.getIdDomiciliario(), domiciliario.getNombreDomiciliario(), domiciliario.getNumeroMatricula(), domiciliario.getIdZona()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarCestaCompras() throws SQLException{
        Faker faker = new Faker();
        List<String> cedulaClientes = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT CedulaCliente FROM tiendadonpepe.cliente;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet = mySqlOperation.getResulset();
        while (resultSet.next()) {
            cedulaClientes.add(resultSet.getString("CedulaCliente"));
        }
        String[] cedulaClientesArray = cedulaClientes.toArray(new String[0]);

        List<CestaCompras> cestas = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String idCestaCompras = faker.regexify("[A-Z]{2}\\d{3}");
            Date fecha = faker.date().birthday();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaCreacion = sdf.format(fecha);
            String cedulaCliente = cedulaClientesArray[i];
            CestaCompras cesta = new CestaCompras(idCestaCompras, fechaCreacion, cedulaCliente);
            cestas.add(cesta);
        }
        for (CestaCompras cesta : cestas) {
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`CestaCompras` (`idCestaCompras`, `FechaCreacion`, `CedulaCliente`) VALUES ('%s', '%s', '%s')", cesta.getIdCestaCompras(), cesta.getFechaCreacion(), cesta.getCedulaCliente()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarPedidos()throws SQLException{
        Faker faker = new Faker();
        List<String> cedulaClientes = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT CedulaCliente FROM tiendadonpepe.cliente;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet = mySqlOperation.getResulset();
        while (resultSet.next()) {
            cedulaClientes.add(resultSet.getString("CedulaCliente"));
        }
        String[] cedulaClientesArray = cedulaClientes.toArray(new String[0]);

        List<String> idDomiciliarios = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT idDomiciliario FROM tiendadonpepe.Domiciliario;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet1 = mySqlOperation.getResulset();
        while (resultSet1.next()) {
            idDomiciliarios.add(resultSet1.getString("idDomiciliario"));
        }
        String[] idDomiciliariosArray = idDomiciliarios.toArray(new String[0]);

        List<String> idCestaCompras = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT idCestaCompras FROM tiendadonpepe.CestaCompras;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet2 = mySqlOperation.getResulset();
        while (resultSet2.next()) {
            idCestaCompras.add(resultSet2.getString("idCestaCompras"));
        }
        String[] idCestaComprasArray = idCestaCompras.toArray(new String[0]);

        List<Pedido> pedidos = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            String codigoPedido = faker.regexify("[A-Z]{2}\\d{3}");
            Date fechaPedido = faker.date().future(30, TimeUnit.DAYS);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String fechaPedidoStr = sdf.format(fechaPedido);
            String direccionEntrega = faker.address().fullAddress();
            int importeTotal = faker.number().numberBetween(10, 100);
            String datosDePago;
            if (faker.bool().bool()) {
                datosDePago = "Tarjeta de crédito";
            } else {
                datosDePago = "Efectivo";
            }
            String cedulaCliente = cedulaClientesArray[i];
            String idDomiciliario = idDomiciliariosArray[i];
            String idCesta = idCestaComprasArray[i];
            Pedido pedido = new Pedido(codigoPedido, fechaPedidoStr, direccionEntrega, importeTotal, datosDePago, cedulaCliente, idDomiciliario, idCesta);
            pedidos.add(pedido);
        }
        for (Pedido pedido : pedidos) {
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`Pedido` (`CodigoPedido`, `FechaPedido`, `DireccionEntrega`, `ImporteTotal`, `DatosDePago`, `CedulaCliente`, `idDomiciliario`, `idCestaCompras`) VALUES ('%s', '%s', '%s', %d, '%s', '%s', '%s', '%s')", pedido.getCodigoPedido(), pedido.getFechaPedido(), pedido.getDireccionEntrega(), pedido.getImporteTotal(), pedido.getDatosDePago(), pedido.getCedulaCliente(), pedido.getIdDomiciliario(), pedido.getIdCestaCompras()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarCategorias()throws SQLException{
        Faker faker = new Faker();
        List<Categoria> categorias = new ArrayList<>();
        String[] condiciones = {"Frio", "Seco", "Congelado"};
        for (int i = 0; i < 100; i++) {
            String nombreCategoria = faker.commerce().department();
            String condicion = condiciones[faker.number().numberBetween(0, 3)];
            String observaciones = faker.lorem().sentence();
            Categoria categoria = new Categoria(nombreCategoria, condicion, observaciones);
            categorias.add(categoria);
        }
        for (Categoria categoria : categorias) {
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`Categoria` (`NombreCategoria`, `Condiciones`, `Observaciones`) VALUES ('%s', '%s', '%s');", categoria.getNombreCategoria(), categoria.getCondiciones(), categoria.getObservaciones()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarProductos()throws SQLException{
        Faker faker = new Faker();
        List<String> nombresCategorias = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT NombreCategoria FROM tiendadonpepe.Categoria;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet = mySqlOperation.getResulset();
        while (resultSet.next()) {
            nombresCategorias.add(resultSet.getString("NombreCategoria"));
        }
        String[] nombresCategoriasArray = nombresCategorias.toArray(new String[0]);

        List<Producto> productos = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            String nombreProducto = faker.commerce().productName();
            String marca = faker.company().name();
            String origen = faker.options().option("nacional", "internacional");
            String dimensiones = faker.numerify("#0x#0x#0");
            int unidadesDisponibles = 50;
            String nombreCategoria = nombresCategoriasArray[i];
            Producto producto = new Producto(nombreProducto, marca, origen, dimensiones, unidadesDisponibles, nombreCategoria);
            productos.add(producto);
        }
        for (Producto producto : productos) {
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`Producto` (`NombreProducto`, `Marca`, `Origen`, `Dimensiones`, `UnidadesDisponibles`, `NombreCategoria`) VALUES ('%s', '%s', '%s', '%s', %d, '%s')", producto.getNombreProducto(), producto.getMarca(), producto.getOrigen(), producto.getDimensiones(), producto.getUnidadesDisponibles(), producto.getNombreCategoria()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarProductosCestas()throws SQLException{
        Faker faker = new Faker();
        List<String> idCestaCompras = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT idCestaCompras FROM tiendadonpepe.CestaCompras;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet2 = mySqlOperation.getResulset();
        while (resultSet2.next()) {
            idCestaCompras.add(resultSet2.getString("idCestaCompras"));
        }
        String[] idCestaComprasArray = idCestaCompras.toArray(new String[0]);

        List<String> nombresProductos = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT NombreProducto FROM tiendadonpepe.Producto;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet = mySqlOperation.getResulset();
        while (resultSet.next()) {
            nombresProductos.add(resultSet.getString("NombreProducto"));
        }
        String[] nombresProductosArray = nombresProductos.toArray(new String[0]);

        List<ProductoCesta> productoCestas = new ArrayList<>();

        for (int i = 0; i < idCestaComprasArray.length; i++) {
            String idCestaCompra = idCestaComprasArray[i];
            String nombreProductos = nombresProductosArray[i];
            int unidadesSeleccionadas = faker.number().numberBetween(1, 51);
            ProductoCesta productoCesta = new ProductoCesta(nombreProductos,idCestaCompra,unidadesSeleccionadas);
            productoCestas.add(productoCesta);
        }

        for (ProductoCesta productoCesta : productoCestas) {
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`ProductoCesta` (`NombreProducto`, `idCestaCompras`, `UnidadesSeleccionadas`) VALUES ('%s', '%s', %d)", productoCesta.getNombreProducto(), productoCesta.getIdCestaCompra(), productoCesta.getUnidadesSeleccionadas()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }

    public static void insertarTelefonosCliente()throws SQLException{
        Faker faker = new Faker();
        List<String> cedulaClientes = new ArrayList<>();
        mySqlOperation.setSqlStatement("SELECT CedulaCliente FROM tiendadonpepe.cliente;");
        mySqlOperation.executeSqlStatement();
        ResultSet resultSet = mySqlOperation.getResulset();
        while (resultSet.next()) {
            cedulaClientes.add(resultSet.getString("CedulaCliente"));
        }
        String[] cedulaClientesArray = cedulaClientes.toArray(new String[0]);

        List<TelefonoCliente> telefonosClientes = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String cedulaCliente = cedulaClientesArray[i];
            String telefonoCliente = faker.phoneNumber().cellPhone();
            TelefonoCliente telefonoCliente1 = new TelefonoCliente(cedulaCliente, telefonoCliente);
            telefonosClientes.add(telefonoCliente1);
        }
        for (TelefonoCliente telefonoCliente: telefonosClientes){
            mySqlOperation.setSqlStatement(String.format("INSERT INTO `tiendadonpepe`.`Telefono_Cliente` (`CedulaCliente`, `TelefonoCliente`) VALUES ('%s', '%s')", telefonoCliente.getCedulaCliente(), telefonoCliente.getTelefoCliente()));
            mySqlOperation.executeSqlStatementvoid();
        }
    }
}
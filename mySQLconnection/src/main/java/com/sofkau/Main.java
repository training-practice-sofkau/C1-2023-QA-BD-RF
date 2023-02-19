package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.database.clases.*;
import com.sofkau.database.dao.*;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {
    private static final String SERVER="localhost";
    private static final String DATA_BASE_NAME="tiendadonpepe";
    private static final String USER="root";
    private static final String PASSWORD="2805";
    private static final MySqlOperation mysqlOperation= new MySqlOperation();

    public static void main(String[] args) throws SQLException {

        openConnection();

        //agregarCategorias();
        //listarCategorias();
        //agregarProveedor();
        //listarProveeedor();
        //agregarCarrito();
        //listarcarrito();
        //agregarZona();
        //agregarProductos();
        //listarProductos();
        //agregarDomiciliario();
       // listarDomiciliario();
      //agregarClientes();
        //agregarProductoProveedor();
        //agregarProdutoAlCarrito();
        //agregarPedido();
        agregarFactura();
        closeConnection();


    }


    public static void agregarCategorias(){
        Categoria_DAO categoriaDao = new Categoria_DAO(mysqlOperation);
        Faker faker = new Faker();
        for (int i=0;i<=50;i++){
            int id_cate= faker.random().nextInt(1,100);
            String nombre = faker.commerce().department();
            String almacenamiento = faker.lorem().word();
            String observaciones = faker.lorem().sentence();
            categoriaDao.insertarCategoria(new Categoria(id_cate,nombre,almacenamiento,observaciones));
        }
    }
    public static void listarCategorias(){
        Categoria_DAO categoriaDao = new Categoria_DAO(mysqlOperation);
        List<Categoria> categorias = categoriaDao.mostrarCategoria();
        for (Categoria datos: categorias){
            System.out.println("ID: "+datos.getId_categoria()+ " "+" NOMBRE: "+ datos.getNombre()+ " "+
                               " ALMACENAMIENTO: "+datos.getAlmacenamiento()+" "+" OBSERVACIONES: "+datos.getObservaciones()+" ");
        }
    }

    public static void agregarProveedor(){
        Proveedor_DAO proveedorDao = new Proveedor_DAO(mysqlOperation);
        Faker faker = new Faker();
        for (int i=0;i<=50;i++){
            String razonSocial = faker.company().name();
            String telefono = String.valueOf(faker.phoneNumber().cellPhone());
            String correo = faker.internet().emailAddress();
            proveedorDao.insertarProveedor(new Proveedor(razonSocial,telefono,correo));
        }
    }

    public static void listarProveeedor(){
        Proveedor_DAO proveedorDao = new Proveedor_DAO(mysqlOperation);
        List<Proveedor> proveedores = proveedorDao.mostrarProveedor();
        for (Proveedor datos: proveedores){
            System.out.println("RAZON SOCIAL: "+datos.getRazon_social()+" "+" TELEFONO: "+datos.getTelefono()+" "
                                +"CORREO: "+datos.getCorreo());
        }
    }
    public static void agregarCarrito(){
        CarritoDeCompra_DAO carritoDeCompraDao = new CarritoDeCompra_DAO(mysqlOperation);
        for (int i=0;i<=50;i++){
            int id_carrito = i;
            carritoDeCompraDao.insertarCarritoCompra(new CarritoDeCompra(id_carrito));
        }
    }
    public static void listarcarrito(){
        CarritoDeCompra_DAO carritoDeCompraDao= new CarritoDeCompra_DAO(mysqlOperation);
        List<CarritoDeCompra> carritoDeCompras = carritoDeCompraDao.mostrarCarritoCompra();
        for (CarritoDeCompra datos: carritoDeCompras){
            System.out.println("ID CARRITO: "+datos.getId_carrito());
        }
    }
    public static void agregarZona(){
        Zona_DAO zonaDao = new Zona_DAO(mysqlOperation);
        Faker faker = new Faker();
        for (int i=0;i<=50;i++){
            String codigo = faker.address().zipCode();
            String nombre = faker.address().secondaryAddress();
            zonaDao.insertarZona(new Zona(codigo,nombre));
        }
    }
    public static void listarZona(){
        Zona_DAO zonaDao = new Zona_DAO(mysqlOperation);
        List<Zona> zonas = zonaDao.mostrarZona();
        for (Zona dato: zonas){
            System.out.println("CODIGO POSTAL: "+dato.getCod_postal()+" "+" NOMBRE: "+dato.getNombre());
        }
    }
    public static void agregarProductos(){
        Producto_DAO productoDao = new Producto_DAO(mysqlOperation);
        Faker faker = new Faker();
        for (int i=0;i<=50;i++){
            String nombre= faker.commerce().productName();
            String marca = faker.company().name();
            String dimension = String.valueOf(faker.random().nextInt(50,250));
            dimension=dimension+"gr";
            String foto = nombre + "png";
            double precio = Double.parseDouble(faker.commerce().price());
            int categoria = faker.random().nextInt(1,100);
            productoDao.insertarProducto(new Producto(nombre,marca,dimension,foto,precio,categoria));
        }
    }


    public static void listarProductos(){
        Producto_DAO productoDao = new Producto_DAO(mysqlOperation);
        List<Producto> productos = productoDao.mostrarProducto();
        for (Producto dato:productos){
            System.out.println("NOMBRE: "+dato.getNom_producto()+" "+" MARCA: "+dato.getMarca()+" "+
                    " DIMENSION: "+dato.getDimension()+" "+" FOTO: "+dato.getFoto()+" "+" PRECIO: "+dato.getPrecio()+
                    " "+" CATEGORIA: "+dato.getId_categoria());
        }
    }
    public static void  agregarClientes(){
        Cliente_DAO clienteDao = new Cliente_DAO(mysqlOperation);
        Zona_DAO zonaDao = new Zona_DAO(mysqlOperation);
        List<Zona> misZonas = zonaDao.mostrarZona();
       //clienteDao.insertarCliente(new Cliente("12343","maria","callee","mad @fv","vava","05553"));
        Faker faker = new Faker();
        for (int i=0;i<=50;i++){
            String cedula = faker.idNumber().valid();
            String nombre = faker.name().name();
            String direccion = faker.address().streetName();
            String correo = faker.internet().emailAddress();
            String contrasena = faker.internet().password();
            String zona = misZonas.get(faker.random().nextInt(0,49)).getCod_postal();
            clienteDao.insertarCliente(new Cliente(cedula,nombre,direccion,correo,contrasena,zona));
        }
    }
    public static void agregarInventario() {
        Inventario_DAO inventarioDao = new Inventario_DAO(mysqlOperation);
        Producto_DAO producto_dao = new Producto_DAO(mysqlOperation);
        List<Producto> misProductos = producto_dao.mostrarProducto();
        Faker faker = new Faker();
        for (int i = 0; i <= 45; i++) {
            int id = i;
            int cant = 100;
            String producto = misProductos.get(faker.random().nextInt(0, 45)).getNom_producto();
            inventarioDao.insertarInventario(new Inventario(id, cant, producto));
        }
    }
    public static void  agregarProductoProveedor(){
        ProductoProveedor_DAO productoProveedorDao = new ProductoProveedor_DAO(mysqlOperation);
        Producto_DAO producto_dao = new Producto_DAO(mysqlOperation);
        Proveedor_DAO proveedorDao = new Proveedor_DAO(mysqlOperation);
        List<Producto> misProductos = producto_dao.mostrarProducto();
        List<Proveedor> misProveedores = proveedorDao.mostrarProveedor();
        Faker faker = new Faker();
        for (int i=0;i < misProductos.size();i++){
            String razonSocial = misProveedores.get(faker.random().nextInt(0,misProveedores.size()-1)).getRazon_social();
            String nomProducto = misProductos.get(i).getNom_producto();
            productoProveedorDao.insertarProdProveedor(new ProductoProveedor(razonSocial,nomProducto));
        }
    }
    public static void agregarDomiciliario(){
        Domiciliario_DAO domiciliarioDao= new Domiciliario_DAO(mysqlOperation);
        Faker faker = new Faker();
        for (int i=0;i<=50;i++){
            String cedula = faker.idNumber().valid();
            String nombre = faker.name().firstName();
            String matricula = faker.regexify("[A-Z]{3}-[0-9]{3}");
            domiciliarioDao.insertarDomiciliario(new Domiciliario(cedula,nombre,matricula));
        }
    }


    public static void agregarProdutoAlCarrito (){
        CarritoCompraProducto_DAO carritoCompraProductoDao = new CarritoCompraProducto_DAO(mysqlOperation);
        CarritoDeCompra_DAO miCarrito = new CarritoDeCompra_DAO(mysqlOperation);
        List<CarritoDeCompra> listaCarritos = miCarrito.mostrarCarritoCompra();
        Producto_DAO miProducto = new Producto_DAO(mysqlOperation);
        List<Producto> listaProductos = miProducto.mostrarProducto();
        Faker faker =new Faker();
        for (int i=0; i< listaCarritos.size(); i++){
            int cant_prod = faker.random().nextInt(1,6);
            for (int j=1;j<cant_prod;j++){
                int id = i;
                String producto = listaProductos.get(faker.random().nextInt(0,listaProductos.size()-1)).getNom_producto();
                int cant = faker.random().nextInt(1,5);
                carritoCompraProductoDao.ingresarCarritoProducto(new CarritoCompraProducto(id,producto,cant));
            }
        }
    }
    public static void agregarPedido(){
        Pedido_DAO pedidoDao = new Pedido_DAO(mysqlOperation);
        CarritoDeCompra_DAO carritoDeCompraDao = new CarritoDeCompra_DAO(mysqlOperation);
        List<CarritoDeCompra> listaCarritos = carritoDeCompraDao.mostrarCarritoCompra();
        Faker faker = new Faker();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        for (int i=0;i<listaCarritos.size();i++){
            String codigo = i +" ";
            Date fecha= Date.valueOf(formatoFecha.format(faker.date().birthday()));
            String tarjeta = faker.number().digit();
            Date fechaCadu = Date.valueOf(formatoFecha.format(faker.date().birthday()));
            int carrito = listaCarritos.get(i).getId_carrito();
            pedidoDao.insertarPedido(new Pedido(codigo,fecha,tarjeta,fechaCadu,carrito));
        }
    }
    public static void agregarFactura(){
        Factura_DAO facturaDao = new Factura_DAO(mysqlOperation);
        Domiciliario_DAO domiciliarioDao=new Domiciliario_DAO(mysqlOperation);
        List<Domiciliario> listaDomiciliario = domiciliarioDao.mostrarDomiciliario();
        Cliente_DAO clienteDao = new Cliente_DAO(mysqlOperation);
        List<Cliente> listaCliente = clienteDao.mostrarCliente();
        Pedido_DAO pedidoDao= new Pedido_DAO(mysqlOperation);
        List<Pedido> listaPedido = pedidoDao.mostrarPedido();
        Faker faker = new Faker();
        for (int i=0;i<listaPedido.size();i++){
            String codigo = i +" ";
            int total= Integer.parseInt(faker.commerce().price());
            String domiciliario = listaDomiciliario.get(faker.random().nextInt(0,listaDomiciliario.size()-1)).getCedula_domiciliario();
           String cliente = listaCliente.get(faker.random().nextInt(0,listaCliente.size()-1)).getCed_cliente();
           String pedido = listaPedido.get(i).getCodigo_pedido();
           facturaDao.insertarFactura(new Factura(codigo,total,domiciliario,cliente,pedido));
        }
    }
    public static void listarDomiciliario(){
        Domiciliario_DAO domiciliarioDao= new Domiciliario_DAO(mysqlOperation);
        List<Domiciliario> domiciliarios =domiciliarioDao.mostrarDomiciliario();
        for (Domiciliario dato: domiciliarios){
            System.out.println("CEDULA: "+dato.getCedula_domiciliario()+" "+" NOMBRE: "+dato.getNombre()+" "
                               +" MATRICULA: "+dato.getNum_matricula());
        }
    }



    public static void openConnection(){
        mysqlOperation.setServer(SERVER);
        mysqlOperation.setDataBaseName(DATA_BASE_NAME);
        mysqlOperation.setUser(USER);
        mysqlOperation.setPassword(PASSWORD);
    }

    public static void closeConnection(){
        mysqlOperation.close();
    }
}

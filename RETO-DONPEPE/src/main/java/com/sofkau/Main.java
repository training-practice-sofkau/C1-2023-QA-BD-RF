package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.dao.UtilidadesDAO;
import com.sofkau.integration.database.mysql.Conexion;
import com.sofkau.models.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
   public static UtilidadesDAO utilidadesDAO=new UtilidadesDAO();

    public static void main(String[] args)  {
        Conexion con = new Conexion();
       if (!insertarZona(con)) {
            System.out.println("error,No se inserto zona");

        }
       if (!insertarProveedor(con)) {
            System.out.println("error,No se inserto proveedor");
        }
        if (!insertarCategoria(con)) {
            System.out.println("error,No se inserto categorias ");
        }
        if (!insertarCliente(con)) {
            System.out.println("error,No se inserto clientes");
        }
        if (!insertarDomiciliario(con)) {
            System.out.println("error,No se inserto domiciliarios");
        }
        if (!insertarPedido(con)) {
            System.out.println("error,No se inserto pedidos");
        }
        if (!insertarProducto(con)) {
            System.out.println("error,No se inserto productos");
        }
        if (!insertarDetalle(con)) {
            System.out.println("error,No se inserto detalle ");
        }
        
    }
    public static boolean insertarZona(Conexion con) {
        Faker faker = new Faker();
        List<Zona> listZonas = new ArrayList<Zona>();
        for (int i = 1; i <= 50; i++) {
            Zona zona = new Zona();
            zona.setNombre(faker.name().username());
            zona.setBarrio(faker.address().cityName());
            listZonas.add(zona);
            zona=null;

        }
        //zonaDAO.insertar(zona);
        for (var zona: listZonas) {
            System.out.println(zona.toString());

        }
        return utilidadesDAO.guardarZonaDAO(con.getCon(), listZonas);

    }
    public static boolean insertarProducto(Conexion con) {
        List<Producto> listProductos = new ArrayList<>();
        Faker faker = new Faker();
        for (int i = 1; i <=50; i++) {
            Producto producto = new Producto();


            producto.setNombre(faker.name().firstName());
            producto.setMarca(faker.commerce().productName());
            producto.setOrigen(faker.address().cityName());
            producto.setVolumen(faker.idNumber().valid());
            producto.setPrecio(faker.number().randomNumber());
            producto.setPeso(faker.idNumber().valid());
            producto.setFoto(faker.idNumber().valid());
            producto.setIdProvedor(String.valueOf(i));
            producto.setIdCategoria(i);

            listProductos.add(producto);
            producto =null;
        }
        return utilidadesDAO.guardarProductosDAO(con.getCon(), listProductos);
    }

    public static boolean insertarPedido(Conexion con) {
        List<Pedido> listPedidos = new ArrayList<Pedido>();
        Faker faker = new Faker();
        for (int i = 1 ;i <=50; i++) {
            Pedido pedido = new Pedido();


            pedido.setFecha_caducidad(faker.date().toString());
            pedido.setNumero_tarjeta(faker.number().digit());
            pedido.setFecha_pedido(faker.date().toString());
            pedido.setDireccion_entrega(faker.address().fullAddress());
            pedido.setImporte_total_pedido(faker.idNumber().valid());
            pedido.setId_cliente(i);
            pedido.setId_domiciliario(i);

            listPedidos.add(pedido);
            pedido=null;
        }
        return utilidadesDAO.guardarPedidosDAO(con.getCon(), listPedidos);
    }
    public static boolean insertarCliente(Conexion con) {
        List<Cliente> listClientes = new ArrayList<Cliente>();
        Faker faker = new Faker();
        for (int i = 1; i <=50; i++) {
            Cliente cliente = new Cliente();


            cliente.setCedula(faker.number().digit());
            cliente.setNombre(faker.name().firstName());
            cliente.setDireccion(faker.address().fullAddress());
            cliente.setTelefono(faker.phoneNumber().phoneNumber());
            cliente.setCorreo(faker.name().username() + "@gmail.com");
            cliente.setContrasena(faker.name().username());
            cliente.setCodigo_postal(i);

            listClientes.add(cliente);
            cliente=null;
        }
        return utilidadesDAO.guardarClientesDAO(con.getCon(), listClientes);
    }
    public static boolean insertarDomiciliario(Conexion con) {
        List<Domiciliario> listDomiciliarios = new ArrayList<Domiciliario>();
        Faker faker = new Faker();
        for (int i = 1; i <= 50; i++) {
            Domiciliario domiciliario = new Domiciliario();



            domiciliario.setNombre(faker.name().firstName());
            domiciliario.setMatricula_furgoneta(faker.code().imei());
            domiciliario.setCodigo_postal(i);

            listDomiciliarios.add(domiciliario);
            domiciliario=null;
        }
        return utilidadesDAO.guardarDomiciliarioDAO(con.getCon(), listDomiciliarios);
    }
    public static boolean insertarCategoria(Conexion con) {
        List<Categoria> listCategorias = new ArrayList<Categoria>();
        Faker faker = new Faker();
        for (int i = 1; i <= 50; i++) {
            Categoria categoria = new Categoria();


            categoria.setNombre(faker.name().firstName());
            categoria.setObservaciones(faker.funnyName().name());
            categoria.setCondiciones_almacenamiento(faker.commerce().material());

            listCategorias.add(categoria);
            categoria=null;
        }
        return utilidadesDAO.guardarCategoriaDAO(con.getCon(), listCategorias);
    }
    public static boolean insertarProveedor(Conexion con) {
        List<Proveedor> listProveedores = new ArrayList<Proveedor>();
        Faker faker = new Faker();
        for (int i = 1; i <= 50; i++) {
            Proveedor proveedor = new Proveedor();

            proveedor.setNIT(String.valueOf(i));
            proveedor.setNombre(faker.name().firstName());
            proveedor.setTelefono(faker.phoneNumber().phoneNumber());

            listProveedores.add(proveedor);
            proveedor=null;
        }
        return utilidadesDAO.guardarProveedorDAO(con.getCon(), listProveedores);
    }

    public static boolean insertarDetalle(Conexion con) {
        List<Datalle_Pedido> listDetalles = new ArrayList<Datalle_Pedido>();
        Faker faker = new Faker();
        for (int i = 1; i <=50; i++) {
            Datalle_Pedido datallePedido = new Datalle_Pedido();


            datallePedido.setIdPedido(i);
            datallePedido.setIdProducto(i);

            listDetalles.add(datallePedido);
            datallePedido=null;
        }
        return utilidadesDAO.guardarDetalleDAO(con.getCon(), listDetalles);
    }
}
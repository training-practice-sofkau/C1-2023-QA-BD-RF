package com.sofkau;

import com.github.javafaker.Faker;
import com.sofkau.database.clases.CarritoDeCompra;
import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Proveedor;
import com.sofkau.database.clases.Zona;
import com.sofkau.database.dao.CarritoDeCompra_DAO;
import com.sofkau.database.dao.Categoria_DAO;
import com.sofkau.database.dao.Proveedor_DAO;
import com.sofkau.database.dao.Zona_DAO;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.SQLException;
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
        agregarZona();
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
            String id_carrito = i+" ";
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

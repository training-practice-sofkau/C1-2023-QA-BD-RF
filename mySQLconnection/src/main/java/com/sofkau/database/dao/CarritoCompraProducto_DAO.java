package com.sofkau.database.dao;

import com.sofkau.database.clases.CarritoCompraProducto;
import com.sofkau.database.clases.CarritoDeCompra;
import com.sofkau.database.clases.Producto;
import com.sofkau.database.interfaces.I_Carrito_Compra_Producto;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarritoCompraProducto_DAO implements I_Carrito_Compra_Producto {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private CarritoDeCompra_DAO carritoDeCompraDao;
    private CarritoDeCompra misCarritos=null;
    private Producto_DAO producto_dao;
    private Producto misProductos=null;
    private  Inventario_DAO inventarioDao;



    public CarritoCompraProducto_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        carritoDeCompraDao= new CarritoDeCompra_DAO(mySqlOperation);
        inventarioDao = new Inventario_DAO(mySqlOperation);
        producto_dao = new Producto_DAO(mySqlOperation);
    }

    @Override
    public void ingresarCarritoProducto(CarritoCompraProducto crearCarritoProducto) {
        sentenciaSQL = "insert into carrito_compra_producto(id_carrito_compra,nombre_producto,cantidad) values (?,?,?)";
        if (confirmarCarrito(crearCarritoProducto.getId_carrito_compra()) && confirmarProducto(crearCarritoProducto.getNombre_producto())){
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                preparedStatement = mySqlOperation.getPreparedStatement();
                preparedStatement.setInt(1,crearCarritoProducto.getId_carrito_compra());
                preparedStatement.setString(2,crearCarritoProducto.getNombre_producto());
                preparedStatement.setInt(3,crearCarritoProducto.getCantidad());
                mySqlOperation.executeSqlPreparedStatement();
                inventarioDao.disminuirProductoCant(crearCarritoProducto.getCantidad(),crearCarritoProducto.getNombre_producto());
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No se puede agregar los registros");
        }

    }

    private Boolean confirmarProducto (String nom_producto){
        misProductos = producto_dao.obteberProducto(nom_producto);
        if (misProductos !=null){
            return true;
        }
        return false;
    }

    private Boolean confirmarCarrito (int id_carrito){
        misCarritos = carritoDeCompraDao.obtenerCarrito(id_carrito);
        if (misCarritos != null){
            return true;
        }
        return false;
    }
}

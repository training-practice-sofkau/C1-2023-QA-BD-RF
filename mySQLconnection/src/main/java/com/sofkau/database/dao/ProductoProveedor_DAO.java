package com.sofkau.database.dao;

import com.sofkau.database.clases.Producto;
import com.sofkau.database.clases.ProductoProveedor;
import com.sofkau.database.clases.Proveedor;
import com.sofkau.database.interfaces.I_ProductoProveedor;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductoProveedor_DAO implements I_ProductoProveedor {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Producto iproducto=null;
    private Producto_DAO producto_dao;
    private Proveedor razonSociales=null;
    private Proveedor_DAO proveedorDao;

    public ProductoProveedor_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        proveedorDao = new Proveedor_DAO(mySqlOperation);
        producto_dao = new Producto_DAO(mySqlOperation);
    }

    @Override
    public void insertarProdProveedor(ProductoProveedor crearProdProvee) {
        sentenciaSQL= "insert into producto_proveedor(razon_social,nombre_prod) values (?,?)";
        if (confirmarProveedor(crearProdProvee.getRazon_social())){
            if (confirmarProducto(crearProdProvee.getNombre_prod())){

            }
        }
    }
    public Boolean confirmarProducto (String nom_producto){
        iproducto = producto_dao.obteberProducto(nom_producto);
        if (iproducto !=null){
            return true;
        }
        return false;
    }

    public Boolean confirmarProveedor (String razonSocial){
        razonSociales = proveedorDao.obtenerProveedor(razonSocial);
        if (razonSociales !=null){
            return true;
        }
        return false;
    }
}

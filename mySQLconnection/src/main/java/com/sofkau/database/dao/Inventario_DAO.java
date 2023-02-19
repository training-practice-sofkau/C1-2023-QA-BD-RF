package com.sofkau.database.dao;

import com.sofkau.database.clases.Inventario;
import com.sofkau.database.clases.Producto;
import com.sofkau.database.interfaces.I_Inventario;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Inventario_DAO implements I_Inventario {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Producto miProducto=null;
    private Producto_DAO producto_dao;
    private  Inventario miInventario=null;

    public Inventario_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        producto_dao = new Producto_DAO(mySqlOperation);
    }

    @Override
    public void insertarInventario(Inventario crearInventario) {
        sentenciaSQL = "insert into inventario(id_inventario,cant_disponible,nombre_producto) values (?,?,?)";
        if (confirmarProducto(crearInventario.getNombre_producto())){
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                preparedStatement = mySqlOperation.getPreparedStatement();
                preparedStatement.setInt(1,crearInventario.getId_inventario());
                preparedStatement.setInt(2,crearInventario.getCant_disponible());
                preparedStatement.setString(3,crearInventario.getNombre_producto());
                mySqlOperation.executeSqlPreparedStatement();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("Lo sentimos el producto no existe");
        }
    }

    @Override
    public void disminuirProductoCant(int cantidad, String nombre_producto) {
        Inventario miInventarioProd = obtenerInventario(nombre_producto);
        int cantidaActual = miInventarioProd.getCant_disponible();
        if (cantidad < cantidaActual){
            int nuevaCantidad = cantidaActual-cantidad;
            sentenciaSQL = " update inventario set cant_disponible = ? where id_inventario = "+"'"+ miInventarioProd.getId_inventario()+" ' " ;
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                preparedStatement = mySqlOperation.getPreparedStatement();
                preparedStatement.setInt(1,nuevaCantidad);
                mySqlOperation.executeSqlPreparedStatement();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("No esta disponible esa cantidad de productos");
        }
    }

    @Override
    public Inventario obtenerInventario(String nombre_producto) {
        sentenciaSQL = "select * from inventario where nombre_producto=?";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1,nombre_producto);
            resultSet = mySqlOperation.executeQuery();
            resultSet.next();
            miInventario= new Inventario(resultSet.getInt("id_inventario"),resultSet.getInt("cant_disponible"),
                                     resultSet.getString("nombre_producto"));

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return miInventario;
    }

    private Boolean confirmarProducto(String nom_producto){
        miProducto =producto_dao.obteberProducto(nom_producto);
        if (miProducto != null){
            return true;
        }
        return false;
    }
}

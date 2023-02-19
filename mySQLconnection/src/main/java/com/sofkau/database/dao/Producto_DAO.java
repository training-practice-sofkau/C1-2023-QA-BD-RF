package com.sofkau.database.dao;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Producto;
import com.sofkau.database.interfaces.I_Producto;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Producto_DAO implements I_Producto {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Producto> listaProductos;
    private Categoria miCategoria=null;
    private Categoria_DAO categoriaDao;
    private Producto miproducto=null;

    public Producto_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        categoriaDao= new Categoria_DAO(mySqlOperation);
        listaProductos = new ArrayList<>();
    }

    @Override
    public void insertarProducto(Producto crearProducto) {
        sentenciaSQL =  "insert into producto(nom_producto,marca,dimension,foto,precio,id_categorias) values (?,?,?,?,?,?)";
        if (confimarCategoria(crearProducto.getId_categoria())){
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                preparedStatement = mySqlOperation.getPreparedStatement();
                preparedStatement.setString(1,crearProducto.getNom_producto());
                preparedStatement.setString(2,crearProducto.getMarca());
                preparedStatement.setString(3,crearProducto.getDimension());
                preparedStatement.setString(4,crearProducto.getFoto());
                preparedStatement.setDouble(5,crearProducto.getPrecio());
                preparedStatement.setInt(6,crearProducto.getId_categoria());
                mySqlOperation.executeSqlPreparedStatement();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("Lo sentimos la categoria no existe");
        }

    }

    @Override
    public List<Producto> mostrarProducto() {
        sentenciaSQL = "select * from producto";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaProductos.add(new Producto(resultSet.getString("nom_producto"),resultSet.getString("marca"),
                        resultSet.getString("dimension"),resultSet.getString("foto"),resultSet.getDouble("precio"),
                        resultSet.getInt("id_categorias")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaProductos;
    }

    @Override
    public Producto obteberProducto(String nom_producto) {
        sentenciaSQL = "select * from producto where nom_producto=?";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1,nom_producto);
            resultSet = mySqlOperation.executeQuery();
            resultSet.next();
            miproducto=new Producto(resultSet.getString("nom_producto"),resultSet.getString("marca"),
                    resultSet.getString("dimension"),resultSet.getString("foto"),resultSet.getDouble("precio"),
                    resultSet.getInt("id_categorias"));
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return miproducto;
    }

    private Boolean confimarCategoria (int id_categoria){
        miCategoria =categoriaDao.obtenerCategoria(id_categoria);
        if (miCategoria != null){
            return true;
        }
        return false;
    }
}

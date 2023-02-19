package com.sofkau.database.dao;

import com.github.javafaker.Cat;
import com.sofkau.database.clases.Categoria;
import com.sofkau.database.interfaces.I_Categoria;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Categoria_DAO implements I_Categoria {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Categoria> listaCategoria;


    public Categoria_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation=mySqlOperation;
        listaCategoria = new ArrayList<>();
    }

    @Override
    public void insertarCategoria(Categoria crearCategoria)  {
        sentenciaSQL= "insert into categoria (id_categoria,nombre,almacenamiento,observaciones) values (?,?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setInt(1,crearCategoria.getId_categoria());
            preparedStatement.setString(2,crearCategoria.getNombre());
            preparedStatement.setString(3,crearCategoria.getAlmacenamiento());
            preparedStatement.setString(4,crearCategoria.getObservaciones());
            mySqlOperation.executeSqlPreparedStatement();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Categoria> mostrarCategoria() {
        sentenciaSQL = "select * from categoria";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaCategoria.add(new Categoria(resultSet.getInt("id_categoria"),resultSet.getString("nombre"),
                                                 resultSet.getString("almacenamiento"),resultSet.getString("observaciones")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaCategoria;
    }
}

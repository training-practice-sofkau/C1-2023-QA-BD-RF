package com.sofkau.database.dao;

import com.sofkau.database.clases.CarritoDeCompra;
import com.sofkau.database.clases.Categoria;
import com.sofkau.database.interfaces.I_CarritoDeCompra;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarritoDeCompra_DAO implements I_CarritoDeCompra {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<CarritoDeCompra> listaCarritoCompra;

    public CarritoDeCompra_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaCarritoCompra = new ArrayList<>();
    }

    @Override
    public void insertarCarritoCompra(CarritoDeCompra crearCarritoCompra) {
        sentenciaSQL = "insert into carrito_de_compra (id_carrito) values (?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1,crearCarritoCompra.getId_carrito());
            mySqlOperation.executeSqlPreparedStatement();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<CarritoDeCompra> mostrarCarritoCompra() {
        sentenciaSQL = "select * from carrito_de_compra";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaCarritoCompra.add(new CarritoDeCompra(resultSet.getString("id_carrito")));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return listaCarritoCompra;
    }
}

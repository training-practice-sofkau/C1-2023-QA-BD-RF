package com.sofkau.database.dao;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Zona;
import com.sofkau.database.interfaces.I_Zona;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Zona_DAO implements I_Zona {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Zona> listaZonas;

    public Zona_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaZonas = new ArrayList<>();
    }

    @Override
    public void insertarZona(Zona crearZona) {
        sentenciaSQL= "insert into zona (cod_postal,nombre) values (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1,crearZona.getCod_postal());
            preparedStatement.setString(2,crearZona.getNombre());
            mySqlOperation.executeSqlPreparedStatement();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Zona> mostrarZona() {

        sentenciaSQL = "select * from zona";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaZonas.add(new Zona(resultSet.getString("codigo_postal"),resultSet.getString("nombre")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }return null;
    }
}

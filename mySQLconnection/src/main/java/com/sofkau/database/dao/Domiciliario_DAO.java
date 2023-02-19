package com.sofkau.database.dao;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Domiciliario;
import com.sofkau.database.interfaces.I_Domiciliario;
import com.sofkau.database.mysql.MySqlOperation;

import java.net.DatagramPacket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Domiciliario_DAO implements I_Domiciliario {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    private List<Domiciliario> listaDomiciliario;

    public Domiciliario_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaDomiciliario = new ArrayList<>();
    }

    @Override
    public void insertarDomiciliario(Domiciliario crearDomiciliario) {
        sentenciaSQL= "insert into domiciliario(cedula_domiciliario,nombre,num_matricula) values (?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1,crearDomiciliario.getCedula_domiciliario());
            preparedStatement.setString(2,crearDomiciliario.getNombre());
            preparedStatement.setString(3,crearDomiciliario.getNum_matricula());
            mySqlOperation.executeSqlPreparedStatement();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public List<Domiciliario> mostrarDomiciliario() {
        sentenciaSQL = "select * from domiciliario";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaDomiciliario.add(new Domiciliario(resultSet.getString("cedula_domiciliario"),
                        resultSet.getString("nombre"),resultSet.getString("num_matricula")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaDomiciliario;
    }
}

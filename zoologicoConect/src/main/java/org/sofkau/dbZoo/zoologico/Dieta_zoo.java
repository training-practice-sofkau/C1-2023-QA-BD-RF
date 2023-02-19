package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Dieta;
import org.sofkau.dbZoo.clases.Veterinario;
import org.sofkau.dbZoo.interfaces.IDieta;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dieta_zoo implements IDieta {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Dieta> listadieta;

    public Dieta_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listadieta = new ArrayList<>();
    }
    @Override
    public void insertDieta(Dieta crearDieta) {

        sentenciaSQL = "INSERT INTO dieta (id_dieta,recomendaciones,id_animals) VALUES (?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearDieta.getId_dieta());
            preparedStatement.setString(2, crearDieta.getRecomendaciones());
            preparedStatement.setString(3, crearDieta.getId_animales());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Dieta> mostrarDieta() {
        sentenciaSQL = "select * from dieta";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listadieta.add(new Dieta(resultSet.getString("id_dieta"),resultSet.getString("recomendaciones"),
                        resultSet.getString("id_animals")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listadieta;


    }
    }


package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Dieta_veterinario;
import org.sofkau.dbZoo.clases.Entrenador_animal;
import org.sofkau.dbZoo.interfaces.IEntrenador_animal;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Entrenador_animal_zoo implements IEntrenador_animal {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Entrenador_animal> listaEA;

    public Entrenador_animal_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaEA = new ArrayList<>();
    }
    @Override
    public void inserEntrenador_animal(Entrenador_animal crearEntrenador_animal) {

        sentenciaSQL = "INSERT INTO entrenador_animal (id_animal_,id_entrenador_) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearEntrenador_animal.getId_animal_());
            preparedStatement.setString(2, crearEntrenador_animal.getId_entrenador_());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Entrenador_animal> mostrarEntrenador_animal() {

        sentenciaSQL = "select * from entrenador_animal";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaEA.add(new Entrenador_animal(resultSet.getString("id_animal_"),
                        resultSet.getString("id_entrenador_")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaEA;
    }
}

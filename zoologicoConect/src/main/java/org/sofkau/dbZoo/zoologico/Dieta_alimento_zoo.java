package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Clasificacion_animal;
import org.sofkau.dbZoo.clases.Dieta_alimento;
import org.sofkau.dbZoo.interfaces.IDieta_Alimento;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dieta_alimento_zoo implements IDieta_Alimento {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Dieta_alimento> listaDA;

    public Dieta_alimento_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaDA = new ArrayList<>();
    }
    @Override
    public void insertDieta_Alimento(Dieta_alimento crearDieta_alimento) {

        sentenciaSQL = "INSERT INTO dieta_alimento (id_dietas,id_aliments) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearDieta_alimento.getId_dietas());
            preparedStatement.setString(2, crearDieta_alimento.getId_aliments());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Dieta_alimento> mostrarDietaAlimento() {
        sentenciaSQL = "select * from dieta_alimento";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaDA.add(new Dieta_alimento(resultSet.getString("id_dietas"),
                        resultSet.getString("id_aliments")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaDA;
    }
}

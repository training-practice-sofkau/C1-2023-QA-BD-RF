package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Entrenador_animal;
import org.sofkau.dbZoo.clases.Peso_historial;
import org.sofkau.dbZoo.interfaces.IPeso_historial;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Peso_animal_zoo implements IPeso_historial {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Peso_historial> listaPH;

    public Peso_animal_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaPH = new ArrayList<>();
    }
    @Override
    public void insertPeso(Peso_historial crearPeso) {

        sentenciaSQL = "INSERT INTO peso_historial (id_animales_,peso) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearPeso.getId_animales_());
            preparedStatement.setString(2, crearPeso.getPeso());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Peso_historial> mostrarPeso() {

        sentenciaSQL = "select * from peso_historial";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaPH.add(new Peso_historial(resultSet.getString("id_animales_"),
                        resultSet.getString("peso")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaPH;
    }
}

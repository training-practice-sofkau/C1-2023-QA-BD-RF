
package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Alimento_logistico;
import org.sofkau.dbZoo.clases.Clasificacion_animal;
import org.sofkau.dbZoo.interfaces.IClasificacion_animal;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Clasificacion_animal_zoo implements IClasificacion_animal {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Clasificacion_animal> listaCL;

    public Clasificacion_animal_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaCL = new ArrayList<>();
    }
    @Override
    public void insertClasificacion_animal(Clasificacion_animal crearClasificacion_animal) {

        sentenciaSQL = "INSERT INTO clasificacion_animal (id_animales,clasifiacion) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearClasificacion_animal.getId_animales());
            preparedStatement.setString(2, crearClasificacion_animal.getClasificacion());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Clasificacion_animal> mostrarClasificacionAnimal() {

        sentenciaSQL = "select * from clasificacion_animal";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaCL.add(new Clasificacion_animal(resultSet.getString("id_animales"),
                        resultSet.getString("clasificacion")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaCL;
    }
}

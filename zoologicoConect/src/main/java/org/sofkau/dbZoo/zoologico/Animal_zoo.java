package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Animal;
import org.sofkau.dbZoo.clases.Veterinario;
import org.sofkau.dbZoo.interfaces.IAnimal;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Animal_zoo implements IAnimal {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Animal> listaanimals;

    public Animal_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaanimals = new ArrayList<>();
    }
    @Override
    public void insertAnimal(Animal crearAnimal) {

        sentenciaSQL = "INSERT INTO animal (id_animal,nombre,sexo,fecha_nacimiento,edad) VALUES (?,?,?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearAnimal.getId_animal());
            preparedStatement.setString(2, crearAnimal.getNombre());
            preparedStatement.setString(3, crearAnimal.getSexo());
            preparedStatement.setString(4, crearAnimal.getFecha_nacimiento());
            preparedStatement.setString(5, crearAnimal.getEdad());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Animal> mostrarAnimal() {
        sentenciaSQL = "select * from animal";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaanimals.add(new Animal(resultSet.getString("id_animal"),resultSet.getString("nombre"),
                        resultSet.getString("sexo"),resultSet.getString("fecha_nacimiento"),
                        resultSet.getString("edad")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaanimals;
    }
}

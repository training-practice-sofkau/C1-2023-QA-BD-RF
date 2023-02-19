package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Veterinario;
import org.sofkau.dbZoo.interfaces.IVeterinario;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Veterinario_zoo implements IVeterinario {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Veterinario> listaveter;

    public Veterinario_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaveter = new ArrayList<>();
    }

    @Override
    public void insertVeterinario(Veterinario crearVeterinario) {
        sentenciaSQL = "INSERT INTO veterinario (id_veterinario,nombre,telefono) VALUES (?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearVeterinario.getId_veterinario());
            preparedStatement.setString(2, crearVeterinario.getNombre());
            preparedStatement.setString(3, crearVeterinario.getTelefono());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Veterinario> mostrarVeterinario() {
        sentenciaSQL = "select * from veterinario";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaveter.add(new Veterinario(resultSet.getString("id_veterinario"),resultSet.getString("nombre"),
                        resultSet.getString("telefono")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaveter;


    }
}



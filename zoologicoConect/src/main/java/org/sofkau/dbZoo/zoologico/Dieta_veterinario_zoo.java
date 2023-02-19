package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Dieta_alimento;
import org.sofkau.dbZoo.clases.Dieta_veterinario;
import org.sofkau.dbZoo.interfaces.IDieta_veterinario;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Dieta_veterinario_zoo implements IDieta_veterinario {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Dieta_veterinario> listaDV;

    public Dieta_veterinario_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaDV = new ArrayList<>();
    }
    @Override
    public void insertDietaVeterinario(Dieta_veterinario crearDietaVeterinario) {

        sentenciaSQL = "INSERT INTO dieta_veterinario (id_dieta_,id_veterinario) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearDietaVeterinario.getId_dieta_());
            preparedStatement.setString(2, crearDietaVeterinario.getId_veterinario());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Dieta_veterinario> mostrarDietaVeterinario() {

        sentenciaSQL = "select * from dieta_veterinario";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaDV.add(new Dieta_veterinario(resultSet.getString("id_dieta_"),
                        resultSet.getString("id_veterinario")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaDV;
    }
}

package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Entrenador;
import org.sofkau.dbZoo.interfaces.IEntrenador;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Entrenador_zoo implements IEntrenador {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Entrenador> listaentren;

    public Entrenador_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaentren = new ArrayList<>();
    }
    @Override
    public void insertEntrenador(Entrenador crearEntrenador) {

        sentenciaSQL = "INSERT INTO entrenador (id_entrenador,nombre,telefono,id_veterinarios) VALUES (?,?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearEntrenador.getId_entrenador());
            preparedStatement.setString(2, crearEntrenador.getNombre());
            preparedStatement.setString(3, crearEntrenador.getTelefono());
            preparedStatement.setString(4, crearEntrenador.getId_veterinarios());

            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



    @Override
    public List<Entrenador> mostrarEntrenador() {
        sentenciaSQL = "select * from entrenador";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaentren.add(new Entrenador(resultSet.getString("id_entrenador"),resultSet.getString("nombre"),
                        resultSet.getString("telefono"),resultSet.getString("id_veterinarios")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaentren;
    }
}

package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Alimento;
import org.sofkau.dbZoo.clases.Veterinario;
import org.sofkau.dbZoo.interfaces.IAlimento;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Alimento_zoo implements IAlimento {

    private MySqlOperation mySqlOperation;

    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Alimento> listaalimento;

    public Alimento_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaalimento = new ArrayList<>();
    }

    @Override
    public void insertAlimento(Alimento crearAlimento) {

        sentenciaSQL = "INSERT INTO alimento (id_alimento,nombre,dosis) VALUES (?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearAlimento.getId_alimento());
            preparedStatement.setString(2, crearAlimento.getNombre());
            preparedStatement.setString(3, crearAlimento.getDosis());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Alimento> mostrarAlimento() {
                   sentenciaSQL = "select * from alimento";
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                resultSet = mySqlOperation.executeQuery();
                while (resultSet.next()){
                    listaalimento.add(new Alimento(resultSet.getString("id_alimento"),resultSet.getString("nombre"),
                            resultSet.getString("dosis")));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return listaalimento;
    }
}

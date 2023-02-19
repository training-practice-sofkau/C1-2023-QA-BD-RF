package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Entrenador_animal;
import org.sofkau.dbZoo.clases.Tipo_alimento;
import org.sofkau.dbZoo.interfaces.ITipo_alimento;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Tipo_alimento_zoo implements ITipo_alimento {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Tipo_alimento> listaTA;

    public Tipo_alimento_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaTA = new ArrayList<>();
    }
    @Override
    public void insertTipoAlimento(Tipo_alimento crearTipoAlimento) {
        sentenciaSQL = "INSERT INTO tipo_alimento (id_aliment,tipo) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearTipoAlimento.getId_aliment());
            preparedStatement.setString(2, crearTipoAlimento.getTipo());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Tipo_alimento> mostrarTipoAlimento() {

        sentenciaSQL = "select * from tipo_alimento";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaTA.add(new Tipo_alimento(resultSet.getString("id_aliment"),
                        resultSet.getString("tipo")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaTA;
    }
}

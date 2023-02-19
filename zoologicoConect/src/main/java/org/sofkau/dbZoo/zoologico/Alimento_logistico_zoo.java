package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Alimento_logistico;
import org.sofkau.dbZoo.interfaces.IAlimento_logistico;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Alimento_logistico_zoo implements IAlimento_logistico {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Alimento_logistico> listaal;

    public Alimento_logistico_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaal = new ArrayList<>();
    }
    @Override
    public void insertAlimento_logistico(Alimento_logistico crearAlimento_logistico) {

        sentenciaSQL = "INSERT INTO alimento_logistico (id_alimento_,id_logistico) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearAlimento_logistico.getId_alimento_());
            preparedStatement.setString(2, crearAlimento_logistico.getId_logistico());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Alimento_logistico> mostrarAlimento_logistico() {
        sentenciaSQL = "select * from alimento_logistico";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaal.add(new Alimento_logistico(resultSet.getString("id_alimento_"),
                        resultSet.getString("id_logistico")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaal;
    }

}

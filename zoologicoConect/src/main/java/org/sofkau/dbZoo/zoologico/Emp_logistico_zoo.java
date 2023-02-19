package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Emp_logistico;
import org.sofkau.dbZoo.interfaces.IEmp_logistico;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Emp_logistico_zoo implements IEmp_logistico {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Emp_logistico> listalog;

    public Emp_logistico_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listalog = new ArrayList<>();
    }
    @Override
    public void insertEmp_logistico(Emp_logistico crearEmp_logistico) {

        sentenciaSQL = "INSERT INTO emp_logistic (id_logistico,nombre,correo) VALUES (?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearEmp_logistico.getId_logistico());
            preparedStatement.setString(2, crearEmp_logistico.getNombre());
            preparedStatement.setString(3, crearEmp_logistico.getCorreo());

            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Emp_logistico> mostrarEmp_logistico() {
        sentenciaSQL = "select * from emp_logistic";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listalog.add(new Emp_logistico(resultSet.getString("id_logistico"),resultSet.getString("nombre"),
                        resultSet.getString("correo")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listalog;
    }
}

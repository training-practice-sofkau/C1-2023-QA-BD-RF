package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Factura;
import org.sofkau.dbZoo.clases.Veterinario;
import org.sofkau.dbZoo.interfaces.IFactura;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Factura_zoo implements IFactura {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Factura> listafac;

    public Factura_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listafac = new ArrayList<>();
    }
    @Override
    public void insertFactura(Factura crearFactura) {
        sentenciaSQL = "INSERT INTO factura (id_factura,fecha,total) VALUES (?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearFactura.getId_factura());
            preparedStatement.setString(2, crearFactura.getFecha());
            preparedStatement.setString(3, crearFactura.getTotal());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Factura> mostrarFactura() {
        sentenciaSQL = "select * from factura";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listafac.add(new Factura(resultSet.getString("id_factura"),resultSet.getString("fecha"),
                        resultSet.getString("total")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listafac;
    }
}

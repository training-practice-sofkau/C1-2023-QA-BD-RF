package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Factura;
import org.sofkau.dbZoo.clases.Orden_compra;
import org.sofkau.dbZoo.interfaces.IOrden_compra;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Orden_compra_zoo implements IOrden_compra {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Orden_compra> listaorden;

    public Orden_compra_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaorden = new ArrayList<>();
    }
    @Override
    public void insertOrden_compra(Orden_compra crearOrden_compra) {

        sentenciaSQL = "INSERT INTO orden_compra (id_orden,fecha,nombre_alimento,cantidad,id_logisticos,id_proveedors,observaciones) " +
                "VALUES (?,?,?,?,?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearOrden_compra.getId_orden());
            preparedStatement.setString(2, crearOrden_compra.getFecha());
            preparedStatement.setString(3, crearOrden_compra.getNombre_alimento());
            preparedStatement.setString(4,crearOrden_compra.getCantidad());
            preparedStatement.setString(5, crearOrden_compra.getId_logisticos());
            preparedStatement.setString(6, crearOrden_compra.getId_proveedors());
            preparedStatement.setString(7,crearOrden_compra.getOnservaciones());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Orden_compra> mostrarOrden_compra() {

        sentenciaSQL = "select * from orden_compra";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaorden.add(new Orden_compra(resultSet.getString("id_orden"),resultSet.getString("fecha"),
                        resultSet.getString("nomre_alimento"),resultSet.getString("cantidad"),
                        resultSet.getString("id_logisticos"),resultSet.getString("id_proveedors"),
                        resultSet.getString("observaciones")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaorden;
    }
}

package org.sofkau.dbZoo.zoologico;

import org.sofkau.dbZoo.clases.Entrenador_animal;
import org.sofkau.dbZoo.clases.Proveedor_factura;
import org.sofkau.dbZoo.interfaces.IProveedor_factura;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Proveedor_factura_zoo implements IProveedor_factura {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Proveedor_factura> listaPF;

    public Proveedor_factura_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaPF = new ArrayList<>();
    }
    @Override
    public void insertProveedorFactura(Proveedor_factura crearProveedorFactura) {

        sentenciaSQL = "INSERT INTO proveedor_factura (id_proveed,id_facturas) VALUES (?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearProveedorFactura.getId_proveed());
            preparedStatement.setString(2, crearProveedorFactura.getId_factura());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Proveedor_factura> mostrarProveedorFactura() {
        sentenciaSQL = "select * from proveedor_factura";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaPF.add(new Proveedor_factura(resultSet.getString("id_proveed"),
                        resultSet.getString("id_facturas")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaPF;
    }
}

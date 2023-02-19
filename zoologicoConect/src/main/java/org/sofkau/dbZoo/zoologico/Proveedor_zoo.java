package org.sofkau.dbZoo.zoologico;

import com.github.javafaker.Faker;
import org.sofkau.dbZoo.clases.Proveedor;
import org.sofkau.dbZoo.clases.Veterinario;
import org.sofkau.dbZoo.interfaces.IProveedor;
import org.sofkau.dbZoo.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Proveedor_zoo implements IProveedor {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Proveedor> listaprovee;

    public Proveedor_zoo(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaprovee = new ArrayList<>();
    }
    @Override
    public void insertProveedor(Proveedor crearProveedor) {
        sentenciaSQL = "INSERT INTO proveedor (id_proveedor,nombre,direccion,correo) VALUES (?,?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1, crearProveedor.getId_proveedor());
            preparedStatement.setString(2, crearProveedor.getNombre());
            preparedStatement.setString(3, crearProveedor.getDireccion());
            preparedStatement.setString(4,crearProveedor.getCorreo());
            mySqlOperation.executeSqlPreparedStatement();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Proveedor> mostrarProveedor() {
        sentenciaSQL = "select * from proveedor";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaprovee.add(new Proveedor(resultSet.getString("id_proveedor"),resultSet.getString("nombre"),
                        resultSet.getString("direccion"),resultSet.getString("correo")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listaprovee;
    }
}

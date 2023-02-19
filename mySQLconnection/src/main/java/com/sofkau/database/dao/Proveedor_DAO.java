package com.sofkau.database.dao;

import com.sofkau.database.clases.Categoria;
import com.sofkau.database.clases.Proveedor;
import com.sofkau.database.interfaces.I_Proveedor;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Proveedor_DAO implements I_Proveedor {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL = " ";
    private PreparedStatement preparedStatements;
    private ResultSet resultSet;
    private List<Proveedor> listaProveedores;
    private Proveedor miproveedor = null;

    public Proveedor_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        listaProveedores = new ArrayList<>();
    }

    @Override
    public void insertarProveedor(Proveedor crearProveedor) {
        sentenciaSQL = "insert into proveedor (razon_social,telefono,correo) values (?,?,?)";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatements = mySqlOperation.getPreparedStatement();
            preparedStatements.setString(1, crearProveedor.getRazon_social());
            preparedStatements.setString(2, crearProveedor.getTelefono());
            preparedStatements.setString(3, crearProveedor.getCorreo());
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
            while (resultSet.next()) {
                listaProveedores.add(new Proveedor(resultSet.getString("razon_social"), resultSet.getString("telefono"),
                        resultSet.getString("correo")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listaProveedores;
    }

    @Override
    public Proveedor obtenerProveedor(String razon_social) {
        sentenciaSQL = "select * from proveedor where razon_social=?";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatements = mySqlOperation.getPreparedStatement();
            preparedStatements.setString(1,razon_social);
            resultSet = mySqlOperation.executeQuery();
            resultSet.next();
            miproveedor=new Proveedor(resultSet.getString("razon_social"),resultSet.getString("telefono"),
                    resultSet.getString("correo"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return  miproveedor;
    }
}
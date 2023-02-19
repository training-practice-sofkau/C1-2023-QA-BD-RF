package com.sofkau.database.dao;

import com.sofkau.database.clases.Cliente;
import com.sofkau.database.clases.Producto;
import com.sofkau.database.clases.Zona;
import com.sofkau.database.interfaces.I_Cliente;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente_DAO implements I_Cliente {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private List<Cliente> listClientes;
    private Zona miZona=null;
    private Zona_DAO zonaDao;

    public Cliente_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        zonaDao = new Zona_DAO(mySqlOperation);
        listClientes = new ArrayList<>();
    }

    @Override
    public void insertarCliente(Cliente crearCliente) {
        sentenciaSQL = "insert into cliente(ced_cliente,nombre,direccion,correo,contrasena,codigo_postal) values (?,?,?,?,?,?)";
        if (confimarZona(crearCliente.getCodigo_postal())){
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                preparedStatement = mySqlOperation.getPreparedStatement();
                preparedStatement.setString(1,crearCliente.getCed_cliente());
                preparedStatement.setString(2,crearCliente.getNombre());
                preparedStatement.setString(3,crearCliente.getDireccion());
                preparedStatement.setString(4,crearCliente.getCorreo());
                preparedStatement.setString(5,crearCliente.getContrasena());
                preparedStatement.setString(6,crearCliente.getCodigo_postal());
                mySqlOperation.executeSqlPreparedStatement();

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }else {
            System.out.println("Lo sentimos la zona no existe");
        }

    }
    @Override
    public List<Cliente> mostrarCliente() {
        sentenciaSQL = "select * from cliente";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listClientes.add(new Cliente(resultSet.getString("ced_cliente"),resultSet.getString("nombre"),
                                resultSet.getString("direccion"),resultSet.getString("correo"),
                        resultSet.getString("contrasena"),resultSet.getString("codigo_postal")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return listClientes;
    }

    private Boolean confimarZona (String codo_postal){
        miZona =zonaDao.obtenerZona(codo_postal);
        if (miZona != null){
            return true;
        }
        return false;
    }
}

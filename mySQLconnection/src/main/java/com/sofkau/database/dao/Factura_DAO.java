package com.sofkau.database.dao;

import com.sofkau.database.clases.Cliente;
import com.sofkau.database.clases.Domiciliario;
import com.sofkau.database.clases.Factura;
import com.sofkau.database.clases.Pedido;
import com.sofkau.database.interfaces.I_Factura;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Factura_DAO implements I_Factura {

    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private Domiciliario_DAO domiciliarioDao;
    private Domiciliario miDomiciliario=null;
    private Cliente_DAO clienteDao;
    private Cliente miCliente=null;
    private Pedido_DAO pedidoDao;
    private Pedido miPedido=null;

    public Factura_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        domiciliarioDao = new Domiciliario_DAO(mySqlOperation);
        clienteDao = new Cliente_DAO(mySqlOperation);
        pedidoDao =new Pedido_DAO(mySqlOperation);
    }

    @Override
    public void insertarFactura(Factura crearFactura) {
        sentenciaSQL = "insert into factura(codigo_factura,total,ced_domiciliario,cedula_cliente,cod_pedido) values (?,?,?,?,?)";
        if (confirmarDomiciliario(crearFactura.getCed_domiciliario()) && confirmarCliente(crearFactura.getCedula_cliente()) && confirmarPedido(crearFactura.getCod_pedido())){
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                preparedStatement = mySqlOperation.getPreparedStatement();
                preparedStatement.setString(1,crearFactura.getCodigo_factura());
                preparedStatement.setInt(2,crearFactura.getTotal());
                preparedStatement.setString(3,crearFactura.getCed_domiciliario());
                preparedStatement.setString(4,crearFactura.getCedula_cliente());
                preparedStatement.setString(5,crearFactura.getCod_pedido());
                mySqlOperation.executeSqlPreparedStatement();

            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }

    }

    private Boolean confirmarDomiciliario (String cedula_domiciliario){
        miDomiciliario = domiciliarioDao.obtenerDomiciliario(cedula_domiciliario);
        if (miDomiciliario != null){
            return true;
        }
        return false;
    }

    private Boolean confirmarCliente (String ced_cliente){
        miCliente = clienteDao.obtenerCliente(ced_cliente);
        if (miCliente != null){
            return true;
        }
        return false;
    }
    private Boolean confirmarPedido (String codigo_pedido){
        miPedido = pedidoDao.obtenerPedido(codigo_pedido);
        if (miPedido != null){
            return true;
        }
        return false;
    }
}

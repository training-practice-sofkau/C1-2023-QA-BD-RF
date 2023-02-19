package com.sofkau.database.dao;

import com.sofkau.database.clases.CarritoDeCompra;
import com.sofkau.database.clases.Pedido;
import com.sofkau.database.interfaces.I_Pedido;
import com.sofkau.database.mysql.MySqlOperation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pedido_DAO implements I_Pedido {
    private MySqlOperation mySqlOperation;
    private String sentenciaSQL= " ";
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    private CarritoDeCompra_DAO carritoDeCompraDao;
    private CarritoDeCompra miCarrito=null;
    private Pedido miPedido=null;
    private List<Pedido> listaPedido;

    public Pedido_DAO(MySqlOperation mySqlOperation) {
        this.mySqlOperation = mySqlOperation;
        carritoDeCompraDao = new CarritoDeCompra_DAO(mySqlOperation);
        listaPedido = new ArrayList<>();
    }

    @Override
    public void insertarPedido(Pedido crearPedido) {
        sentenciaSQL = "insert into pedido(codigo_pedido,fecha,num_tarjeta,fecha_caducidad,id_carrito_compra) values (?,?,?,?,?)";
        if (confirmarCarrito(crearPedido.getId_carrito())){
            try {
                mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
                preparedStatement = mySqlOperation.getPreparedStatement();
                preparedStatement.setString(1,crearPedido.getCodigo_pedido());
                preparedStatement.setDate(2,crearPedido.getFecha());
                preparedStatement.setString(3,crearPedido.getNum_tarjeta());
                preparedStatement.setDate(4,crearPedido.getFecha_caducidad());
                preparedStatement.setInt(5,crearPedido.getId_carrito());
                mySqlOperation.executeSqlPreparedStatement();
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
        }else  {
            System.out.println("lo sentimos el pedido no existe");
        }
    }

    @Override
    public List<Pedido> mostrarPedido() {
        sentenciaSQL = "select * from pedido";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            resultSet = mySqlOperation.executeQuery();
            while (resultSet.next()){
                listaPedido.add(new Pedido(resultSet.getString("codigo_pedido"),resultSet.getDate("fecha"),
                        resultSet.getString("num_tarjeta"),resultSet.getDate("fecha_caducidad"),
                        resultSet.getInt("id_carrito_compra")));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return listaPedido;
    }

    @Override
    public Pedido obtenerPedido(String codigo_pedido) {
        sentenciaSQL = "select * from pedido where codigo_pedido=?";
        try {
            mySqlOperation.setSqlPreparedStatement(sentenciaSQL);
            preparedStatement = mySqlOperation.getPreparedStatement();
            preparedStatement.setString(1,codigo_pedido);
            resultSet = mySqlOperation.executeQuery();
            resultSet.next();
            miPedido = new Pedido(resultSet.getString("codigo_pedido"),resultSet.getDate("fecha"),
                    resultSet.getString("num_trajeta"),resultSet.getDate("fecha_caducidad"),
                    resultSet.getInt("id_carrito_compra"));

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return miPedido;
    }

    private Boolean confirmarCarrito (int id_carrito){
        miCarrito = carritoDeCompraDao.obtenerCarrito(id_carrito);
        if (miCarrito != null){
            return true;
        }
        return false;
    }
}

package com.sofkau;

import com.sofkau.integration.Tienda;
import com.sofkau.integration.database.MySqlConnector;

public class Main {
    public static void main(String[] args) {
        MySqlConnector connector = new MySqlConnector(
                "TiendaVirtual",
                "root",
                "123456789"
        );
        connector.connect();

        Tienda tienda = new Tienda(connector);

        //tienda.insertarZona();
        //tienda.insertarDomiciliario();
        //tienda.insertarCliente();
        //tienda.insertarTelefonoCliente();
        //tienda.insertarCategoria();
        //tienda.insertarProveedor();
        //tienda.insertarProducto();
        //tienda.insertarPedido();
        //tienda.insertarPedidoProducto();
        //tienda.insertarCarritoCompras();
        //tienda.insertarCarcomprasPedido();



        connector.closeConnection();
    }
}
package com.sofka;

import com.sofka.integration.Tienda;
import com.sofka.integration.database.MySqlConnector;

public class Main {
    public static void main(String[] args) {
        MySqlConnector connector = new MySqlConnector(
                "tienda",
                "root",
                "1234567890"
        );
        connector.connect();

        Tienda tienda = new Tienda(connector);

        tienda.insertarCliente();
        tienda.insertarTelefonoCliente();
        tienda.insertarProveedor();
        tienda.insertarTelefonoProveedor();
        tienda.insertarCategoria();
        tienda.insertarProducto();
        tienda.insertarDomiciliario();
        tienda.insertarPedido();
        tienda.insertarProductoPedido();


        connector.closeConnection();
    }
}
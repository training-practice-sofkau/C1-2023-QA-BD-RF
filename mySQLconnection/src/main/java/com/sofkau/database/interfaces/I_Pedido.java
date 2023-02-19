package com.sofkau.database.interfaces;

import com.sofkau.database.clases.Pedido;

import java.util.List;

public interface I_Pedido {
    public void insertarPedido (Pedido crearPedido);
    List<Pedido> mostrarPedido();
    public Pedido obtenerPedido(String codigo_pedido);
}

package com.sofkau.models;

public class Datalle_Pedido {
    private int idPedido;
    private int idProducto;
    private int cantidadProductos;
    public Datalle_Pedido(int idPedido, int idProducto, int cantidadProductos) {
        this.idPedido = idPedido;
        this.idProducto = idProducto;

    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    public Datalle_Pedido() {
    }

    @Override
    public String toString() {
        return "Datalle_Pedido{" +
                "idPedido=" + idPedido +
                ", idProducto=" + idProducto +
                ", cantidadProductos=" + cantidadProductos +
                '}';
    }
}

package com.sofkau.database.clases;

public class CarritoCompraProducto {

    private int id_carrito_compra;
    private String nombre_producto;
    private int cantidad;

    public CarritoCompraProducto(int id_carrito_compra, String nombre_producto, int cantidad) {
        this.id_carrito_compra = id_carrito_compra;
        this.nombre_producto = nombre_producto;
        this.cantidad = cantidad;
    }

    public int getId_carrito_compra() {
        return id_carrito_compra;
    }

    public void setId_carrito_compra(int id_carrito_compra) {
        this.id_carrito_compra = id_carrito_compra;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}

package com.sofkau.integration.models;

public class Producto {
    private String ref;
    private double precio;
    private int cantidad;
    private String nombre_producto;
    private int id_proveedor;

    public Producto() {
    }

    public Producto(String ref, double precio, int cantidad, String nombre_producto, int id_proveedor) {
        this.ref = ref;
        this.precio = precio;
        this.cantidad = cantidad;
        this.nombre_producto = nombre_producto;
        this.id_proveedor = id_proveedor;
    }


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }
}

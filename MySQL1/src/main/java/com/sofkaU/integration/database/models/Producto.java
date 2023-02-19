package com.sofkaU.integration.database.models;

import com.github.javafaker.IdNumber;

public class Producto {
    Integer REF;
    String nombre;
    Integer cantidad;
    double precioCompra;
    double precioVenta;
    Integer NITproveedor;

    public Producto(Integer REF, String nombre, Integer cantidad, double precioCompra, double precioVenta, Integer NITproveedor) {
        this.REF = REF;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.NITproveedor = NITproveedor;
    }

    public Producto() {
    }

    public Integer getREF() {
        return REF;
    }

    public void setREF(Integer REF) {
        this.REF = REF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getNITproveedor() {
        return NITproveedor;
    }

    public void setNITproveedor(Integer NITproveedor) {
        this.NITproveedor = NITproveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "REF=" + REF +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precioCompra=" + precioCompra +
                ", precioVenta=" + precioVenta +
                ", NITproveedor=" + NITproveedor +
                '}';
    }
}

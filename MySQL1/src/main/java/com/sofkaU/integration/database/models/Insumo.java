package com.sofkaU.integration.database.models;

public class Insumo {
    Integer REF;
    String nombre;
    Integer cantidad;
    double precioCompra;
    Integer NITProveedor;

    public Insumo(Integer REF, String nombre, Integer cantidad, double precioCompra, Integer NITProveedor) {
        this.REF = REF;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precioCompra = precioCompra;
        this.NITProveedor = NITProveedor;
    }

    public Insumo() {
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

    public Integer getNITProveedor() {
        return NITProveedor;
    }

    public void setNITProveedor(Integer NITProveedor) {
        this.NITProveedor = NITProveedor;
    }

    @Override
    public String toString() {
        return "Insumo{" +
                "REF=" + REF +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precioCompra=" + precioCompra +
                ", NITProveedor=" + NITProveedor +
                '}';
    }
}

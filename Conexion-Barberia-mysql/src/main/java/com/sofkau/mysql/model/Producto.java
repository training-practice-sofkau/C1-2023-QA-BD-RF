package com.sofkau.mysql.model;

public class Producto {
    private Long ref;
    private String nombre;
    private Integer cantidad;
    private Double precio;
    private String proveedor;

    public Producto(Long ref, String nombre, Integer cantidad, Double precio, String proveedor) {
        this.ref = ref;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedor = proveedor;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "ref=" + ref +
                ", nombre='" + nombre + '\'' +
                ", cantidad=" + cantidad +
                ", precio=" + precio +
                ", proveedor='" + proveedor + '\'' +
                '}';
    }

    public Producto() {
    }

    public Long getRef() {
        return ref;
    }

    public void setRef(Long ref) {
        this.ref = ref;
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

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}

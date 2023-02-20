package com.co.sofkaU.integration.model;

import lombok.Data;

@Data
public class Producto {
    private int REFProducto;
    private int cantidadProducto;
    private double precioProducto;
    private String nombreProducto;

    public Producto(int cantidadProducto, double precioProducto, String nombreProducto) {
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.nombreProducto = nombreProducto;
    }
}

package com.sofkau.integracion.database.modelos;

public class Producto {
    private String nombreProducto;
    private String marca;
    private String origen;
    private String dimensiones;
    private int unidadesDisponibles;
    private String nombreCategoria;

    public Producto(String nombreProducto, String marca, String origen, String dimensiones, int unidadesDisponibles, String nombreCategoria) {
        this.nombreProducto = nombreProducto;
        this.marca = marca;
        this.origen = origen;
        this.dimensiones = dimensiones;
        this.unidadesDisponibles = unidadesDisponibles;
        this.nombreCategoria = nombreCategoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDimensiones() {
        return dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }
}

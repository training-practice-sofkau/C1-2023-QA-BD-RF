package com.sofkau.database.clases;

public class Inventario {
    private int id_inventario;
    private int cant_disponible;
    private String nombre_producto;

    public Inventario(int id_inventario, int cant_disponible, String nombre_producto) {
        this.id_inventario = id_inventario;
        this.cant_disponible = cant_disponible;
        this.nombre_producto = nombre_producto;
    }

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }

    public int getCant_disponible() {
        return cant_disponible;
    }

    public void setCant_disponible(int cant_disponible) {
        this.cant_disponible = cant_disponible;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }
}

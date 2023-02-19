package com.sofkau.database.clases;

public class Categoria {
    private int id_categoria;
    private String nombre;
    private String almacenamiento;
    private String observaciones;

    public Categoria(int id_categoria, String nombre, String almacenamiento, String observaciones) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.almacenamiento = almacenamiento;
        this.observaciones = observaciones;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlmacenamiento() {
        return almacenamiento;
    }

    public void setAlmacenamiento(String almacenamiento) {
        this.almacenamiento = almacenamiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

}

package com.sofkau.models;

public class Categoria {
    private int ID;
    private String nombre;
    private String observaciones;
    private String condiciones_almacenamiento;

    public Categoria() {
    }

    public Categoria(int ID, String nombre, String observaciones, String condiciones_almacenamiento) {
        this.ID = ID;
        this.nombre = nombre;
        this.observaciones = observaciones;
        this.condiciones_almacenamiento = condiciones_almacenamiento;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getCondiciones_almacenamiento() {
        return condiciones_almacenamiento;
    }

    public void setCondiciones_almacenamiento(String condiciones_almacenamiento) {
        this.condiciones_almacenamiento = condiciones_almacenamiento;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", observaciones='" + observaciones + '\'' +
                ", condiciones_almacenamiento='" + condiciones_almacenamiento + '\'' +
                '}';
    }
}

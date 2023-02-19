package com.sofkau.integration.database.models;

public class Alimento {

    String id_alimento;
    String nombre;
    String tipo;
    String cantidad;

    public Alimento(String id_alimento, String nombre, String tipo, String cantidad) {
        this.id_alimento = id_alimento;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }

    public Alimento() {
    }

    public String getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(String id_alimento) {
        this.id_alimento = id_alimento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "id_alimento='" + id_alimento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}

package com.sofkau.integration.models;

public class Alimento {
    private String id_alimento;
    private String nombre_alimento;
    private String tipo_alimento;
    private String cantidad;

    public Alimento(String id_alimento, String nombre_alimento, String tipo_alimento, String cantidad) {
        this.id_alimento = id_alimento;
        this.nombre_alimento = nombre_alimento;
        this.tipo_alimento = tipo_alimento;
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

    public String getNombre_alimento() {
        return nombre_alimento;
    }

    public void setNombre_alimento(String nombre_alimento) {
        this.nombre_alimento = nombre_alimento;
    }

    public String getTipo_alimento() {
        return tipo_alimento;
    }

    public void setTipo_alimento(String tipo_alimento) {
        this.tipo_alimento = tipo_alimento;
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
                ", nombre_alimento='" + nombre_alimento + '\'' +
                ", tipo_alimento='" + tipo_alimento + '\'' +
                ", cantidad='" + cantidad + '\'' +
                '}';
    }
}

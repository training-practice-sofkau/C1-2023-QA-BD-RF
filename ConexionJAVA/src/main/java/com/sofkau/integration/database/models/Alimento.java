package com.sofkau.integration.database.models;

public class Alimento {
    private String id_alimento;
    private String tipo_alimento ;
    private String cantidad ;
    private String nombre ;

    public Alimento(String id_alimento, String tipo_alimento, String cantidad, String nombre) {
        this.id_alimento = id_alimento;
        this.tipo_alimento = tipo_alimento;
        this.cantidad = cantidad;
        this.nombre = nombre;
    }
    public Alimento (){}


    public String getId_alimento() {
        return id_alimento;
    }

    public void setId_alimento(String id_alimento) {
        this.id_alimento = id_alimento;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}

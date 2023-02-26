package com.sofkau.models;

public class Dieta {

    private String id;
    private String nombre;
    private String dosis;
    private String veterinarioId;

    public Dieta() {
    }

    public Dieta(String id, String nombre, String dosis, String veterinarioId) {
        this.id = id;
        this.nombre = nombre;
        this.dosis = dosis;
        this.veterinarioId = veterinarioId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getVeterinarioId() {
        return veterinarioId;
    }

    public void setVeterinarioId(String veterinarioId) {
        this.veterinarioId = veterinarioId;
    }
}

package com.sofkau.integration.database.models;

public class Dieta {
    String id_dieta;
    String nombre_dieta;
    String dosis;
    String veterinario_id;

    public Dieta(String id_dieta, String nombre_dieta, String dosis, String veterinario_id) {
        this.id_dieta = id_dieta;
        this.nombre_dieta = nombre_dieta;
        this.dosis = dosis;
        this.veterinario_id = veterinario_id;
    }

    public Dieta() {
    }

    public String getId_dieta() {
        return id_dieta;
    }

    public void setId_dieta(String id_dieta) {
        this.id_dieta = id_dieta;
    }

    public String getNombre_dieta() {
        return nombre_dieta;
    }

    public void setNombre_dieta(String nombre_dieta) {
        this.nombre_dieta = nombre_dieta;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getVeterinario_id() {
        return veterinario_id;
    }

    public void setVeterinario_id(String veterinario_id) {
        this.veterinario_id = veterinario_id;
    }

    @Override
    public String toString() {
        return "Dieta{" +
                "id_dieta='" + id_dieta + '\'' +
                ", nombre_dieta='" + nombre_dieta + '\'' +
                ", dosis='" + dosis + '\'' +
                ", veterinario_id='" + veterinario_id + '\'' +
                '}';
    }
}

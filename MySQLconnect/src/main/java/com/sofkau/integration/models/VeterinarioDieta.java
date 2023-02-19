package com.sofkau.integration.models;

public class VeterinarioDieta {
    private String id_veterinario_dieta;
    private String id_dieta_veterinario;

    public VeterinarioDieta(String id_veterinario_dieta, String id_dieta_veterinario) {
        this.id_veterinario_dieta = id_veterinario_dieta;
        this.id_dieta_veterinario = id_dieta_veterinario;
    }

    public VeterinarioDieta() {
    }

    public String getId_veterinario_dieta() {
        return id_veterinario_dieta;
    }

    public void setId_veterinario_dieta(String id_veterinario_dieta) {
        this.id_veterinario_dieta = id_veterinario_dieta;
    }

    public String getId_dieta_veterinario() {
        return id_dieta_veterinario;
    }

    public void setId_dieta_veterinario(String id_dieta_veterinario) {
        this.id_dieta_veterinario = id_dieta_veterinario;
    }

    @Override
    public String toString() {
        return "VeterinarioDieta{" +
                "id_veterinario_dieta='" + id_veterinario_dieta + '\'' +
                ", id_dieta_veterinario='" + id_dieta_veterinario + '\'' +
                '}';
    }
}

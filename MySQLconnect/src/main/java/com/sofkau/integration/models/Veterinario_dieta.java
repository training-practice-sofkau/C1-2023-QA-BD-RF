package com.sofkau.integration.models;

public class Veterinario_dieta {
    String idVeterinario;
    String idDieta;

    public Veterinario_dieta(String idVeterinario, String idDieta) {
        this.idVeterinario = idVeterinario;
        this.idDieta = idDieta;
    }

    public Veterinario_dieta() {
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(String idDieta) {
        this.idDieta = idDieta;
    }
    @Override
    public String toString() {
        return "Veterinario_dieta{" +
                "idVeterinario='" + idVeterinario + '\'' +
                ", idDieta='" + idDieta + '\'' +
                '}';
    }
}

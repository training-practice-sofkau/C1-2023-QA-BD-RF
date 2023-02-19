package com.sofkau.integration.models;

public class Veterinario {
    String idVeterinario;
    String nombreVeterinario;

    public Veterinario() {
    }

    public Veterinario(String idVeterinario, String nombreVeterinario) {
        this.idVeterinario = idVeterinario;
        this.nombreVeterinario = nombreVeterinario;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNombreVeterinario() {
        return nombreVeterinario;
    }

    public void setNombreVeterinario(String nombreVeterinario) {
        this.nombreVeterinario = nombreVeterinario;
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "idVeterinario='" + idVeterinario + '\'' +
                ", nombreVeterinario='" + nombreVeterinario + '\'' +
                '}';
    }
}

package com.sofkau.integration.models;

public class Entrenador_veterinario {
    String idEntrenador;
    String idVeterinario;

    public Entrenador_veterinario(String idEntrenador, String idVeterinario) {
        this.idEntrenador = idEntrenador;
        this.idVeterinario = idVeterinario;
    }

    public Entrenador_veterinario() {
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    @Override
    public String toString() {
        return "Entrenador_veterinario{" +
                "idEntrenador='" + idEntrenador + '\'' +
                ", idVeterinario='" + idVeterinario + '\'' +
                '}';
    }
}

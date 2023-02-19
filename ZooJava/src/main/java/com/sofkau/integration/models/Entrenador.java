package com.sofkau.integration.models;

public class Entrenador {

    String idEntrenador;
    String nombreEntrenador;

    public Entrenador() {
    }

    public Entrenador(String idEntrenador, String nombreEntrenador) {
        this.idEntrenador = idEntrenador;
        this.nombreEntrenador = nombreEntrenador;
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "idEntrenador='" + idEntrenador + '\'' +
                ", nombreEntrenador='" + nombreEntrenador + '\'' +
                '}';
    }
}

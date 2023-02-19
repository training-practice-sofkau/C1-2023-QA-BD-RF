package com.sofkau.integration.models;

public class Entrenador {

    String idEntrenador;
    String nombre_eentrenador;
    String telefono_entrenador;

    public Entrenador(String idEntrenador, String nombre_eentrenador, String telefono_entrenador) {
        this.idEntrenador = idEntrenador;
        this.nombre_eentrenador = nombre_eentrenador;
        this.telefono_entrenador = telefono_entrenador;
    }

    public Entrenador() {
    }

    public String getIdEntrenador() {
        return idEntrenador;
    }

    public void setIdEntrenador(String idEntrenador) {
        this.idEntrenador = idEntrenador;
    }

    public String getNombre_eentrenador() {
        return nombre_eentrenador;
    }

    public void setNombre_eentrenador(String nombre_eentrenador) {
        this.nombre_eentrenador = nombre_eentrenador;
    }

    public String getTelefono_entrenador() {
        return telefono_entrenador;
    }

    public void setTelefono_entrenador(String telefono_entrenador) {
        this.telefono_entrenador = telefono_entrenador;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "idEntrenador='" + idEntrenador + '\'' +
                ", nombre_eentrenador='" + nombre_eentrenador + '\'' +
                ", telefono_entrenador='" + telefono_entrenador + '\'' +
                '}';
    }
}
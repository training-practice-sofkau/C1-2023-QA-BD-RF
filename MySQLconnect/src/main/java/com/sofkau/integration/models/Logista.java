package com.sofkau.integration.models;

public class Logista {
    String idlogista;
    String nombre_logista;
    String telefono_logista;

    public Logista(String idlogista, String nombre_logista, String telefono_logista) {
        this.idlogista = idlogista;
        this.nombre_logista = nombre_logista;
        this.telefono_logista = telefono_logista;
    }

    public Logista() {
    }

    public String getIdlogista() {
        return idlogista;
    }

    public void setIdlogista(String idlogista) {
        this.idlogista = idlogista;
    }

    public String getNombre_logista() {
        return nombre_logista;
    }

    public void setNombre_logista(String nombre_logista) {
        this.nombre_logista = nombre_logista;
    }

    public String getTelefono_logista() {
        return telefono_logista;
    }

    public void setTelefono_logista(String telefono_logista) {
        this.telefono_logista = telefono_logista;
    }

    @Override
    public String toString() {
        return "Logista{" +
                "idlogista='" + idlogista + '\'' +
                ", nombre_logista='" + nombre_logista + '\'' +
                ", telefono_logista='" + telefono_logista + '\'' +
                '}';
    }
}

package com.sofkau.integration.models;

public class Entrenador {
    private String id_entrenador;
    private String nombre_entrenador;
    private String apellido_entrenador;
    private String telefono;

    public Entrenador(String id_entrenador, String nombre_entrenador, String apellido_entrenador, String telefono) {
        this.id_entrenador = id_entrenador;
        this.nombre_entrenador = nombre_entrenador;
        this.apellido_entrenador = apellido_entrenador;
        this.telefono = telefono;
    }

    public Entrenador() {
    }

    public String getId_entrenador() {
        return id_entrenador;
    }

    public void setId_entrenador(String id_entrenador) {
        this.id_entrenador = id_entrenador;
    }

    public String getNombre_entrenador() {
        return nombre_entrenador;
    }

    public void setNombre_entrenador(String nombre_entrenador) {
        this.nombre_entrenador = nombre_entrenador;
    }

    public String getApellido_entrenador() {
        return apellido_entrenador;
    }

    public void setApellido_entrenador(String apellido_entrenador) {
        this.apellido_entrenador = apellido_entrenador;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Entrenador{" +
                "id_entrenador='" + id_entrenador + '\'' +
                ", nombre_entrenador='" + nombre_entrenador + '\'' +
                ", apellido_entrenador='" + apellido_entrenador + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

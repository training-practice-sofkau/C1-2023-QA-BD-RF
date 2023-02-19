package com.sofkau.integration.database.models;

public class Entrenador {
    String id_entrenador;
    String nombre;
    String telefono;

    public Entrenador(String id_entrenador, String nombre, String telefono) {
        this.id_entrenador = id_entrenador;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}



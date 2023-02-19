package com.sofkau.integration.models;

public class Veterinario {
    private String id_veterinario;
    private String nombre;
    private String apellido;
    private String telefono;

    public Veterinario(String id_veterinario, String nombre, String apellido, String telefono) {
        this.id_veterinario = id_veterinario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Veterinario() {
    }

    public String getId_veterinario() {
        return id_veterinario;
    }

    public void setId_veterinario(String id_veterinario) {
        this.id_veterinario = id_veterinario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Veterinarios{" +
                "id_veterinario='" + id_veterinario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

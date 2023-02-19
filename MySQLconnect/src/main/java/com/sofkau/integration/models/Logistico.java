package com.sofkau.integration.models;

public class Logistico {
    private String id_logistico;
    private String nombre;
    private String apellido;
    private String telefono;

    public Logistico(String id_logistico, String nombre, String apellido, String telefono) {
        this.id_logistico = id_logistico;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public Logistico() {
    }

    public String getId_logistico() {
        return id_logistico;
    }

    public void setId_logistico(String id_logistico) {
        this.id_logistico = id_logistico;
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
        return "Logistico{" +
                "id_logistico='" + id_logistico + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

package com.sofkau.models;

public class Proveedor {

    private String NIT;
    private String nombre;
    private String telefono;

    public Proveedor() {
    }

    public Proveedor(String NIT, String nombre, String telefono) {
        this.NIT = NIT;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNIT() {
        return NIT;
    }

    public void setNIT(String NIT) {
        this.NIT = NIT;
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
        return "Proveedor{" +
                "NIT='" + NIT + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}

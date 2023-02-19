package com.sofkaU.integration.database.models;

public class Proveedor {
    Integer Nit;
    String nombre;
    String direccion;

    public Proveedor(Integer nit, String nombre, String direccion) {
        Nit = nit;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Proveedor() {
    }

    public Integer getNit() {
        return Nit;
    }

    public void setNit(Integer nit) {
        Nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

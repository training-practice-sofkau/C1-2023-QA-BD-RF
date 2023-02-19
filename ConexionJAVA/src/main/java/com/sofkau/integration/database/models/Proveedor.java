package com.sofkau.integration.database.models;

public class Proveedor {

    private String  id_proveedor;
    private String nombre_proveedor;
    private String direccion;

    public Proveedor(String id_proveedor, String nombre_proveedor, String direccion) {
        this.id_proveedor = id_proveedor;
        this.nombre_proveedor = nombre_proveedor;
        this.direccion = direccion;
    }
    public Proveedor(){}

    public String getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(String id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}

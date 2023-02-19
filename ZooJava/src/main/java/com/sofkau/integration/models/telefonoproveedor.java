package com.sofkau.integration.models;


public class telefonoproveedor {
    String proveedorId;
    String numero;

    public telefonoproveedor() {
    }

    public telefonoproveedor(String proveedorId, String numero) {
        this.proveedorId = proveedorId;
        this.numero = numero;
    }

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "telefonoproveedor{" +
                "proveedorId='" + proveedorId + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }
}
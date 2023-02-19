package com.sofkau.integration.models;

public class Proveedores_alimento {
    String idProveedores;
    String idAlimento;

    public Proveedores_alimento(String idProveedores, String idAlimento) {
        this.idProveedores = idProveedores;
        this.idAlimento = idAlimento;
    }

    public Proveedores_alimento() {
    }

    public String getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(String idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getIdAlimento() {
        return idAlimento;
    }

    public void setIdAlimento(String idAlimento) {
        this.idAlimento = idAlimento;
    }

    @Override
    public String toString() {
        return "Proveedores_alimento{" +
                "idProveedores='" + idProveedores + '\'' +
                ", idAlimento='" + idAlimento + '\'' +
                '}';
    }
}

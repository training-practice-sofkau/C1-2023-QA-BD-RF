package com.sofkau.integration.models;

public class Proveedor {
   String idproveedor;
   String nombreProveedor;

    public Proveedor() {
    }

    public Proveedor(String idproveedor, String nombreProveedor) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
    }

    public String getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(String idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "idproveedor='" + idproveedor + '\'' +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                '}';
    }
}

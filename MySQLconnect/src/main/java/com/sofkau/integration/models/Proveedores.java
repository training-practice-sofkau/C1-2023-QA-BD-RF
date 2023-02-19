package com.sofkau.integration.models;

public class Proveedores {
   String idProveedores;
   String nombre_proveedor;
   String telefono_proveedor;

    public Proveedores(String idProveedores, String nombre_proveedor, String telefono_proveedor) {
        this.idProveedores = idProveedores;
        this.nombre_proveedor = nombre_proveedor;
        this.telefono_proveedor = telefono_proveedor;
    }

    public Proveedores() {
    }

    public String getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(String idProveedores) {
        this.idProveedores = idProveedores;
    }

    public String getNombre_proveedor() {
        return nombre_proveedor;
    }

    public void setNombre_proveedor(String nombre_proveedor) {
        this.nombre_proveedor = nombre_proveedor;
    }

    public String getTelefono_proveedor() {
        return telefono_proveedor;
    }

    public void setTelefono_proveedor(String telefono_proveedor) {
        this.telefono_proveedor = telefono_proveedor;
    }

    @Override
    public String toString() {
        return "Proveedores{" +
                "idProveedores='" + idProveedores + '\'' +
                ", nombre_proveedor='" + nombre_proveedor + '\'' +
                ", telefono_proveedor='" + telefono_proveedor + '\'' +
                '}';
    }
}

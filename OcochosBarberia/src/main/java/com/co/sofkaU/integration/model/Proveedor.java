package com.co.sofkaU.integration.model;

import lombok.Data;

@Data
public class Proveedor {
    private int idProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;

    public Proveedor(String nombreProveedor, String telefonoProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
    }
}

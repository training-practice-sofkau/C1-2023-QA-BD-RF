package com.sofkau.database.clases;

public class ProductoProveedor {
    private String razon_social;
    private String nombre_prod;

    public ProductoProveedor(String razon_social, String nombre_prod) {
        this.razon_social = razon_social;
        this.nombre_prod = nombre_prod;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }
}

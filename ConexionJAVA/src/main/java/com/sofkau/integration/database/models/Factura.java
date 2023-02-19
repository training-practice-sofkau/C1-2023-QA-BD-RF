package com.sofkau.integration.database.models;

public class Factura {


    private String id_factura;
    private String cantidad_total;
    private String cantidad_productos;
    private String id_proveedor_f;

    public Factura(String id_factura, String cantidad_total, String cantidad_productos, String id_proveedor_f) {
        this.id_factura = id_factura;
        this.cantidad_total = cantidad_total;
        this.cantidad_productos = cantidad_productos;
        this.id_proveedor_f = id_proveedor_f;
    }

    public Factura(){}

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getCantidad_total() {
        return cantidad_total;
    }

    public void setCantidad_total(String cantidad_total) {
        this.cantidad_total = cantidad_total;
    }

    public String getCantidad_productos() {
        return cantidad_productos;
    }

    public void setCantidad_productos(String cantidad_productos) {
        this.cantidad_productos = cantidad_productos;
    }

    public String getId_proveedor_f() {
        return id_proveedor_f;
    }

    public void setId_proveedor_f(String id_proveedor_f) {
        this.id_proveedor_f = id_proveedor_f;
    }
}

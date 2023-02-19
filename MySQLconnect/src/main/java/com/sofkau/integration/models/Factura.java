package com.sofkau.integration.models;

public class Factura {
    String idFactura;
    String precio_factura;
    String cantidad_factura;
    String idProveedores;

    public Factura(String idFactura, String precio_factura, String cantidad_factura, String idProveedores) {
        this.idFactura = idFactura;
        this.precio_factura = precio_factura;
        this.cantidad_factura = cantidad_factura;
        this.idProveedores = idProveedores;
    }
    public Factura() {
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getPrecio_factura() {
        return precio_factura;
    }

    public void setPrecio_factura(String precio_factura) {
        this.precio_factura = precio_factura;
    }

    public String getCantidad_factura() {
        return cantidad_factura;
    }

    public void setCantidad_factura(String cantidad_factura) {
        this.cantidad_factura = cantidad_factura;
    }

    public String getIdProveedores() {
        return idProveedores;
    }

    public void setIdProveedores(String idProveedores) {
        this.idProveedores = idProveedores;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura='" + idFactura + '\'' +
                ", precio_factura='" + precio_factura + '\'' +
                ", cantidad_factura='" + cantidad_factura + '\'' +
                ", idProveedores='" + idProveedores + '\'' +
                '}';
    }
}

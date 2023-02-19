package com.sofkau.integration.models;

public class Factura {
    String idFactura;
    String id_alimento_factura;
    String cantidad;
    String precio;
    String proveedorIdFactura;

    public Factura() {
    }

    public Factura(String idFactura, String id_alimento_factura, String cantidad, String precio, String proveedorIdFactura) {
        this.idFactura = idFactura;
        this.id_alimento_factura = id_alimento_factura;
        this.cantidad = cantidad;
        this.precio = precio;
        this.proveedorIdFactura = proveedorIdFactura;
    }

    public String getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }

    public String getId_alimento_factura() {
        return id_alimento_factura;
    }

    public void setId_alimento_factura(String id_alimento_factura) {
        this.id_alimento_factura = id_alimento_factura;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getProveedorIdFactura() {
        return proveedorIdFactura;
    }

    public void setProveedorIdFactura(String proveedorIdFactura) {
        this.proveedorIdFactura = proveedorIdFactura;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "idFactura='" + idFactura + '\'' +
                ", id_alimento_factura='" + id_alimento_factura + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", precio='" + precio + '\'' +
                ", proveedorIdFactura='" + proveedorIdFactura + '\'' +
                '}';
    }
}

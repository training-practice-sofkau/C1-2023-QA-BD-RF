package com.sofkau.integration.database.models;

public class Factura {
    String id_factura;
    String fecha;
    String detalle;
    String total;
    String proveedor_id_o;

    public Factura(String id_factura, String fecha, String detalle, String total, String proveedor_id_o) {
        this.id_factura = id_factura;
        this.fecha = fecha;
        this.detalle =  detalle;
        this.total = total;
        this.proveedor_id_o = proveedor_id_o;
    }

    public Factura() {
    }

    public String getId_factura() {
        return id_factura;
    }

    public void setId_factura(String id_factura) {
        this.id_factura = id_factura;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getProveedor_id_o() {
        return proveedor_id_o;
    }

    public void setProveedor_id_o(String proveedor_id_o) {
        this.proveedor_id_o = proveedor_id_o;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }
}

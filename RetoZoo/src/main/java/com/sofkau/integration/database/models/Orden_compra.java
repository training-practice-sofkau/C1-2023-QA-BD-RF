package com.sofkau.integration.database.models;

public class Orden_compra {
    String id_orden;
    String fecha;
    String detalle;
    String logistico_id_p;
    String proveedor_id_l;

    public Orden_compra(String id_orden, String fecha, String detalle, String logistico_id_p, String proveedor_id_l) {
        this.id_orden = id_orden;
        this.fecha = fecha;
        this.detalle = detalle;
        this.logistico_id_p = logistico_id_p;
        this.proveedor_id_l = proveedor_id_l;
    }

    public Orden_compra() {
    }

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getLogistico_id_p() {
        return logistico_id_p;
    }

    public void setLogistico_id_p(String ogistico_id_p) {
        this.logistico_id_p = ogistico_id_p;
    }

    public String getProveedor_id_l() {
        return proveedor_id_l;
    }

    public void setProveedor_id_l(String proveedor_id_l) {
        this.proveedor_id_l = proveedor_id_l;
    }
}

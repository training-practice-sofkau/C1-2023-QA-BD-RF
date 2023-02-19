package com.sofkau.integration.models;

public class OrdenCompra {
    private String id_orden;
    private String fecha_emision;
    private String fecha_entrega;
    private String descripcion;
    private String nit_proveedor_orden;
    private String id_logistico_orden;

    public OrdenCompra(String id_orden, String fecha_emision, String fecha_entrega, String descripcion, String nit_proveedor_orden, String id_logistico_orden) {
        this.id_orden = id_orden;
        this.fecha_emision = fecha_emision;
        this.fecha_entrega = fecha_entrega;
        this.descripcion = descripcion;
        this.nit_proveedor_orden = nit_proveedor_orden;
        this.id_logistico_orden = id_logistico_orden;
    }

    public OrdenCompra() {
    }

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(String fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNit_proveedor_orden() {
        return nit_proveedor_orden;
    }

    public void setNit_proveedor_orden(String nit_proveedor_orden) {
        this.nit_proveedor_orden = nit_proveedor_orden;
    }

    public String getId_logistico_orden() {
        return id_logistico_orden;
    }

    public void setId_logistico_orden(String id_logistico_orden) {
        this.id_logistico_orden = id_logistico_orden;
    }

    @Override
    public String toString() {
        return "orden_compra{" +
                "id_orden='" + id_orden + '\'' +
                ", fecha_emision='" + fecha_emision + '\'' +
                ", fecha_entrega='" + fecha_entrega + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", nit_proveedor_orden='" + nit_proveedor_orden + '\'' +
                ", id_logistico_orden='" + id_logistico_orden + '\'' +
                '}';
    }
}

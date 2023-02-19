package com.sofkau.integration.database.models;

public class OrdenCompra {
    private String id_orden ;
    private String fecha_de_elaboracion ;
    private String fecha_de_entrega ;
    private String descripcion ;
    private String id_empleado_logistico_o ;
    private String id_proveedor_o ;

    public OrdenCompra(String id_orden, String fecha_de_elaboracion, String fecha_de_entrega, String descripcion, String id_empleado_logistico_o, String id_proveedor_o) {
        this.id_orden = id_orden;
        this.fecha_de_elaboracion = fecha_de_elaboracion;
        this.fecha_de_entrega = fecha_de_entrega;
        this.descripcion = descripcion;
        this.id_empleado_logistico_o = id_empleado_logistico_o;
        this.id_proveedor_o = id_proveedor_o;
    }

    public OrdenCompra(){}

    public String getId_orden() {
        return id_orden;
    }

    public void setId_orden(String id_orden) {
        this.id_orden = id_orden;
    }

    public String getFecha_de_elaboracion() {
        return fecha_de_elaboracion;
    }

    public void setFecha_de_elaboracion(String fecha_de_elaboracion) {
        this.fecha_de_elaboracion = fecha_de_elaboracion;
    }

    public String getFecha_de_entrega() {
        return fecha_de_entrega;
    }

    public void setFecha_de_entrega(String fecha_de_entrega) {
        this.fecha_de_entrega = fecha_de_entrega;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId_empleado_logistico_o() {
        return id_empleado_logistico_o;
    }

    public void setId_empleado_logistico_o(String id_empleado_logistico_o) {
        this.id_empleado_logistico_o = id_empleado_logistico_o;
    }

    public String getId_proveedor_o() {
        return id_proveedor_o;
    }

    public void setId_proveedor_o(String id_proveedor) {
        this.id_proveedor_o = id_proveedor;
    }
}

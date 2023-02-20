package com.sofkau.models;

public class Factura {

    private String id;
    private String fecha;
    private String total;
    private String idProveedor;
    private String empleadoLogisticoId;
    private String unidades;

    public Factura() {
    }

    public Factura(String id, String fecha, String total, String idProveedor, String empleadoLogisticoId, String unidades) {
        this.id = id;
        this.fecha = fecha;
        this.total = total;
        this.idProveedor = idProveedor;
        this.empleadoLogisticoId = empleadoLogisticoId;
        this.unidades = unidades;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getEmpleadoLogisticoId() {
        return empleadoLogisticoId;
    }

    public void setEmpleadoLogisticoId(String empleadoLogisticoId) {
        this.empleadoLogisticoId = empleadoLogisticoId;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }
}

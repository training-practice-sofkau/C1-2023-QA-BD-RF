package com.sofkau.models;

public class OrdenCompra {

    private String id;
    private String fecha;
    private String proveedorId;
    private String empleadoLogisticoId;
    private String unidades;


    public OrdenCompra() {
    }

    public OrdenCompra(String id, String fecha, String proveedorId, String empleadoLogisticoId, String unidades) {
        this.id = id;
        this.fecha = fecha;
        this.proveedorId = proveedorId;
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

    public String getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(String proveedorId) {
        this.proveedorId = proveedorId;
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

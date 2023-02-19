package com.sofkau.integration.models;

public class OrdenesCompra {
    String idOrdenesCompra;
    String nombreOrden;
    String fechaOrden;
    String descripcion;
    String ordenProveedorId;
    String logisticoIdOrden;

    public OrdenesCompra() {
    }

    public OrdenesCompra(String idOrdenesCompra, String nombreOrden, String fechaOrden, String descripcion, String ordenProveedorId, String logisticoIdOrden) {
        this.idOrdenesCompra = idOrdenesCompra;
        this.nombreOrden = nombreOrden;
        this.fechaOrden = fechaOrden;
        this.descripcion = descripcion;
        this.ordenProveedorId = ordenProveedorId;
        this.logisticoIdOrden = logisticoIdOrden;
    }

    public String getIdOrdenesCompra() {
        return idOrdenesCompra;
    }

    public void setIdOrdenesCompra(String idOrdenesCompra) {
        this.idOrdenesCompra = idOrdenesCompra;
    }

    public String getNombreOrden() {
        return nombreOrden;
    }

    public void setNombreOrden(String nombreOrden) {
        this.nombreOrden = nombreOrden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getOrdenProveedorId() {
        return ordenProveedorId;
    }

    public void setOrdenProveedorId(String ordenProveedorId) {
        this.ordenProveedorId = ordenProveedorId;
    }

    public String getLogisticoIdOrden() {
        return logisticoIdOrden;
    }

    public void setLogisticoIdOrden(String logisticoIdOrden) {
        this.logisticoIdOrden = logisticoIdOrden;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    @Override
    public String toString() {
        return "OrdenesCompra{" +
                "idOrdenesCompra='" + idOrdenesCompra + '\'' +
                ", nombreOrden='" + nombreOrden + '\'' +
                ", fechaOrden='" + fechaOrden + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", ordenProveedorId='" + ordenProveedorId + '\'' +
                ", logisticoIdOrden='" + logisticoIdOrden + '\'' +
                '}';
    }
}

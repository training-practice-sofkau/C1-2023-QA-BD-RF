package com.sofkaU.integration.database.models;

public class Cotizacion {
    Integer id;
    String descripcion;
    Integer idCliente;
    Integer idEmpleado;

    public Cotizacion(Integer id, String descripcion, Integer idCliente, Integer idEmpleado) {
        this.id = id;
        this.descripcion = descripcion;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
    }

    public Cotizacion() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "cotizacion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", idCliente=" + idCliente +
                ", idEmpleado=" + idEmpleado +
                '}';
    }
}

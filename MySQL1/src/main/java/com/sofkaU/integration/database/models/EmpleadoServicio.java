package com.sofkaU.integration.database.models;

public class EmpleadoServicio {
    Integer idServicio;
    Integer idEmpleado;

    public EmpleadoServicio(Integer idServicio, Integer idEmpleado) {
        this.idServicio = idServicio;
        this.idEmpleado = idEmpleado;
    }

    public EmpleadoServicio() {
    }

    public Integer getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Integer idServicio) {
        this.idServicio = idServicio;
    }

    public Integer getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Integer idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return "EmpleadoServicio{" +
                "idServicio=" + idServicio +
                ", idEmpleado=" + idEmpleado +
                '}';
    }
}

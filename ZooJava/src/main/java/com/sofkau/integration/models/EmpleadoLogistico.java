package com.sofkau.integration.models;

public class EmpleadoLogistico {

    String idEmpleadoLogistico;
    String nombreLogistico;

    public EmpleadoLogistico() {
    }

    public EmpleadoLogistico(String idEmpleadoLogistico, String nombreLogistico) {
        this.idEmpleadoLogistico = idEmpleadoLogistico;
        this.nombreLogistico = nombreLogistico;
    }

    public String getIdEmpleadoLogistico() {
        return idEmpleadoLogistico;
    }

    public void setIdEmpleadoLogistico(String idEmpleadoLogistico) {
        this.idEmpleadoLogistico = idEmpleadoLogistico;
    }

    public String getNombreLogistico() {
        return nombreLogistico;
    }

    public void setNombreLogistico(String nombreLogistico) {
        this.nombreLogistico = nombreLogistico;
    }

    @Override
    public String toString() {
        return "EmpleadoLogistico{" +
                "idEmpleadoLogistico='" + idEmpleadoLogistico + '\'' +
                ", nombreLogistico='" + nombreLogistico + '\'' +
                '}';
    }
}

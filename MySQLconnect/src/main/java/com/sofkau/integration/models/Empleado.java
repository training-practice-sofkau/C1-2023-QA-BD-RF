package com.sofkau.integration.models;

public class Empleado {
    private int idEmpleado;
    private String cedula;
    private String nombreEmpleado;
    private String especialidad;

    public Empleado(int idEmpleado, String cedula, String nombreEmpleado, String especialidad) {
        this.idEmpleado = idEmpleado;
        this.cedula = cedula;
        this.nombreEmpleado = nombreEmpleado;
        this.especialidad = especialidad;
    }


    public Empleado() {
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}

package com.sofkau.mysql.model;

public class Empleado {
    private Integer id;
    private String cedula;
    private String especialidad;

    private String nombre;

    public Empleado(String cedula, String especialidad,  String nombre) {
        this.cedula = cedula;
        this.especialidad = especialidad;
        this.nombre = nombre;
    }

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}

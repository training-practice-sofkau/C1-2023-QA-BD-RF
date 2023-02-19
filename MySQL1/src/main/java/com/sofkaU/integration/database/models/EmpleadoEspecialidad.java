package com.sofkaU.integration.database.models;

public class EmpleadoEspecialidad {
    Integer id;
    String especialidad;

    public EmpleadoEspecialidad(Integer id, String especialidad) {
        this.id = id;
        this.especialidad = especialidad;
    }

    public EmpleadoEspecialidad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "EmpleadoEspecialidad{" +
                "id=" + id +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}
